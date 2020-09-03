package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task020Impl implements Task020 {

    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> arrayList = new ArrayList<>(stones);
        int length = arrayList.get(0)
                              .length();
        boolean flag = false;
        int count = 0;
        char[] first = arrayList.get(0)
                                .toCharArray();
        char[] second = arrayList.get(1)
                                 .toCharArray();
        char[] third = arrayList.get(2)
                                .toCharArray();
        char[] buf = new char[third.length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (first[i] == second[j]) {
                    buf[i] = first[i];
                    flag = true;
                }
            }
        }
        String distinct = removeDuplicate(buf);
        buf = distinct.toCharArray();
        if (flag) {
            for (char c : buf) {
                for (int j = 0; j < length; j++) {
                    if (c == third[j]) {
                        count++;
                    }
                }
            }
            return count;
        }
        return 0;
    }

    /**
     * Method for removing duplicates from a given char array.
     *
     * @param str char array
     * @return result string
     */
    public static String removeDuplicate(char[] str) {
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (str[i] == str[j]) {
                    break;
                }
            }
            if (j == i) {
                str[index++] = str[i];
            }
        }
        return String.valueOf(Arrays.copyOf(str, index));
    }
}
