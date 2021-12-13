package com.company.ch4.LinkedList;

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

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
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
        //head = new Node(e, head);
        //size++;

        // use dummuHead
        add(0,e);
    }


    // 在鏈表末尾端添加新的元素e
    public void addLast(E e){
        add(size, e);
    }


    // 在鏈表的index(0-based)位置添加新的元素e
    // 在鏈表中不是一個常用的操作，練習用
    public void add(int index, E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for(int i = 0 ; i < index ; i ++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    public E get(int index){
        if(index < 0 || index >size)
            throw new IllegalArgumentException("get faild. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }


    // 獲得鏈表的第一個元素
    public E getFirst(){
        return get(0);
    }


    // 獲得鏈表的下一個元素
    public E getLast(){
        return get(size-1);
    }


    // 修改鏈表的第index元素(0-based)個位置的元素為e
    // 在鏈表中不是一個常用的操作，練習用
    public void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i ++)
            cur = cur.next;
        cur.e = e;
    }


    // 查找鏈表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != dummyHead.next){
//            res.append(cur+"->");
//            cur = cur.next;
//        }

        for(Node cur = dummyHead.next ;cur != null ; cur = cur.next)
            res.append(cur + "->");

        res.append("NULL");

        return res.toString();
    }


}
