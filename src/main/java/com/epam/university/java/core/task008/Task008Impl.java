package com.epam.university.java.core.task008;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Strings and braces.
 */
public final class Task008Impl implements Task008 {
    @Override
    public boolean isValid(final String sourceString) {
        if (null == sourceString) {
            return false;
        }
        if ("".equals(sourceString)) {
            return true;
        }

        Deque<Character> stack = new ArrayDeque<>();
        try {
            for (int i = 0; i < sourceString.length(); i++) {
                char currentChar = sourceString.charAt(i);
                switch (currentChar) {
                    case '(':
                    case '{':
                    case '[':
                        stack.push(currentChar);
                        break;

                    case '}':
                        if ('{' == stack.peek()) {
                            stack.pop();
                            break;
                        }
                        return false;

                    case ')':
                        if ('(' == stack.peek()) {
                            stack.pop();
                            break;
                        }
                        return false;

                    case ']':
                        if ('[' == stack.peek()) {
                            stack.pop();
                            break;
                        }
                        return false;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.isEmpty();
    }
}
