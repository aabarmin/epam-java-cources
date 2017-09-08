package com.epam.university.java.core.task008;

import java.util.Stack;

/**
 * Strings and braces.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        if (null == sourceString) return false;
        if ("" == sourceString) return true;

        Stack<Character> stack = new Stack<>();
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
                        } else {

                            return false;
                        }
                        break;

                    case ')':
                        if ('(' == stack.peek()) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;

                    case ']':
                        if ('[' == stack.peek()) {
                            stack.pop();
                        } else {
                            return false;
                        }
                        break;

                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
