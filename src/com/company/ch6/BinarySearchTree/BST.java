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
    // 返回插入新節點後結束二分搜索樹的根
    private Node add(Node node, E e) {

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;

    }


    // 看二分搜索樹中是否包含元素e
    public boolean contains(E e){
        return contains(e);
    }

    // 看以node為根的二分搜索樹中是否包含元素e, 遞歸算法
    private boolean contains(Node node, E e){
        if(node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right,e);
    }

    // 二分搜索樹的前序遍歷
    public void preOrder(){
        preOrder(root);
    }


    //前序遍歷以node為根的二分搜索樹， 遞歸算法
    private void preOrder(Node node){

        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);

    }


    //二分搜索樹的中序遍歷
    public void inOrder(){
        inOrder(root);
    }


    // 中序遍歷以node為根的二分搜索樹，遞歸算法
    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    //二分搜索樹的後序遍歷
    public void postOrder(){
        postOrder(root);
    }


    // 後序遍歷以node為根的二分搜索樹，遞歸算法
    private void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0 , res);
        return res.toString();
    }


    //生成以node為根節點，深度為depth的描述二叉樹的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth +1 ,res);
        generateBSTString(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }


}
