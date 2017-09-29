package com.epam.university.java.core.task014;


import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        VampireNumberFactory vampireNumberFactory = new VampireNumberFactoryImpl();
        Set<VampireNumber> vampireNumbers = new HashSet<>();
        double q;
        int qint;
        for (int i = 1000; i < 10000; i++) {
            for (int j = 10; j < 100; j++) {
                q = (double) i / j;
                qint = (int) q;
                if (q != qint) {
                    continue;
                }
                if (String.valueOf(qint).length() <= 2) {
                    char[] number = String.valueOf(i).toCharArray();
                    char[] mult = (String.valueOf(qint) + String.valueOf(j)).toCharArray();
                    Arrays.sort(number);
                    Arrays.sort(mult);
                    if (Arrays.equals(number, mult)) {
                        vampireNumbers.add(vampireNumberFactory.newInstance(i, qint, j));
                    }
                }
            }
        }
        List<VampireNumber> list = new ArrayList<>(vampireNumbers);
        list.sort(Comparator.comparingInt(VampireNumber::getMultiplication));
        return list;
    }
}

