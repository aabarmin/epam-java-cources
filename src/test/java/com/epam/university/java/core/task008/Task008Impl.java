package com.epam.university.java.core.task008;

import java.util.LinkedList;
import java.util.Stack;


public class Task008Impl implements Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}". You need to check,
     * are all braces correct. Ex:
     * <p>
     * "(1 + 2) * {[-3] - 4}" - correct
     * "(1 + [2) + 3 - 4]" - incorrect
     * In expression can be used the following kinds of braces: {}, (), [].
     * Tip: it's better to implement stack structure.
     * Tip: You also can use Stack class but it's not recommended.
     * </p>
     *
     * @param sourceString string to check
     * @return is braces valid or source string is empty
     */
    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        if (sourceString.equals("")) {
            return true;
        }
        String braces = "";
        for (int i = 0; i < sourceString.length(); i++) {
            if (isBrace(sourceString.charAt(i))) {
                braces += sourceString.charAt(i);
            }
        }
        Stack stack = new Stack();
        for (int i = 0; i < braces.length(); i++) {
            char current = braces.charAt(i);
            if (isOpening(current)) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (isPairValid(stack.peek().toString().charAt(0), current)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Method to check whether character is brace or not
     *
     * @param symbol just a char
     * @return true if brace, otherwise false
     */
    private boolean isBrace(char symbol) {
        String braces = "(){}[]";
        if (braces.contains(Character.toString(symbol))) {
            return true;
        }
        return false;
    }

    /**
     * Method to check whether brace if opening or not
     *
     * @param symbol any brace
     * @return true if brace, otherwise false
     */
    private boolean isOpening(char symbol) {
        String openings = "([{";
        if (openings.contains(Character.toString(symbol))) {
            return true;
        }
        return false;
    }

    /**
     * Method to check whether pair of brackets is valid
     *
     * @param prev    is bracket
     * @param current is bracket
     * @return true if brace, otherwise false
     */
    private boolean isPairValid(char prev, char current) {
        boolean round = prev == '(' && current == ')';
        boolean square = prev == '[' && current == ']';
        boolean curly = prev == '{' && current == '}';
        if (round || square || curly) {
            return true;

        } else {
            return false;
        }
    }
}
