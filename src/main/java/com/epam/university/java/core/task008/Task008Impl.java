package com.epam.university.java.core.task008;

import java.util.Stack;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sourceString.length(); i++) {
            char tempChar = sourceString.charAt(i);
            if (tempChar == '(' || tempChar == '[' || tempChar == '{') {
                stack.push(tempChar);
            } else if (tempChar == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (tempChar == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (tempChar == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}