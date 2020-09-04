package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null || sourceString.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (sourceString.length() == 1 || sourceString.charAt(0) == '0') {
            return Collections.emptyList();
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sourceString.length(); i++) {
            list.add(Character.digit(sourceString.charAt(i), 10));
        }
        if (list.get(1) - list.get(0) == 1) {
            return list;
        }
        list.clear();

        if (!sourceString.contains("0")) {
            return Collections.emptyList();
        }
        int zero = sourceString.indexOf("0");
        int pos = zero - 1;
        int buf = zero;
        while (sourceString.charAt(buf) != '0') {
            buf++;
        }
        String str;
        if (pos != 0) {
            str = sourceString.substring(0, pos);
            list.add(Integer.parseInt(str));
        } else {
            buf++;
        }

        for (int i = pos; i < sourceString.length(); i += buf) {
            str = sourceString.substring(i, i + buf);
            if (list.size() == 0) {
                list.add(Integer.parseInt(str));
            } else if (Integer.parseInt(str) - list.get(list.size() - 1) == 1) {
                list.add(Integer.parseInt(str));
            } else {
                return Collections.emptyList();
            }
        }
        return list.isEmpty() ? Collections.emptyList() : list;
    }
}
