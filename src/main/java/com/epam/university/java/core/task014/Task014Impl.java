package com.epam.university.java.core.task014;


import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Collection;


public class Task014Impl implements Task014 {

    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> vampireNumber = new ArrayList<>();
        double sum;
        double mult;
        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {

                sum = i + j;

                mult = j * i;

                if ((sum % 9 == mult % 9)
                        && mult > 1000
                        && checkInserion(i, j)
                        && !vampireNumber.contains(new VampireNumberImpl(i * j, i, j))) {
                    vampireNumber.add(new VampireNumberImpl(i * j, j, i));
                }
            }
        }
        return vampireNumber;
    }

    private boolean checkInserion(int i, int j) {
        boolean result;
        char[] mult = String.valueOf(i * j).toCharArray();
        char[] firstNumber = String.valueOf(i).toCharArray();
        char[] secondNumber = String.valueOf(j).toCharArray();
        char[] fs = ArrayUtils.addAll(firstNumber, secondNumber);
        ArrayList<Character> resultList = new ArrayList<>();
        ArrayList<Character> fss = new ArrayList<>();
        for (char c: mult) {
            resultList.add(c);
        }
        for (char c: fs) {
            fss.add(c);
        }
        result = resultList.containsAll(fss) && fss.containsAll(resultList);
        return result;
    }
}
