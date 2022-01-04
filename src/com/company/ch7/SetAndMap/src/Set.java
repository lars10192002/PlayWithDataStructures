package com.company.ch7.SetAndMap.src;

public interface Set <E>{
    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
