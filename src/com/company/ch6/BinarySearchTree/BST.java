package com.company.ch6.BinarySearchTree;

public class BST <E extends Comparable<E>>{
//Comparable<E> ← Java中的可比較性的接口
    private class Node{
        private E e;
        private Node left,right;

        public Node(E e){
            this.e = e;
            left = null; // 初始化左右子樹為空
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public  int size(){
        return size;
    }

    public  boolean isEmpty(){
        return size == 0;
    }


}
