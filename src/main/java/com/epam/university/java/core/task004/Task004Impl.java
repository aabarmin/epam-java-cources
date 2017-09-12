package com.epam.university.java.core.task004;

import java.util.Arrays;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        int intersectIndex = 0;

        String[] firstCopy = Arrays.copyOf(first, first.length);
        String[] secondCopy = Arrays.copyOf(second, second.length);
        String[] preResult = new String[Math.min(first.length, second.length)];
        for (int i = 0; i < firstCopy.length; i++) {
            for (int j = 0; j < secondCopy.length; j++) {
                if (firstCopy[i] != null && secondCopy[j] != null) {
                    if (firstCopy[i].equals(secondCopy[j])) {
                        preResult[intersectIndex++] = firstCopy[i];
                        firstCopy[i] = null;
                        secondCopy[j] = null;
                    }

                }
            }
        }
        String[] result = new String[intersectIndex];
        System.arraycopy(preResult, 0, result, 0, result.length);

        return result;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] firstCopy = Arrays.copyOf(first, first.length);
        String[] secondCopy = Arrays.copyOf(second, second.length);
        String[] intersection = intersection(firstCopy, secondCopy);
        String[] result = new String[firstCopy.length + secondCopy.length - intersection.length];
        int resultIndex = 0;
        for (int i = 0; i < firstCopy.length; i++) {
            for (int j = 0; j < intersection.length; j++) {
                if (intersection[j] != null) {
                    if (firstCopy[i].equals(intersection[j])) {
                        firstCopy[i] = null;
                        intersection[j] = null;
                        break;
                    }
                }
            }
            if (firstCopy[i] != null) {
                result[resultIndex++] = firstCopy[i];
            }
        }
        for (int i = 0; i < secondCopy.length; i++) {
            result[resultIndex++] = secondCopy[i];
        }
        return result;
    }
}
