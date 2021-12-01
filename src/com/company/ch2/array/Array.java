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
}
