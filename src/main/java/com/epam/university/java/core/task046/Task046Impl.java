package com.epam.university.java.core.task046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task046Impl implements Task046 {
    @Override
    public List<String> assembleMatryoshka(Integer k, Integer n) {
        if (k == null || n == null) {
            throw new IllegalArgumentException();
        }
        if (k == 1 && n == 1) {
            return List.of("0");
        }
        final List<String> ways = new ArrayList<>();
        final int[] doll = new int[k];
        final int[] digits = new int[n];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = i;
        }
        int amountOfCombs = (int) Math.pow(2, n);
        String binaryString;

        for (int i = 0; i < amountOfCombs; i++) {
            binaryString = Integer.toBinaryString(i);
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }
            if (!binaryString.contains("0") || !binaryString.contains("1")) {
                continue;
            }
            int[] digitsToTry = new int[n];
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (binaryString.charAt(j) == '1') {
                    digitsToTry[index] = digits[j];
                    index++;
                }
            }

            if (index != k) {
                continue;
            }

            for (int j = 0; j < k; j++) {
                doll[j] = digitsToTry[j];
            }

            if (matryoshkaCheck(doll)) {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < doll.length; j++) {
                    if (j + 1 != doll.length) {
                        line.append(doll[j]).append(" ");
                    } else {
                        line.append(doll[j]);
                    }
                }
                if (!ways.contains(line.toString())) {
                    ways.add(line.toString());
                }
            }
        }

        return ways;
    }

    private boolean matryoshkaCheck(int[] doll) {
        for (int i = doll.length - 1; i > 0; i--) {
            if (doll[i] < doll[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
