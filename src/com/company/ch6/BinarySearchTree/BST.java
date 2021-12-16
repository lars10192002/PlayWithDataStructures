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


    // 向二分搜索樹中添加新的元素e
    public void add(E e){
        if (root == null){//根節點為空
            root = new Node(e);//直接在根節點開一個節點
            size++;
        }else
            add(root, e);//從根節點後開始新增節點
    }

    // 向以node為根的二分搜索樹中插入元素e，遞歸算法
    private void add(Node node, E e) {

        //遞歸的終止條件
        if (e.equals(node.e))//插入的元素是否重複(root) 是直接回傳
            return ;
        else if (e.compareTo(node.e) > 0 && node.left == null){ // 當插入值(e)大於現有數值(node.e)會回傳正值差距越大越正
            node.left = new Node(e);
            size++;
            return;
        }else if (e.compareTo(node.e) < 0 && node.right == null){ // 當插入值(e)大於現有數值(node.e)會回傳負值差距越大越負

            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);

    }


}
