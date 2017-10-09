package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Comparator;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<VampireNumber> vampireNumbers = new ArrayList<>();

        for (int i = 15; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int multiplication = i * j;
                String[] resStringArr = String.valueOf(multiplication).split("");
                String[] twoNumStringArr = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(resStringArr);
                Arrays.sort(twoNumStringArr);
                if (Arrays.equals(resStringArr, twoNumStringArr)) {
                    vampireNumbers.add(new VampireNumberImpl(multiplication, i, j));
                }
            }
        }
        vampireNumbers.sort(Comparator.comparing(VampireNumber::getMultiplication));
        return vampireNumbers;
    }
}