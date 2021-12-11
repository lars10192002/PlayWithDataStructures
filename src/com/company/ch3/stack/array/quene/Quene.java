package com.company.ch3.stack.array.quene;

public interface Quene<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
