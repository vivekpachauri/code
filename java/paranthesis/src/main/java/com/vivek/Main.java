package com.vivek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting!");
        Main main = new Main();
        System.out.println(main.isValid(")"));
    }
    
    public boolean isValid(String s) {
        if (s.length() > 10000) throw new IllegalArgumentException();
        /*
         * break down the input into tokens
         * maintain a boolean indicating the current state
         * iterate through all the tokens
         *   if it is an open token and insert it into the queue
         *   if it is a close token then take out the most recent token
         *   from the queue and make sure the close token matches the 
         *   open token
         * at the end make sure that the queue is empty
         */
        Stack<Token> tokenStack = new Stack<Token>();
        String[] splitString = s.split("");
        for (String st : splitString) {
            System.out.println(st);
            Token t = new Token(st);
            System.out.println(t);
            if (t.isOpenType()) {
                tokenStack.push(t);
            } else {
                Token previous = tokenStack.pop();
                if (!previous.getParanType().equals(t.reverse())) {
                    return false;
                }
            }
        }
        if (!tokenStack.isEmpty()) {
            return false;
        }
            
        return true;
    }
}
