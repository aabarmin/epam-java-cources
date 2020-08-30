package com.epam.university.java.core.task014;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task014Impl implements Task014 {
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> vampireNumbers = new ArrayList<>();

        for (int i = 1011; i < 10000; i++) {

            String strI = String.valueOf(i);
            int count = StringUtils.countMatches(strI, "0");
            if (count > 1) {
                continue;
            }

            ArrayList<String> digitList = new ArrayList<>(Arrays.asList(strI.split("")));
            ArrayList<String> newDigitList = calcCombo(digitList);
            ArrayList<Integer> added = new ArrayList<>();

            for (String pair : newDigitList) {
                for (String s : newDigitList) {

                    ArrayList<String> resultList = new ArrayList<>(Arrays.asList(pair.split("")));
                    resultList.addAll(Arrays.asList(s.split("")));

                    int firstPair = Integer.parseInt(pair);
                    int secondPair = Integer.parseInt(s);
                    int result = firstPair * secondPair;

                    if (result == i && CollectionUtils.isEqualCollection(resultList, digitList)) {
                        if (!added.contains(result)) {
                            VampireNumberImpl vampireNumber;
                            vampireNumber = new VampireNumberImpl(result, firstPair, secondPair);
                            vampireNumbers.add(vampireNumber);
                            added.add(result);
                        }
                    }
                }
            }
        }
        return vampireNumbers;
    }

    /**
     * Calculate combination of presented digits.
     * @param digitList list of digits
     * @return list of combinations
     */
    public ArrayList<String> calcCombo(ArrayList<String> digitList) {
        ArrayList<String> combinations = new ArrayList<>();
        for (int i = 0; i < digitList.size(); i++) {
            for (int j = 0; j < digitList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (digitList.get(i).equals("0")) {
                    continue;
                }
                combinations.add(digitList.get(i) + digitList.get(j));

            }
        }
        return combinations;
    }
}
