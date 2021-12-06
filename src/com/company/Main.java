package com.company;

import com.company.ch2.array.Array;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[10];
        for (int i=0; i<arr.length ;i++)
            arr[i] = i;

        int[] scores = new int[]{100,22,333,66};
        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
        }

        for (int score:scores) {
//            System.out.println(score);
        }

        scores[0]=777;

        for (int i = 0; i < scores.length; i++) {
//            System.out.println(scores[i]);
        }



        Array array = new Array(20);
        array.addFirst(5);
        array.addFirst(2);
//        array.addFirst(1);

        System.out.println(array.getLength());
        System.out.println(array.getCapacity());



    }
}
