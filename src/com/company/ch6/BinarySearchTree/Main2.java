package com.company.ch6.BinarySearchTree;


import java.util.Random;

public class Main2 {
    // 打亂arr順序
    private static void shuffle(Object[] arr){

        for(int i = arr.length - 1 ; i >= 0 ; i --){
            int pos = (int) (Math.random() * (i + 1));
            Object t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
    }

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Random random = new Random();

        int n = 10000;

        for(int i = 0 ; i < n ; i ++)
            bst.add(random.nextInt(n));

        // 注意，由於隨機生成的數據有重複，所以bst中的數據數量大概率是小於n的
        // 生成order arr[0...n]的元素
        Integer[] order = new Integer[n];
        for( int i = 0 ; i < n ; i ++ )
            order[i] = i;
        // 打亂order arr 順序
        shuffle(order);

        // 亂序刪除[0...n]裡面的東西
        for( int i = 0 ; i < n ; i ++ )
            if(bst.contains(order[i])){
                bst.remove(order[i]);
                System.out.println("After remove " + order[i] + ", size = " + bst.size() );
            }

        // 最終整個二分搜索樹應該為空
        System.out.println(bst.size());
    }
}
