package com.epam.university.java.core.task008;

import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Collections;

public class Task008Impl implements Task008 {
    ArrayList<Character> brackets = new ArrayList<>();

    @Override
    public boolean isValid(String sourceString) {
        for (char c: sourceString.toCharArray()) {
            if (isClosingBracket(c) && brackets.isEmpty()) {
                return false;
            } else if (isOpeningBracket(c)) {
                brackets.add(c);
                Collections.reverse(brackets);
            } else if (isClosingBracket(c)) {
                if (isPair(brackets.get(0), c)) {
                    brackets.remove(0);
                    brackets.trimToSize();
                }
            }
        }
        return brackets.size() == 0;
    }

    private boolean isOpeningBracket(char bracket) {
        return ArrayUtils.contains("({[".toCharArray(), bracket);
    }

    private boolean isClosingBracket(char bracket) {
        return ArrayUtils.contains(")}]".toCharArray(), bracket);
    }

    private boolean isPair(char opening, char closing) {
        return opening == '(' && closing == ')' || opening == '['
                && closing == ']' || opening == '{' && closing == '}';
    }
}
