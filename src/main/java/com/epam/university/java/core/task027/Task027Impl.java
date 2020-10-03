package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        if (sourceString.length() == 1 || sourceString.startsWith("0")) {
            return new ArrayList<>();
        }

        for (int i = 1; i < (sourceString.length() + 1) / 2; i++) {
            int x = Integer.parseInt(sourceString.substring(0, i));
            List<Integer> list = new ArrayList<>();
            list.add(x);

            String test = Integer.toString(x);
            while (test.length() < sourceString.length()) {
                test += Integer.toString(++x);
                list.add(x);
            }

            if (test.equals(sourceString)) {
                return list;
            }
        }
        return new ArrayList<>();
    }
}
