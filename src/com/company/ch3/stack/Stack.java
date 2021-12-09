package com.company.ch3.stack;

public interface Stack<E> {

    int getSize(); // 查容量
    boolean isEmpty(); // 為空
    void push(E e); //入棧
    E pop(); //出棧
    E peek(); // 看一下頂端

}
