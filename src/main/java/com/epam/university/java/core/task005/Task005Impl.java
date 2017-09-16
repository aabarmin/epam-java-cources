package com.epam.university.java.core.task005;

/**
 * Created by Вера on 10.09.2017.
 */
public class Task005Impl implements Task005 {
    private static final double CONSTANT_PI = (double)Math.PI;

    @Override
    public PiHolderImpl findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int lowerLimit = (int)Math.pow(10, digits - 1);
        int upperLimit = (int)Math.pow(10, digits);
        int upperLower = upperLimit - lowerLimit;
        int numerator = 0;
        int denumerator = 0;
        double difference = 1.0;
        double variance = 1.0;

        for (int i = lowerLimit; i < upperLimit; i++) {
            if (i * CONSTANT_PI > upperLimit) {
                break;
            }
            for (int j = (int)(i * CONSTANT_PI);
                 j < (int)(i * CONSTANT_PI + lowerLimit); j++) {
                variance = Math.abs((double)j / i - CONSTANT_PI);
                if (variance >= 1 && j < upperLower) {
                    j = j + lowerLimit / 10;
                } else if (variance < difference) {
                    difference = variance;
                    numerator = j;
                    denumerator = i;
                }
            }

        }


        return new PiHolderImpl(numerator, denumerator);
    }
}