package com.company.ch7.SetAndMap.src;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        String title1 ="Pride and Prejudice";
        String path = "/Users/lucakao/IdeaProjects/PlayWithDataStructures/src/com/company/ch7/SetAndMap/";
        String name = "pride-and-prejudice.txt";
        System.out.println(title1);

        ArrayList<String> word1 = new ArrayList<>();

        if (FileOperation.readFile(path+name,word1)){
            System.out.println("total word : "+word1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for(String word: word1)
                set1.add(word);

            System.out.println("total diff word : "+set1.getSize());


        }

        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile(path+"a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }

    }
}
