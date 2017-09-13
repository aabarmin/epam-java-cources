package com.epam.university.java.core.task008;

import java.util.Stack;

/**
 * Created by Александр on 14.09.2017.
 */
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

        String openBrackets = "({[";
        String closeBrackets = ")}]";

        Stack<Integer> bracketStack = new Stack<>();

        for (char ch : sourceString.toCharArray()) {
            int openIndex = openBrackets.indexOf(ch);
            if (openIndex >= 0) {
                bracketStack.push(openIndex);
            } else {
                int closeIndex = closeBrackets.indexOf(ch);
                if (closeIndex >= 0) {
                    if (bracketStack.pop() != closeIndex) {
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
