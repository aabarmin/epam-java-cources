package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0) {
            throw new IllegalArgumentException();
        }
        int firstNumber = (int) ((Math.pow(10, digits) - 1) / Math.PI);
        int lastNumber = (int) (Math.pow(10, digits) - 1);
        double min = Double.MAX_VALUE;
        int first = 0;
        int second = 0;
        double current;
        int j;
        for (int i = firstNumber; i <= lastNumber; i++) {
            for (int k = 0; k < 2; k++) {
                j = (int) (i / Math.PI) + k;
                current = Math.abs(Math.PI - (double) i / j);
                if (current < min) {
                    min = current;
                    first = i;
                    second = j;
                }
            }

        }
        PiHolder result = new PiHolderImpl(first, second);
        return result;
    }
}
