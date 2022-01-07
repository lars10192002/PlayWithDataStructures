package com.company.ch8.HeapAndPriorityQuene;

public interface Queue <E>{

    int getSize();
    boolean isEmpty();
    void enquene(E e);
    E dequene();
    E getFront();

}
