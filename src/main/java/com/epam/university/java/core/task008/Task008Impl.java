package com.epam.university.java.core.task008;

import java.util.LinkedList;

/**
 * Created by Daniil Smirnov on 14.09.2017.
 * All copy registered MF.
 */
public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        String[] array = sourceString.split("");
        LinkedList<String> res = new LinkedList<>();
        for (String s : array) {
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
