package com.epam.university.java.core.task008;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task008Impl implements Task008 {
    //    private static final List<String> BRACES = Arrays.asList("(", ")", "{", "}", "[", "]");
    private static final String BRACES = "\\(|\\)|\\{|\\}|\\[|\\]";
    private static final String OPENING_BRACES = "\\(|\\{|\\[";
    private static final String CLOSING_BRACES = "\\)|\\}|\\]";
//    Pattern pattern = Pattern.compile("\\(|\\)|\\{|\\}|\\[|\\]");

    @Override
    public boolean isValid(String sourceString) {
        boolean result = true;
        ParamStack<String> stack = new HandMadeStack<>();
        for (String s : sourceString.split("")) {
            if (s.matches(OPENING_BRACES)) {
                stack.push(s);
            }
            if (s.matches(CLOSING_BRACES)) {
                if (s.equals(getPair(stack.peek()))) {
                    stack.pop();
                } else {
                    result = false;
                }
            }
        }
        return result;
    }

    private String getPair(String s) {
        switch (s) {
            case "(":
                return ")";

            case "{":
                return "}";

            case "[":
                return "]";
            default:
                throw new IllegalArgumentException(s);
        }
    }
}
