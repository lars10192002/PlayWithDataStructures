package com.company.ch3.stack.array.quene;

public class LoopQuene<E> implements Quene<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQuene(int capacity){
        data = (E[])new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }


    public LoopQuene(){
        this(10);
    }

    public int getCapacity(int capacity){
        return data.length-1;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
}
