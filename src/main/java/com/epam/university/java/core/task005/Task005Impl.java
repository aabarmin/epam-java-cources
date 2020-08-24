package com.epam.university.java.core.task005;

import static java.lang.Math.PI;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }

        int start = (int) (Math.pow(10, digits - 1));
        int end = (int) (Math.pow(10, digits) - 1);

        double marker = Double.MAX_VALUE;

        PiHolder holder = null;

        for (int j = start; j < end - 1; j++) {
            double jVal = j * PI;
            for (int i = j + 1; i <= end; i++) {
                double quont = Math.abs(i - jVal);

                if (quont < marker) {
                    marker = quont;
                    holder = new PiHolderImpl(i, j);
                }
            }
        }

        return holder;
    }
}
