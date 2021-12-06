package com.company.ch2.array;

public class Array {
    private int[] data; // data預設值null
    private int length; // length預設值null

    //在物件建立的初始流程定義Array類別，使用建構式設定預設值，data = 設為動態容量，會將陣列的capacity傳入建構陣列
    public Array(int capacity) {
        this.data = new int[capacity];
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

    //得到陣列中的元素個數
    public int getLength() {
        return length;
    }

    //回傳陣列是否為空
    public boolean isEmpty(){
        return length == 0 ;
    }

    public void addLast( int element){
        add(length, element);
    }

    public void addFirst(int element){
        add(0,element);
    }

    public void add(int index, int element){
        // 1. 檢查陣列長度是否塞滿
        // 2. 檢查陣列內是否為0 || 索引是否小於目前陣列的長度
        // 3. 實作彈性且隨機插入元素的彈性陣列

        if(length == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");

        if(index < 0 || index > length)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

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
    public int get(int index){
        //檢查索引異常
        if(index <0 || index >= length)
            throw new IllegalArgumentException("Get faild. Index is illegal.");
        return  data[index];
    }


    //修改index 索引位置的元素為e
    public void set(int index, int element){
        //檢查索引異常
        if (index < 0 || index >= length)
            throw new IllegalArgumentException("Set filed. Index is illegal.");
        data[index] = element;
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

}
