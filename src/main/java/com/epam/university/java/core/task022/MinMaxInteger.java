package com.epam.university.java.core.task022;

class MinMaxInteger {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    void min(int x) {
        min = Math.min(min, x);
    }

    void max(int x) {
        max = Math.max(max, x);
    }

    int getMin() {
        return min;
    }

    int getMax() {
        return max;
    }

}
