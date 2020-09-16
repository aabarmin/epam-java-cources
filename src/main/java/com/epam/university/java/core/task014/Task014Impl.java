package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task014Impl implements Task014 {
    /**
     * A vampire number has an even number of digits and is formed by
     * multiplying a pair of numbers containing half the number of digits
     * of the result. The digits are taken from the original number
     * in any order. Pairs of trailing zeroes are not allowed.
     *
     * <p>
     *     Example: 1260 = 21 * 60
     * </p>
     * <p>
     *     {@see https://en.wikipedia.org/wiki/Vampire_number}
     * </p>
     * @return collection of vampire numbers
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        List<VampireNumber> vampireNumbers = new ArrayList<>();
        int from;
        int to = 100;

        for (from = 10; from < to; from++) {
            int first = from;
            for (int i = from; i < to; i++) {
                int second = i;
                boolean trailingZeros = ((from % 10 == 0) && (i % 10 == 0));
                if (!trailingZeros) {
                    int multiplication = first * second;
                    if (multiplication % 9 == (first + second) % 9) {
                        String sMultiplicitaion = String.valueOf(multiplication);
                        String sFirst = String.valueOf(first);
                        String sSecond = String.valueOf(second);

                        char[] multiplicationArr = sMultiplicitaion.toCharArray();
                        Arrays.sort(multiplicationArr);

                        char[] firstAndSecondArr = (sFirst + sSecond).toCharArray();
                        Arrays.sort(firstAndSecondArr);

                        if (Arrays.equals(multiplicationArr, firstAndSecondArr)) {
                            vampireNumbers.add(new VampireNumberFactoryImpl()
                                    .newInstance(multiplication, first, second));
                        }
                    }
                }
            }
        }

        return vampireNumbers;
    }


}
