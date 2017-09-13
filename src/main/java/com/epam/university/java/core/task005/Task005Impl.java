package com.epam.university.java.core.task005;

import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static java.lang.Math.round;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 9) {
            throw new IllegalArgumentException("Digits less or equals to the zero,"
                    + " or more than ten!");
        }

        PiHolder numbers = null;
        double currentMinDiff = PI;
        //beginning of the numerator range
        int currentNum = (int) (round((pow(10, (digits - 1))) * PI));
        //beginning of the denominator range
        int currentDen = (int) (round(pow(10, (digits - 1))));
        //maximum value of retrieved numbers
        int maxVal = (int) (round((pow(10, digits) - 1)));

        while (currentNum < maxVal) {
            double currentDiff = Math.abs((double) currentNum / currentDen - PI);
            if (currentDiff < currentMinDiff) {
                currentMinDiff = currentDiff;
                numbers = new PiHolderImpl(currentNum, currentDen);
            }
            currentNum++;
            currentDen = (int) (round(currentNum / PI));
        }
        return numbers;
    }
}
