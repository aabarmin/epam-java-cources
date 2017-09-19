package com.epam.university.java.core.task008;

import java.util.LinkedList;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        // Creating stack of bracers
        LinkedList<Character> bracerList = new LinkedList<>();

        // Reading string
        for (char ch : sourceString.toCharArray()) {

            // Checking for correct bracers
            switch (ch) {
                case '(':
                    bracerList.add('(');
                    break;

                case '{':
                    bracerList.add('{');
                    break;

                case '[':
                    bracerList.add('[');
                    break;

                case ')':
                    if (bracerList.size() > 0 && bracerList.getLast() == '(') {
                        bracerList.removeLast();
                    } else {
                        return false;
                    }
                    break;

                case '}':
                    if (bracerList.size() > 0 && bracerList.getLast() == '{') {
                        bracerList.removeLast();
                    } else {
                        return false;
                    }
                    break;

                case ']':
                    if (bracerList.size() > 0 && bracerList.getLast() == '[') {
                        bracerList.removeLast();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }

        return bracerList.isEmpty();
    }
}