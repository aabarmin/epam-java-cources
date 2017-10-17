package com.epam.university.java.core.task027;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Task027Impl implements Task027 {

    @Override
    public Collection<Integer> extract(String sourceString) {
        LinkedList<Integer> result = new LinkedList<>();
        int countA = 1;
        int countB = 2;
        if (sourceString.split("")[0].equals("0") || sourceString.length() == 1) {
            return Collections.emptyList();
        }
        while (true) {
            if (!result.isEmpty()) {
                if (countB > sourceString.length()
                        && (Integer.parseInt(sourceString) - result.getLast() == 1)) {
                    result.add(Integer.parseInt(sourceString));
                    break;
                }
            }
            int res1 = Integer.parseInt(sourceString.substring(0, countA));
            if (countB > sourceString.length()) {
                return Collections.emptyList();
            }
            int res2 = Integer.parseInt(sourceString.substring(countA, countB));
            if (res2 - res1 == 1) {
                if (sourceString.substring(countA,countB).split("")[0].equals("0")) {
                    return Collections.emptyList();
                }
                result.add(res1);
                if (sourceString.length() > countB - countA) {
                    sourceString = sourceString.substring(countA);
                }
            } else if (countB - countA > countA) {
                countA++;
            } else {
                countB++;
            }
        }
        return result;
    }
}
