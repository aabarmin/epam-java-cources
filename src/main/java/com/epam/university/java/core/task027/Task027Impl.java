package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < sourceString.length() / 2; i++) {
            list = split(sourceString, i);
            if (list == null) {
                continue;
            }
            // check for list contains "0"
            if (list.contains(0)) {
                return Collections.emptyList();
            }
            break;
        }

        // return result list or empty collection
        return list != null ? list : Collections.emptyList();
    }

    /**
     * Split string for numbers with certain digit.
     *
     * @param str   string to split
     * @param digit digit of numbers
     * @return result collection or null if doesn't exist
     */
    private List<Integer> split(String str, int digit) {
        List<Integer> list = new ArrayList<>();

        while (str.length() >= digit) {
            String currValue = str.substring(0, digit);
            list.add(Integer.parseInt(currValue));
            str = str.substring(digit, str.length());
            if (isAllNines(currValue)) {
                digit++;
            }

            if (list.size() > 1) {
                if (list.get(list.size() - 1) - list.get(list.size() - 2) != 1) {
                    return null;
                }
            }
        }

        if (str.length() > 0) {
            return null;
        }

        return list;
    }

    /**
     * Check for it is last value of digit.
     *
     * @param str string to check
     * @return is it last value of digit
     */
    private boolean isAllNines(String str) {
        return str.length() > 0 && str.replaceAll("9", "").length() == 0;
    }
}
