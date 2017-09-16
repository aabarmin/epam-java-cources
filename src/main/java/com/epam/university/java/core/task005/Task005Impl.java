package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        // Checking for positive argument
        checkArgument(digits);

        // Generating start and end points
        double startNumerator = Math.pow(10, (digits - 1));
        double endNumerator = (Math.pow(10, digits) - 1);

        double currNumerator = 0;
        double currDenominator = 0;
        double currDiff = Double.MAX_VALUE;

        // Search for numerator and denominator
        for (double numerator = startNumerator; numerator < endNumerator; numerator++) {

            // Denominator init
            double denominator;
            if ((numerator / 4) >= startNumerator) {
                denominator = (int) Math.ceil(numerator / 4);
            } else {
                denominator = startNumerator;
            }

            for (; denominator <= numerator / 3; denominator++) {
                if ((Math.abs((numerator / denominator) - Math.PI)) < currDiff) {
                    currNumerator = numerator;
                    currDenominator = denominator;
                    currDiff = Math.abs((numerator / denominator) - Math.PI);
                }
            }
        }

        return new PiHolderImpl((int) currNumerator, (int) currDenominator);
    }

    private void checkArgument(int arg) {
        if (arg < 1 || arg > 10) {
            throw new IllegalArgumentException();
        }
    }
}
