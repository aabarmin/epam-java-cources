package com.epam.university.java.core.task005;

import com.epam.university.java.core.Validator;

public class Task005Impl implements Task005 {
    private Validator validator = Validator.getInstance();

    @Override
    public PiHolder findPi(int digits) {
        validator.vaildate(digits);
        if (digits < 1) {
            throw new IllegalArgumentException("digits must be natural");
        }
        if (digits > 10) {
            throw new IllegalArgumentException("digits must be natural");
        }
        int secondStart = (int) Math.pow(10, digits - 1);
        final int firstStart = 3 * secondStart;
        final int firstLim = 10 * secondStart;
        final int secondLim = (int) Math.ceil(firstLim * 0.34);
        int firstResult = 0;
        int secondResult = 0;
        double prevResult = Integer.MAX_VALUE;
        double delta;
        int secondLessFirst;
        for (int i = firstStart; i < firstLim; i++) {
            secondLessFirst = (int) Math.ceil(i * (0.3183)) + 1;
            secondStart = (int) Math.ceil(i * (0.31831)) - 1;
            for (int j = secondStart; (j < secondLessFirst) & (j < secondLim); j++) {
                if ((delta = Math.abs(i - j * Math.PI)) < prevResult) {
                    firstResult = i;
                    secondResult = j;
                    prevResult = delta;
                }
            }
        }
        return new PiHolderImpl(firstResult, secondResult);
    }
}
