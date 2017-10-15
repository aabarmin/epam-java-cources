package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class Task027Impl implements Task027 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Integer> extract(String sourceString) {
        List<String> strings = Arrays.asList(sourceString.split(""));
        char[] chars = sourceString.toCharArray();
        List<Integer> list = new ArrayList<>();
        if (sourceString.startsWith("0")) {
            return list;
        }
        int first = Integer.parseInt(strings.get(0));
        int path = 1;
        for (int i = 1; i < strings.size(); i++) {
            int nextNum = first + 1;
            path = (nextNum + "").length();
            if (i + path >= sourceString.length()) {
                break;
            }
            int current = Integer.parseInt(new String(Arrays.copyOfRange(chars, i, i + path)));
            if (current == nextNum) {
                break;
            } else {
                first = (first * 10) + Integer.parseInt(strings.get(i));
            }
        }
        int floor = 0;
        for (int i = 0; i < sourceString.length(); ) {
            int length = (first + "").length();
            String temp = sourceString.substring(floor, floor + length);
            if (temp.equals(first + "")) {
                list.add(first);
                first++;
                floor = floor + length;
                i = floor;
                if (i < 0) {
                    break;
                }
            } else {
                list.removeAll(list);
                break;
            }
        }
        if (list.size() == 1) {
            list.removeAll(list);
        }
        return list;
    }
}