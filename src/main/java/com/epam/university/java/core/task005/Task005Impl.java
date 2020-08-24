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

                if ((Math.abs((double) first / second - Math.PI)) < (Math.abs((double) fOut / sOut - Math.PI))) {
                    fOut = first;
                    sOut = second;
                }
                second++;
            }
            first++;
            second = min;
        }
/*
        switch (digits) {
               case 1:
                first = 3;
                second = 1;
                break;
            case 2:
                first = 44;
                second = 14;
                break;
            case 3:
                first = 355;
                second = 113;
                break;
            case 4:
                first = 99773;
                second = 31746;
                break;
            case 5:
                first = 99733;
                second = 31746;
            case 6:

        }*/
        return new PiHolderImpl(fOut, sOut);
    }
}
