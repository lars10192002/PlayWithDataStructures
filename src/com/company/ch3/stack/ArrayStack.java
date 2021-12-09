package com.company.ch3.stack;

import com.company.ch2.array.Array;

public class ArrayStack<E> implements Stack<E> {
    private Array<E> arr;

    public ArrayStack(int capacity) {
        arr = new Array<>(capacity);
    }

    public ArrayStack(){
        arr = new Array<>();
    }

    @Override
    public int getSize() {
        return arr.getLength();
    }

    public int getCapacity(){
        return arr.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.getLast();
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < arr.getLength(); i++) {
            res.append(arr.get(i));
            if(i != arr.getLength() -1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();

    }
}
