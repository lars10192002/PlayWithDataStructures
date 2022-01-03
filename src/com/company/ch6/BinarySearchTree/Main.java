package com.company.ch6.BinarySearchTree;

public class Main {

    public static void main(String[] arg){
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int i = 0; i < nums.length; i++) {
            bst.add(nums[i]);
        }

        bst.preOrder();
        System.out.println();

        bst.inOrder();
        System.out.println();

        bst.postOrder();
        System.out.println();

        bst.levelOrder();
        System.out.println();
    }
}