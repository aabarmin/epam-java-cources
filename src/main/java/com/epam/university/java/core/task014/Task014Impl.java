package com.epam.university.java.core.task014;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Task014Impl implements Task014 {
    private VampireNumberFactory factory = new VampireNumberFactoryImpl();

    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<VampireNumber> list = new LinkedList<>();

        String[] digitsMulti;
        int[] numbers;

        // search in all 4-digit numbers
        for (int i = 1000; i <= 9999; i++) {
            digitsMulti = new String[4];
            numbers = new int[12];

            // array of digits of number
            digitsMulti[0] = Integer.toString(i / 1000);
            digitsMulti[1] = Integer.toString(i % 1000 / 100);
            digitsMulti[2] = Integer.toString(i % 1000 % 100 / 10);
            digitsMulti[3] = Integer.toString(i % 10);

            // check for valid number
            if (!isValidNumber(digitsMulti)) {
                continue;
            }

            // creating array of possible pairs of numbers
            int count = 0;
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (j == k) {
                        continue;
                    }
                    numbers[count] = Integer.parseInt(digitsMulti[j] + digitsMulti[k]);
                    count++;
                }
            }

            // check is vampire number
            if (numbers[0] * numbers[8] == i) {
                addToList(list, numbers[0], numbers[8]);
            } else if (numbers[0] * numbers[11] == i) {
                addToList(list, numbers[0], numbers[11]);
            } else if (numbers[1] * numbers[5] == i) {
                addToList(list, numbers[1], numbers[5]);
            } else if (numbers[1] * numbers[10] == i) {
                addToList(list, numbers[1], numbers[10]);
            } else if (numbers[2] * numbers[4] == i) {
                addToList(list, numbers[2], numbers[4]);
            } else if (numbers[2] * numbers[7] == i) {
                addToList(list, numbers[2], numbers[7]);
            } else if (numbers[3] * numbers[8] == i) {
                addToList(list, numbers[3], numbers[8]);
            } else if (numbers[3] * numbers[11] == i) {
                addToList(list, numbers[3], numbers[11]);
            } else if (numbers[4] * numbers[9] == i) {
                addToList(list, numbers[4], numbers[9]);
            } else if (numbers[5] * numbers[6] == i) {
                addToList(list, numbers[5], numbers[6]);
            } else if (numbers[6] * numbers[10] == i) {
                addToList(list, numbers[6], numbers[10]);
            } else if (numbers[7] * numbers[9] == i) {
                addToList(list, numbers[7], numbers[9]);
            }

        }
        return list;
    }

    /**
     * Add VampireNumber to list.
     *
     * @param list   collection to modify
     * @param first  first number
     * @param second second number
     */
    private void addToList(List<VampireNumber> list, int first, int second) {
        VampireNumber vamp = factory.newInstance(first * second, first, second);

        if (!list.contains(vamp)) {
            list.add(vamp);
        }
    }

    /**
     * Check for valid number.
     *
     * @param number array of digits of number
     * @return is count of "0" less that two
     */
    private boolean isValidNumber(String[] number) {
        int zeroCount = 0;
        for (String digit : number) {
            if (digit.equals("0")) {
                zeroCount++;
            }
        }

        return (zeroCount <= 1);
    }
}    

