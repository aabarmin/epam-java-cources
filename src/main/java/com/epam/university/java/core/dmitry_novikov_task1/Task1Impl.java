package com.epam.university.java.core.dmitry_novikov_task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Author Dmitry Novikov 20-Sep-20.
 */
public class Task1Impl implements Task1{
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException();
        }

        if (from <=0 || to <=0) {
            throw new IllegalArgumentException();
        }
        List<Integer> resultCollection = new ArrayList<>();

        for(int number = from + 1; number < to; ++number) {
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

            if (result == number)
                resultCollection.add(number);
        }
        return resultCollection;
    }
}
