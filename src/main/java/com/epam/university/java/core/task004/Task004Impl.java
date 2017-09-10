package com.epam.university.java.core.task004;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] tempArray = new String[Math.min(first.length, second.length)];
        int sizeOfOutputArray = 0;
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i].equals(second[j])) {
                    tempArray[sizeOfOutputArray++] = first[i];
                }
            }
        }
        String[] outputArray = new String[sizeOfOutputArray];
        for (int i = 0; i < sizeOfOutputArray; i++) {
            outputArray[i] = tempArray[i];
        }
        return outputArray;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        return new String[0];
    }
}
