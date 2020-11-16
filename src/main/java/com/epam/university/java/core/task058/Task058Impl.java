package com.epam.university.java.core.task058;

public class Task058Impl implements Task058 {
    @Override
    public int[][] fillSpiral(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }

        int[][] matrix = new int[n][n];


        int number = 1;

        int rightBorder = n - 1;
        int bottomBorder = n - 1;
        int leftBorder = 0;
        int topBorder = 0;
        int maxValue = (int) Math.pow(n, 2);

        while (true) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                matrix[topBorder][i] = number;
                number++;
            }
            if (number > maxValue) {
                break;
            }
            topBorder++;

            for (int i = topBorder; i <= bottomBorder; i++) {
                matrix[i][rightBorder] = number;
                number++;
            }
            if (number > maxValue) {
                break;
            }
            rightBorder--;

            for (int i = rightBorder; i >= leftBorder; i--) {
                matrix[bottomBorder][i] = number;
                number++;
            }
            if (number > maxValue) {
                break;
            }
            bottomBorder--;

            for (int i = bottomBorder; i >= topBorder; i--) {
                matrix[i][leftBorder] = number;
                number++;
            }
            if (number > maxValue) {
                break;
            }
            leftBorder++;
        }

        return matrix;
    }
}
