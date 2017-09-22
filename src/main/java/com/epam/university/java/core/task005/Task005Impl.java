package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {

    int first;
    int second;

    @Override
    public PiHolder findPi(int digits) {

        if (digits < 1){
            throw new IllegalArgumentException();
        }
        double start = Math.pow(10, digits - 1);
        double end = Math.pow(10, digits);
        double min = 10;
        double current;
        for (double i = start*3; i < end; i++) {

            for (double j = start; j < (i + 1)/2; j++) {
                current = Math.abs((i / j) - Math.PI);
                if (current < min) {
                    min = current;
                    first = (int) i;
                    second = (int) j;
                }
            }
        }

        return new PiHolder() {
            @Override
            public int getFirst() {

                return first;
            }

            @Override
            public int getSecond() {

                return second;
            }
        };
    }
}
