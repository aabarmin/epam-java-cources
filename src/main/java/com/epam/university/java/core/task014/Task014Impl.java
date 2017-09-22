package com.epam.university.java.core.task014;

import java.util.*;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        VampireNumberFactory vampireNumberFactory = new VampireNumberFactoryImpl();
        Set<VampireNumber> vampireNumbers = new HashSet<>();
        double q;
        int q_int;
        for (int i = 1000; i < 10000; i++) {
            for (int j = 10; j < 100; j++) {
                q = (double) i / j;
                q_int = (int) q;
                if (q != q_int) {
                    continue;
                }
                if (String.valueOf(q_int).length() <= 2) {
                    char[] number = String.valueOf(i).toCharArray();
                    char[] mult = (String.valueOf(q_int) + String.valueOf(j)).toCharArray();
                    Arrays.sort(number);
                    Arrays.sort(mult);
                    if (Arrays.equals(number, mult)) {
                        vampireNumbers.add(vampireNumberFactory.newInstance(i, q_int, j));
                    }
                }
            }
        }
        List<VampireNumber> list = new ArrayList<>(vampireNumbers);
        list.sort(Comparator.comparingInt(VampireNumber::getMultiplication));
        return list;
    }
}

