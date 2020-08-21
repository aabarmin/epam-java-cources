package com.epam.university.java.core.task004;

import java.util.LinkedList;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    list.add(first[i]);
                }
            }
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = list.get(i);
        }
        return strArr;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < first.length; i++) {
            list.add(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            if (!list.contains(second[i])) {
                list.add(second[i]);
            }
        }
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = list.get(i);
        }
        return strArr;
    }
}
