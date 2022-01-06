package com.company.ch8.HeapAndPriorityQuene;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
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


}
