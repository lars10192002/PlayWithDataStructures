package com.company.ch7.SetAndMap.Map;

import java.util.ArrayList;

public class BSTMap <K extends Comparable<K>, V> implements Map<K,V>{

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key ,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    //在BST中添加新的元素(ley,value)
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node為根的二分搜索樹中插入元素(key, value)，遞歸算法
    // 返回插入新節點後的BST root
    private Node add(Node node, K key, V value) {

        if (node == null){
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else// key.compareTo(node.key) == 0
            node.value = value;

        return node;
    }

    //返回以node為根節點的二分搜索樹中，key所在的節點
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }


    @Override
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {

        Node node =  getNode(root,key) ;
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node =  getNode(root,key) ;
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value =  newValue;
    }



    // 返回以node為根的二分搜索樹的最小值所在的節點
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }


    // 删除掉以node为根的二分搜索树中的最小節點
    // 返回刪除節點後新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 從二分搜索树中刪除key == key 的節點

    @Override
    public V remove(K key) {
        Node node =  getNode(root,key) ;
        if (node!=null){
            root = remove(root,key);
            return node.value;
        }

        return null;
    }




    private Node remove(Node node, K key){
        if (node==null)
            return null;

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left , key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else // key.compareTo(node.key) == 0
        {
            // delete left child tree == empty
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            //delete right child tree == empty
            if (node.right == null){
                Node rightNode = node.left;
                node.left = null;
                size --;
                return rightNode;
            }

            // 待刪除節點左右都為空的情形
            // 找到比待刪除節點大的最小節點， 待刪除節點右子樹的最小節點
            // 用這個節點頂替待刪除節點的位置

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }






    public static void main(String[] args){
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        System.out.println("Pride and Prejudice");
        String path = "/Users/lucakao/IdeaProjects/PlayWithDataStructures/src/com/company/ch7/SetAndMap/";
        String name = "pride-and-prejudice.txt";

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(path+name, words)){
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));



        }



    }
}
