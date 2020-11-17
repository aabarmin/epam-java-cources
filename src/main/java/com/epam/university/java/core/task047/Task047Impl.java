package com.epam.university.java.core.task047;

public class Task047Impl implements Task047 {

    @Override
    public long calculateInversions(int n, int[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        int amountOfInversions = 0;
        for (int i = 0; i < a.length; i++) {
            int current = a[i];
            int comparable;
            for (int j = i; j < a.length; j++) {
                comparable = a[j];
                if (current > comparable) {
                    amountOfInversions++;
                }
            }
        }
        return amountOfInversions;
    }
}
