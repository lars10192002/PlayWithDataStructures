package com.company.ch7.SetAndMap.Map;

import java.util.ArrayList;

public class Main {



    public static void main(String[] args){
        String title1 ="Pride and Prejudice";
        String path = "/Users/lucakao/IdeaProjects/PlayWithDataStructures/src/com/company/ch7/SetAndMap/";
        String name = "pride-and-prejudice.txt";
        System.out.println(title1);


        BSTMap<String,Integer> map = new BSTMap<>();
        double time1 = testMap(map, path+name);
        System.out.println("BST Map: " + time1 + " s");

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, path+name);
        System.out.println("Linked List Map: " + time2 + " s");

    }

    private static double testMap(Map<String, Integer> bstMap, String filename) {

        long sTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename,words)){
            for (String word:words){

                if (bstMap.contains(word))
                    bstMap.set(word, bstMap.get(word)+1);
                else
                    bstMap.add(word, 1);
            }

            System.out.println("Total different words: " + bstMap.getSize());
            System.out.println("Frequency of PRIDE: " + bstMap.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + bstMap.get("prejudice"));
        }

        long eTime = System.nanoTime();

        return (eTime-sTime)/ 1000000000.0;
    }
}
