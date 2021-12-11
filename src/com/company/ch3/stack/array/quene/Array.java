package com.company.ch3.stack.array.quene;

public class Array<E> {
    private E[] data; // data預設值null
    private int length; // length預設值null

    //在物件建立的初始流程定義Array類別，使用建構式設定預設值，data = 設為動態容量，會將陣列的capacity傳入建構陣列
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        this.length = 0;
    }

    //沒有參數的建構式，容量預設值為10
    public Array(){
        this(10);
    }

    //得到陣列的動態容量
    public int getCapacity() {
        return data.length;
    }

    //得到陣列中的元素個數 = get size
    public int getLength() {
        return length;
    }

    //回傳陣列是否為空
    public boolean isEmpty(){
        return length == 0 ;
    }

    public void addLast( E element){
        add(length, element);
    }

    public void addFirst(E element){
        add(0,element);
    }

    public void add(int index, E element){
        // 1. 檢查陣列長度是否塞滿
        // 2. 檢查陣列內是否為0 || 索引是否小於目前陣列的長度 => 改成當陣列滿時，使用resize改變陣列大小(2X)
        // 3. 實作彈性且隨機插入元素的彈性陣列

        if(length == data.length)
            resize(2 * data.length);

        if(index < 0 || index > length)
            throw new IllegalArgumentException("Add failed. Array is full.");


        // 指定陣列位置插入元素，當指定位置不為空時，將陣列元素重新移位排列
        // length = 目前陣列長度
        for(int i = length -1; i >= index ; i --){
            System.out.println("index = "+index+" length = "+length);
            data[i+1] = data[i];
        }

        // 當插入陣列位置為空時，直接塞入
        data[index] = element;

        length++;

    }


    //獲取index 索引位置的元素
    public E get(int index){
        //檢查索引異常
        if(index <0 || index >= length)
            throw new IllegalArgumentException("Get faild. Index is illegal.");
        return  data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(length-1);
    }


    //修改index 索引位置的元素為e
    public void set(int index, E element){
        //檢查索引異常
        if (index < 0 || index >= length)
            throw new IllegalArgumentException("Set filed. Index is illegal.");
        data[index] = element;
    }


    // 查找陣列中是否有元素e
    public boolean contain(E e){
        for(int i=0 ; i<length; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }


    // 查找陣列中元素e所在的索引，如果不存在元素e,則返回-1
    public int find(E e){
        for (int i = 0; i < length; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }


    // 從數組中刪除index位置的元素，返回刪除的元素
    public E remove(int index){
        if (index < 0 || index >= length)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for (int i = index + 1; i <length ; i++)
            data[i-1] = data[i];
        length --;
        data[length] = null; //loitering objects != memory leak

        //檢查現在使用的陣列大小，如果未使用的陣列太多，lazy 一點 查到1/4的時候在做縮減容量。
        if(length == data.length/4 && data.length /2 != 0)
            resize(data.length/2);

        return ret;
    }

    // 從陣列中刪除第一個元素，返回刪除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 從陣列中刪除最後一個元素，返回刪除的元素
    public E removeLast(){
        return remove(length-1);
    }


    // 從陣列中刪除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }




    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", length, data.length));
        res.append("[");

        for (int i=0;i<length;i++){
            res.append(data[i]);
            if(i != length-1)
                res.append(", ");
        }
        res.append("]");
        return res.toString();

    }


    private void resize(int newCapacity){
        E[] newData =(E[]) new Object[newCapacity];
        for (int i = 0; i < length; i++)
            newData[i] = data[i];

        // 將data 指向新陣列的位置
        data = newData;

    }

}
