package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        // Checking for positive argument
        checkArgument(digits);

        String stringA = "1";
        String stringB = "9";

        // Generating start and end points
        for (int i = 1; i < digits; i++) {
            stringA += "0";
            stringB += "9";
        }

        double startNumerator = Double.parseDouble(stringA);
        double endNumerator = Double.parseDouble(stringB);

        double currNumerator = 0;
        double currDenominator = 0;
        double currDiff = Double.MAX_VALUE;

        // Search for numerator and denominator
        for (double numerator = startNumerator; numerator < endNumerator; numerator++) {

            double denominator = (numerator / 4) >= startNumerator ? (int) Math.ceil(numerator / 4) : startNumerator;
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
        if (arg <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
