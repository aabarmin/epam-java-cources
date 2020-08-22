package com.epam.university.java.core.task008;

import java.util.Stack;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        String braces = "[]{}()";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sourceString.length(); i++) {
            char c = sourceString.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            }
            if ((c == '}' || c == ')' || c == ']') && stack.size() == 0) {
                return false;
            }
            if (c == '}') {
                if (stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }

            if (c == ')') {
                if (stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }

            if (c == ']') {
                if (stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }
}
