package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits == 0 || digits > 10) {
            throw new IllegalArgumentException();
        }

        String numberLow = "1";
        String numberMax = "9";
        for (int i = 0; i < digits - 1; i++) {
            numberLow += 0;
            numberMax += 9;
        }

        int low = Integer.parseInt(numberLow);
        int lowForFirst = low;
        int maxForFirst = Integer.parseInt(numberMax);;
        int maxForSecond = maxForFirst / 3;

        int firstValue = 1;
        int secondValue = 1;
        double resultValue = 9;

        if (digits > 4) {
            lowForFirst = lowForFirst * 9;
        }

        for (int first = lowForFirst; first < maxForFirst; first++) {
            for (int second = low; second < maxForSecond; second++) {
                double value = Math.abs(((double) first / second) - Math.PI);
                if (resultValue > value) {
                    resultValue = value;
                    firstValue = first;
                    secondValue = second;
                }
            }
        }
        return new PiHolderImpl(firstValue, secondValue);
    }
}
