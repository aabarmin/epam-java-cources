package com.epam.university.java.core.task004;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] tempArray = new String[Math.min(first.length, second.length)];
        int sizeOfOutputArray = 0;
        for (String element : first) {
            for (String elementFromSecond : second) {
                if (element.equals(elementFromSecond)) {
                    tempArray[sizeOfOutputArray++] = element;
                }
            }
        }
        String[] outputArray = new String[sizeOfOutputArray];
        System.arraycopy(tempArray, 0, outputArray, 0, sizeOfOutputArray);
        return outputArray;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        String[] tempArray = new String[first.length + second.length];
        int indexOfOutputArray = first.length;
        System.arraycopy(first, 0, tempArray, 0, first.length);
        boolean isUnique;
        for (String elementFromSecond : second) {
            isUnique = true;
            for (String elementFromFirst : first) {
                if (elementFromFirst.equals(elementFromSecond)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                tempArray[indexOfOutputArray++] = elementFromSecond;
            }
        }
        String[] outputArray = new String[indexOfOutputArray];
        System.arraycopy(tempArray, 0, outputArray, 0, indexOfOutputArray);
        return outputArray;
    }
}
