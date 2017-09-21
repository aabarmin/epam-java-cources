package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Александр on 18.09.2017.
 */
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

        Set<VampireNumber> result = new HashSet<>();

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                result.add(new VampireNumberImpl(i * j, i, j));
            }
        }
        result = result.stream().filter(s -> isVampireNumber(s)).collect(Collectors.toSet());


        return result;
    }

    boolean isVampireNumber(VampireNumber number){
        String multiplication = String.valueOf(number.getMultiplication());
        StringBuffer first = new StringBuffer(String.valueOf(number.getFirst()));
        StringBuffer second = new StringBuffer(String.valueOf(number.getSecond()));

        for (Character c : multiplication.toCharArray()) {
            if (first.indexOf(c.toString()) >= 0) {
                first.deleteCharAt(first.indexOf(c.toString()));
            } else {
                if (second.indexOf(c.toString()) >= 0) {
                    second.deleteCharAt(second.indexOf(c.toString()));
                }
            }
        }

        if ((first.length() == 0) && (second.length() == 0)) {
            return true;
        }

        return false;


    }
}
