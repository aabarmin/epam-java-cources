package com.epam.university.java.core.task008;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Some text.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        Deque<Character> stack = new LinkedList<>();

        for (char c : sourceString.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if ((c == ')' && (stack.isEmpty() || stack.pop() != '('))
                    || (c == ']' && (stack.isEmpty() || stack.pop() != '['))
                    || (c == '}' && (stack.isEmpty() || stack.pop() != '{'))) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
