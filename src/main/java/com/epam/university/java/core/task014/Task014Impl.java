package com.epam.university.java.core.task014;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Task014Impl implements Task014 {

    @Override
    public Collection<VampireNumber> getVampireNumbers() {

        Set<VampireNumber> result = new HashSet<>();

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                if (validateNumbers(i,j)) {
                    result.add(new VampireNumberImpl(i * j, i, j));
                }

            }
        }
        return result;
    }

    /**
     * Check if new vampire number can be formed by multiplying given pair of numbers.
     * @param i first number
     * @param j second number
     * @return boolean value
     */
    private boolean validateNumbers(int i, int j) {
        String multiplication = Integer.toString(i * j);
        if (multiplication.replaceAll("0", "").length() < 3 || multiplication.length() < 4) {
            return false;
        }
        List<String> multiplicationDigits = new ArrayList<>();
        multiplicationDigits.addAll(Arrays.asList(multiplication.split("")));
        String first = Integer.toString(i);
        String second = Integer.toString(j);
        List<String> digits = new ArrayList<>();
        digits.addAll(Arrays.asList((first + second).split("")));
        digits.sort(Comparator.naturalOrder());
        multiplicationDigits.sort(Comparator.naturalOrder());
        return multiplicationDigits.equals(digits);
    }
}
