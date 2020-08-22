package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    private PiHolderImpl piHolder;

    public Task005Impl() {
        this.piHolder = new PiHolderImpl();
    }

    @Override
    public PiHolder findPi(int digits) {
        if (digits <= 0 || digits > 9) {
            throw new IllegalArgumentException();
        }
        double start = Math.pow(10, digits - 1);
        double end = Math.pow(10, digits) - 1;
        double min = start;

        for (double i = start; i <= end; i++) {
            for (double j = start; j < i / 2; j++) {

                double x = Math.abs((i / j) - Math.PI);

                if (x < min) {
                    min = x;
                    piHolder.setFirst((int) i);
                    piHolder.setSecond((int) j);

                }
            }

        }

        return piHolder;
    }
}
