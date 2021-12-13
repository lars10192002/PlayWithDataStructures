package com.company;

public class LinkedList <E> {



    private class Node{

        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }


        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public  String toString(){
            return e.toString();
        }

    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    // 獲取鏈表中的元素個數
    public int getSize(){
        return size;
    }

    // 返回鏈表是否為空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在鏈表的頭添加新的元素e
    public void addFirst(E e){
        // Node node = new Node(e);
        // node.next = head;
        // head = node ;

        //   head = new Node(e, head) => 等於上面三行
        head = new Node(e, head);
        size++;
    }


    // 在鏈表的index(0-based)位置添加新的元素e
    // 在鏈表中不是一個常用的操作，練習用
    public void add(int index, E e){
        if(index < 0 || index >size)
            throw new IllegalArgumentException("Add faild. Illegal index.");

        if(index == 0)
            addFirst(e);
        else{
            Node prev = head;//得到現在頭部的位置
            for(int i = 0; i < index -1 ; i++)//查詢要插入的位置前一個的node
                prev = prev.next;


            prev.next = new Node(e, prev.next);
            size ++;
        }
    }

    // 在鏈表末尾端添加新的元素e
    public void addLast(E e){
        add(size, e);
    }
}
