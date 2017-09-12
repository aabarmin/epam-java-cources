package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0) {
            throw new IllegalArgumentException();
        }

        int first = (int)Math.pow(10,digits - 1);
        int second = (int)(Math.pow(10,digits) - 1);
        double near = Double.MAX_VALUE;
        double resultNumerator = 0;
        double resultDenominator = 0;

        for (double numerator = first; numerator < second; numerator++) {
            double denominator;
            if ((numerator / 4) >= first) {
                denominator = (int) Math.ceil(numerator / 4);
            } else {
                denominator = first;
            }

            for (; denominator <= numerator / 3; denominator++) {
                if ((Math.abs((numerator / denominator) - Math.PI)) < near) {
                    resultNumerator = numerator;
                    resultDenominator = denominator;
                    near = Math.abs((numerator / denominator) - Math.PI);
                }
            }
        }

        return new PiHolderImpl((int) resultNumerator, (int) resultDenominator);
    }
}
