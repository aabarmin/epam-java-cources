package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {

        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;
        int first = min;
        int second = min;
        int fOut = min;
        int sOut = min;

        while (first < max) {
            while (second < max) {
                if (second > (first / 3)) {
                    break;
                }

                if ((Math.abs((double) first / second - Math.PI))
                        < (Math.abs((double) fOut / sOut - Math.PI))) {
                    fOut = first;
                    sOut = second;
                }
                second++;
            }
            first++;
            second = min;
        }

        return new PiHolderImpl(fOut, sOut);
    }
}
