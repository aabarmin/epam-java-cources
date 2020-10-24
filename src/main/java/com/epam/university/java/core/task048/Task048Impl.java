package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (to == null || from == null || to < 0 || from < 0) {
            throw new IllegalArgumentException();
        }

        Collection<Integer> list = new ArrayList<>();
        for (int i = from; i < to; i++) {
            if (isArmstrongNumber(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isArmstrongNumber(int number) {
        int sum = 0;
        int[] digits = new int[String.valueOf(number).length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(String.valueOf(number).charAt(i)));
        }
        int power = digits.length;

        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }

        return sum == number;
    }


}
