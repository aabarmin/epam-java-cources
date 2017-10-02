package com.epam.university.java.core.task004;

import java.util.ArrayList;
import java.util.Collections;

public class Task004Impl implements Task004 {

    @Override
    public String[] intersection(String[] first, String[] second) {
        checkArrays(first,second);
        ArrayList<String> container = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    if (!container.contains(second[j])) {
                        container.add(second[j]);
                    }
                }
            }
        }
        String[] result = new String[container.size()];
        result = container.toArray(result);

        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        checkArrays(first,second);
        ArrayList<String> container = new ArrayList<>();

        for (int i = 0; i < first.length; i++) {
            if (!container.contains(first[i])) {
                container.add(first[i]);
            }
        }


        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (!first[i].equals(second[j])) {
                    if (!container.contains(second[j])) {
                        container.add(second[j]);
                    }
                }
            }
        }
        String[] result = new String[container.size()];
        result = container.toArray(result);
        return result;
    }

    private void checkArrays(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}