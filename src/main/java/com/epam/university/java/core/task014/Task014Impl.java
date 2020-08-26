package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Romin Nuro on 26.08.2020 15:21.
 */
public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        VampireNumberFactory factory = new VampireNumberFactoryImpl();
        Set<VampireNumber> vampireNumbers = new HashSet<>();
        for (int i = 1000; i < 10000; i++) {
            List<String> digits = numberToDigits(i);
            if (digits.stream().filter(s -> s.equals("0")).count() > 1) {
                continue;
            }
            for (String firstNumber : getCombinationsOfFour(digits)) {
                List<String> remainingNumbers = new ArrayList<>(digits);

                remainingNumbers.remove(firstNumber.substring(0, 1));
                remainingNumbers.remove(firstNumber.substring(1));

                int first = Integer.parseInt(firstNumber);
                int second1 = Integer.parseInt(remainingNumbers.get(0) + remainingNumbers.get(1));
                int second2 = Integer.parseInt(remainingNumbers.get(1) + remainingNumbers.get(0));

                if (first < 10 || second1 < 10 || second2 < 10) {
                    continue;
                }

                if (first * second1 == i) {
                    vampireNumbers.add(factory.newInstance(first * second1, first, second1));
                }

                if (first * second2 == i) {
                    vampireNumbers.add(factory.newInstance(first * second2, first, second2));
                }
            }

        }
        return vampireNumbers;
    }


    private List<String> numberToDigits(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }

    private List<String> getCombinationsOfFour(List<String> digits) {
        List<String> combinations = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                combinations.add(digits.get(i) + digits.get(j));
            }
        }
        return combinations;
    }
}
