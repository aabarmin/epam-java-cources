package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        if (sourceString.length() <= 1 || sourceString.startsWith("0")) {
            return new ArrayList<>();
        }

        Set<Integer> resultList = new HashSet<>();

        int range = 1;
        String newStr = sourceString.substring(range);
        String current = sourceString.substring(0, range);
        Integer curInt = Integer.parseInt(current);
        StringBuilder target = new StringBuilder();
        while (newStr.length() != 0) {
            String next = curInt + 1 + "";

            if (newStr.startsWith(next)) {
                resultList.add(curInt);
                target.append(curInt);

                range = next.length();

                current = newStr.substring(0, range);
                curInt = Integer.parseInt(current);
                newStr = newStr.substring(range);

                if (newStr.length() == 0) {
                    resultList.add(curInt);
                }
            } else {

                if (resultList.size() != 0) {
                    return new ArrayList<>();
                }

                current = current + newStr.substring(0, 1);
                curInt = Integer.parseInt(current);
                newStr = newStr.substring(1);
                range++;
            }
        }

        return resultList;
    }
}
