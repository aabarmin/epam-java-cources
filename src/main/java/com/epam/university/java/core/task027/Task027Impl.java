package com.epam.university.java.core.task027;


import java.util.Collection;
import java.util.LinkedList;


public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        int numOfDigits = 1;
        int curPosition = 0;
        int candidate = 0;
        boolean enoughNumbers = false;
        LinkedList<Integer> resultList = new LinkedList<>();

        int first = getNumber(sourceString, curPosition, numOfDigits);
        if (first == 0) {
            return new LinkedList<>();
        }

        resultList.add(first);
        curPosition += numOfDigits;

        while (curPosition + numOfDigits <= sourceString.length()) {
            candidate = getNumber(sourceString, curPosition, numOfDigits);
            if (String.valueOf(candidate).length() < numOfDigits) {
                int last = resultList.removeLast();
                candidate = Integer.parseInt(String.valueOf(last) + '0');
                resultList.addLast(candidate);
                curPosition++;
                //numOfDigits++;
                enoughNumbers = false;
                continue;
            }
            if (candidate <= resultList.getLast()) {
                numOfDigits++;
                enoughNumbers = false;
                continue;
            } else {
                if (candidate - resultList.getLast() != 1) {
                    int last = resultList.removeLast();
                    candidate = Integer.parseInt(String.valueOf(last)
                            + String.valueOf(candidate).charAt(0));
                    resultList.addLast(candidate);
                    curPosition++;
                    continue;
                }

            }
            resultList.addLast(candidate);
            enoughNumbers = true;
            curPosition += numOfDigits;
        }
        if (!enoughNumbers) {
            int last = resultList.removeLast();
            return new LinkedList<>();
            // candidate = Integer.parseInt(String.valueOf(last) + String.valueOf(candidate));
            //  resultList.addLast(candidate);
        }


        return resultList;
    }

    public int getNumber(String sourceString, int startPosition, int length) {
        return Integer.valueOf(sourceString.substring(startPosition, startPosition + length));
    }


}
