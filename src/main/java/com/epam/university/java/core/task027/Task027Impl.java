package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {

        ArrayList<Integer> inter = new ArrayList<>();

        int numberOfDigits = 1;

        int length = sourceString.length();

        int begin = 0;

        if (sourceString.charAt(0) == '0' || sourceString.length() < 2) {
            return inter;
        }

        for (int i = 0; i < length; i += numberOfDigits) {
            if (!checkNumber(inter)) {
                if (!(countDigits(inter.get(inter.size() - 1))
                        > countDigits(inter.get(inter.size() - 2)))) {
                    numberOfDigits += 1;
                }
                inter.clear();
                i = begin;
            }
            if (!checkNumberOfDigits(inter, numberOfDigits)) {
                numberOfDigits += 1;
            }
            inter.add(Integer.parseInt(sourceString.substring(i,i + numberOfDigits)));
            if (numberOfDigits >= length / 2) {
                if (!checkNumber(inter)) {
                    inter.clear();
                    return inter;
                }
            }
        }
        return inter;
    }

    private boolean checkNumber(ArrayList<Integer> list) {
        boolean isCorrect = true;
        if ((list.size() != 0)) {
            if (list.get(list.size() - 1) == 0) {
                isCorrect = false;
            }
        }
        if (list.size() >= 2) {
            isCorrect = (list.get(list.size() - 1) - list.get(list.size() - 2)) == 1;
        }

        return isCorrect;
    }

    private boolean checkNumberOfDigits(ArrayList<Integer> list, int numberOfDigits) {
        if (!list.isEmpty()
                && countDigits(list.get(list.size() - 1) + 1) > numberOfDigits) {
            return false;
        }
        return true;
    }

    private int countDigits(int number) {
        return Integer.toString(number).length();
    }
}
