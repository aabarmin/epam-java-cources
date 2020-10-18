package com.epam.university.java.core.task048;


import java.util.ArrayList;
import java.util.Collection;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }

        Collection<Integer> list = new ArrayList<>();

        for (int number = from + 1; number < to; ++number) {
            int digits = 0;
            int result = 0;
            int originalNumber = number;

            while (originalNumber != 0) {
                originalNumber /= 10;
                ++digits;
            }

            originalNumber = number;

            while (originalNumber != 0) {
                int remainder = originalNumber % 10;
                result += Math.pow(remainder, digits);
                originalNumber /= 10;
            }

            if (result == number) {
                list.add(number);
            }
        }


        return list;
    }
}
