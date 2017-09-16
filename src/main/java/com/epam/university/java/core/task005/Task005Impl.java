package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        int start = (int) Math.pow(10, digits - 1);
        int end = ((int) Math.pow(10, digits)) - 1;
        double min = 10;
        double current;
        for (int i = start; i <  ; i++) {
            for (int j = start - 1; j > start; j--) {
                current = Math.abs((i / j) - Math.PI);
                if (current < min) {
                    min = current;
                }
            }
        }
        System.out.println(0.4f + 0.3f);
        return null;
    }
}
