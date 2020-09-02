package com.epam.university.java.core.task005;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Task005Impl implements Task005 {
    /**
     * Find two numbers, quotient of which will be closest to PI number. Ex. if digit is 1,
     * holder values should be between 1 and 9, if digits is equals to 2, values should
     * be between 10 and 99 and so on.
     * <p>
     *     Tip: Math.abs((a / b) - Math.PI) -> min
     * </p>
     *
     * @param digits amount of digits in numbers.
     * @return holder which contains both numbers
     * @throws IllegalArgumentException if digits less or equals to the zero, or more than ten
     */
    @Override
    public PiHolder findPi(int digits) {
        final double pi = Math.PI;
        if (digits < 1 || digits > 10) {
            System.out.println("digit is incorrect");
            throw new IllegalArgumentException();
        }
        int startValue = (int) Math.pow(10, digits - 1.0d);
        int finishValue = (int) (Math.pow(10, digits) - 1);
        double closestToPiNum;
        double minNumerator = 2;
        double minDenominator = 1;
        double minQuotient = 4;
        for (double i = startValue; i < finishValue; i++) {
            for (int j = (int) (pi * startValue); j < finishValue; j++) {
                double quotient = j / i;
                if (quotient > 2.95 && quotient < 3.2) {
                    closestToPiNum = Math.abs(quotient - pi);
                    if (closestToPiNum < minQuotient) {
                        minQuotient = closestToPiNum;
                        minNumerator = j;
                        minDenominator = i;
                    }
                }
            }
        }
        PiHolderImpl minNumbers = new PiHolderImpl((int)minNumerator, (int) minDenominator);
        return minNumbers;
    }
}
