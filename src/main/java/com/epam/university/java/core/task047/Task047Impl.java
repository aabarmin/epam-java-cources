package com.epam.university.java.core.task047;

import java.util.Arrays;

public class Task047Impl implements Task047 {

    private int amountOfInversions = 0;

    @Override
    public long calculateInversions(int n, int[] a) {
        if (a == null) {
            throw new IllegalArgumentException();
        }

        int[] array = Arrays.copyOf(a, n);
        sortUnsorted(array, 0, n - 1);

        return amountOfInversions;
    }

    private void sortUnsorted(int[] a, int begin, int end) {

        if (begin == end) {
            return;
        }

        int middle = begin + (end - begin) / 2;

        sortUnsorted(a, begin, middle);
        sortUnsorted(a, middle + 1, end);

        int[] buf = Arrays.copyOf(a, a.length);

        int i = begin;
        int j = middle + 1;
        for (int k = begin; k <= end; k++) {

            if (i > middle) {

                a[k] = buf[j];
            } else if (j > end) {

                a[k] = buf[i];

            } else if (buf[j] < buf[i]) {

                a[k] = buf[j];
                j++;
            } else {

                a[k] = buf[i];
                i++;
            }
        }
    }
}
