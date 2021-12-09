package com.company;

import com.company.ch2.array.Array;
import com.company.ch3.stack.ArrayStack;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here


        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());



    }
}
