package com.epam.university.java.core.task005;

/**
 * Created by Doomsday Device on 20.09.2017.
 */
public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException();
        }

        int first = 0;
        int second = 0;

        int startNumber = (int) (Math.pow(10, digits - 1));
        int finishNumber = (int) Math.pow(10, digits) - 1;

        double result = 0;
        double min = 1;

        for (int i = (int)(startNumber * Math.PI); i <= finishNumber; i++) {
            for (int j = startNumber; j < i; j++) {
                double a = i;
                double b = j;
                result = Math.abs((a / b) - Math.PI);
                if (result < min) {
                    min = result;
                    first = i;
                    second = j;
                }
                if (j > i / 3) {
                    break;
                }
            }
        }

        PiHolderImpl piHolder = new PiHolderImpl(first, second);
        return piHolder;
    }
}
