package com.epam.university.java.core.task008;

import java.util.Stack;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {

        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        Stack<Character> chars = new Stack<>();
        for (int i = 0; i < sourceString.length(); i++) {
            char ch = sourceString.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                chars.push(ch);
            }
            if ((ch == ')' || ch == ']' || ch == '}') && chars.size() == 0) {
                return false;
            }
            if (ch == ')') {
                if (chars.peek() != '(') {
                    return false;
                } else {
                    chars.pop();
                }
            }
            if (ch == ']') {
                if (chars.peek() != '[') {
                    return false;
                } else {
                    chars.pop();
                }
            }
            if (ch == '}') {
                if (chars.peek() != '{') {
                    return false;
                } else {
                    chars.pop();
                }
            }
        }
        return chars.size() == 0;
    }
}
