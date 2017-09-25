package com.epam.university.java.core.task008;

import java.util.LinkedList;

/**
 * Created by Daniil Smirnov on 14.09.2017.
 * All copy registered MF.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {

        if (sourceString.isEmpty()) {
            return true;
        }

        String[] array = sourceString.split("[\\d\\s+\\-*]+");
        String finnaly = "";
        for (int i = 0; i < array.length; i++) {
            finnaly += array[i];
        }
        String[] finalArray = finnaly.split("");
        LinkedList<String> res = new LinkedList<>();
        if (finalArray.length <= 1) {
            return false;
        }

        for (String s : finalArray) {
            if (s.equals("(")) {
                res.add(s);
            }
            if (s.equals(")")) {
                if (res.getLast().equals("(")) {
                    res.removeLast();
                } else {
                    return false;
                }
            }
            if (s.equals("[")) {
                res.add(s);
            }
            if (s.equals("]")) {
                if (res.getLast().equals("[")) {
                    res.removeLast();
                } else {
                    return false;
                }
            }
            if (s.equals("{")) {
                res.add(s);
            }
            if (s.equals("}")) {
                if (res.getLast().equals("{")) {
                    res.removeLast();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
