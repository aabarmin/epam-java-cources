package com.epam.university.java.core.task014;

import java.util.*;
import java.util.stream.Collectors;

public class Task014Impl implements Task014 {

    /**
     * A vampire number has an even number of digits and is formed by
     * multiplying a pair of numbers containing half the number of digits
     * of the result. The digits are taken from the original number
     * in any order. Pairs of trailing zeroes are not allowed.
     * <p>
     * <p>
     * Example: 1260 = 21 * 60
     * </p>
     * <p>
     * {@see https://en.wikipedia.org/wiki/Vampire_number}
     * </p>
     *
     * @return collection of vampire numbers
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {

        List<VampireNumber> vampireNumbers = new ArrayList<>();

        for (int first = 10; first < 100; first++) {
            for (int second = first; second < 100; second++) {

                int multiplication = first * second;

                char[] multiplicationChars = Integer.toString(multiplication).toCharArray();
                char[] multipliersChars = (Integer.toString(first) + Integer.toString(second)).toCharArray();

                if (multiplicationChars.length == multipliersChars.length) {

                    Arrays.sort(multiplicationChars);
                    Arrays.sort(multipliersChars);

                    if (Arrays.equals(multiplicationChars, multipliersChars)) {
                        vampireNumbers.add(new VampireNumberImpl(multiplication, first, second));
                    }

                }

            }
        }

        Collections.sort(vampireNumbers, new Comparator<VampireNumber>() {
            @Override
            public int compare(VampireNumber o1, VampireNumber o2) {
                return new Integer(o1.getMultiplication()).compareTo(new Integer(o2.getMultiplication()));
            }
        });

        return  vampireNumbers;

    }

}

