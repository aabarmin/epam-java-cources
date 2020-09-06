package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 10) {
            throw new IllegalArgumentException("Unsupported argument.");
        }
        PiHolderImpl min = new PiHolderImpl();
        double start = Math.pow(10, digits - 1);
        double stop = Math.pow(10, digits) - 1;
        double temp = start;
        for (double i = start; i <= stop; i++) {
            for (double j = start; j < i / 2; j++) {
                if (Math.abs((i / j) - Math.PI) < temp) {
                    temp = Math.abs((i / j) - Math.PI);
                    min.setFirst((int) i);
                    min.setSecond((int) j);
                }
            }
        }
        return min;
    }
}
