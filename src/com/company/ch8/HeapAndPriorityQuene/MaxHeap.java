package com.company.ch8.HeapAndPriorityQuene;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
                siftDown(i);
        }
    }


    // 返回堆中的元素個素
    public int size(){
        return data.getLength();
    }

    // 返回一個布爾值，表示堆中是否為空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉樹的數據表示中，一個索引所表示的元素的父親節點的索引
    public int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index -1)/2;
    }

    // 返回完全二叉樹的數組表示中，一個索引所表示的左孩子節點的索引
    public int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉樹的數組表示中，一個索引所表示的右孩子節點的索引
    public int rightChild(int index){
        return index * 2 + 2;
    }

    // 像堆中添加元素
    public  void add(E e){
        data.addLast(e);
        siftUp(data.getLength() - 1);
    }

    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }

    }


    // 看堆中的最大元素
    public E findMax(){

        if(data.getLength() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMax(){

        E ret = findMax();
        data.swap(0, data.getLength()-1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {

    while (leftChild(k) < data.getLength()){
        int j = leftChild(k);// 在此輪循環中，data[k] 和 data[j] 交換位置
        if (j+1 < data.getLength() && data.get(j+1).compareTo(data.get(j)) > 0)
            j++;

        // data[j] 是 leftChild 和 rightChild 中的最大值
        if (data.get(k).compareTo(data.get(j)) >= 0)
            break;

        data.swap(k,j);
        k = j;
    }


    }

    // 取出堆中的最大元素，並且替換成元素e
    public E replace(E e){

        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;



    }





}
