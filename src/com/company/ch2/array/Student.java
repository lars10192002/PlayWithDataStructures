package com.company.ch2.array;

public class Student {
    private String name;
    private int score;

    public Student(String sName,int sScore){
        name = sName;
        score = sScore;
    }


    @Override
    public String toString(){
        return String.format("Student(name: %s, score: %d)", name, score);
    }



    public static void main(String[] arg){

        Array<Student> array = new Array<>();
        array.addLast(new Student("A",60));
        array.addLast(new Student("B",70));
        array.addLast(new Student("C",80));

        System.out.println(array);


    }

}
