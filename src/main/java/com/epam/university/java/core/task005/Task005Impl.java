package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    private final static double COEF_RESTRICTION = Math.PI - (int)Math.PI;

    @Override
    strictfp public PiHolder findPi(int digits) {
        if (digits < 1) throw new IllegalArgumentException();

        final int startDenumerator = (int) Math.pow(10.0, digits - 1);
        final int endDenumerator = (int) (Math.pow(10.0, digits) * 0.34);

        PiHolderImpl holder = new PiHolderImpl((int) Math.PI * startDenumerator, startDenumerator);
        double eps;
        for (int denumerator = startDenumerator; denumerator < endDenumerator; denumerator++) {

            int startNumerator = 3 * denumerator;
            int endNumerator = (int) Math.min(denumerator * 4, Math.pow(10, digits) - 1);


            for (int numerator = startNumerator; numerator <= endNumerator; numerator++) {
                eps = Math.abs((double) (numerator) / (double) denumerator - Math.PI);
                if (eps < holder.valueOfEps()) {
                    holder.setFirst(numerator);
                    holder.setSecond(denumerator);
                }
            }
        }

        return holder;
    }
}
