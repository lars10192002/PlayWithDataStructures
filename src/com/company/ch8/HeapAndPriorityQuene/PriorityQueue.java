package com.company.ch8.HeapAndPriorityQuene;



public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E>  maxHeap;


    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enquene(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequene() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
