package com.epam.university.java.core.task008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        if (sourceString == "") {
            return true;
        }

        String source = sourceString.replaceAll(" ", "");
        source = source.replaceAll("[1-9\\+\\-\\*\\/]", "");
        char[] braces = source.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (Character c : braces) {
            stack.push(c);
        }

        if (stack.size() % 2 != 0) {
            return false;
        }

        Stack<Character> chars = new Stack<>();

        while (!stack.isEmpty()) {
            if (stack.peek() == '(' || stack.peek() == '[' || stack.peek() == '{') {
                if ((stack.peek() == '(' && chars.peek() == ')')
                        || (stack.peek() == '{' && chars.peek() == '}')
                        || (stack.peek() == '[' && chars.peek() == ']')) {
                    stack.pop();
                    chars.pop();
                } else {
                    return false;
                }
            } else if (stack.peek() == ')' || stack.peek() == '}' || stack.peek() == ']') {
                chars.add(stack.pop());
            }
        }

        return chars.isEmpty();
    }
}
