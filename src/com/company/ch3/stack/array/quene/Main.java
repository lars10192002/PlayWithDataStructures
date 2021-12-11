package com.company.ch3.stack.array.quene;

import java.util.Random;

public class Main {

    private static double testQuene(Quene<Integer> q, int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] arg){
        int opCount = 1000000;
        ArrayQuene<Integer> arrayQuene = new ArrayQuene<>();
        double time1 = testQuene(arrayQuene,opCount);
        System.out.println("ArrayQuene, time: "+ time1+ " s");

        LoopQuene<Integer> loopQuene = new LoopQuene<>();
        double time2 = testQuene(loopQuene,opCount);
        System.out.println("LoopQuene, time: "+ time2+ " s");

    }
}
