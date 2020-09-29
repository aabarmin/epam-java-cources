package com.epam.university.java.core.task014;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Task014Impl implements Task014 {

    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Map<Integer, VampireNumber> map = new TreeMap<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                int m = i * j;
                if (isVampirNumber(m, j, i)) {
                    map.put(m, new VampireNumberFactoryImpl().newInstance(m, j, i));
                }
            }
        }
        return map.values();
    }

    /**
     * Check this number vampire or not.
     * @param multiplication number to check
     * @param first first part of number
     * @param second second part of number
     * @return true if this number a vampire number
     */
    public boolean isVampirNumber(int multiplication, int first, int second) {
        String stringMultiply = String.valueOf(multiplication);
        String stringSum = String.valueOf(first) + String.valueOf(second);
        char[] multiply = stringMultiply.toCharArray();
        Arrays.sort(multiply);
        char[] sum = stringSum.toCharArray();
        Arrays.sort(sum);
        return Arrays.equals(multiply, sum);
    }
}


