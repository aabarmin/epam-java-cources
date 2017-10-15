package com.epam.university.java.core.task014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * {@inheritDoc}
 */
public class Task014Impl implements Task014 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        Collection<VampireNumber> listOfVNumbers = new HashSet<>();
        int result = 0;

        for (int i = 11; i < 99; i++) {
            for (int j = 11; j < 99; j++) {
                result = i * j;
                if (result < 1000) {
                    continue;
                }
                if (result > 9999) {
                    break;
                }
                if (isVampire(result, i, j)) {
                    listOfVNumbers.add(new VampireNumberImpl(result, i, j));
                }
            }
        }
        return listOfVNumbers;
    }

    /**
     * Check if number is vampire.
     *
     * @param mult   result of multiplication of first and second
     * @param first  first multiplier
     * @param second second multiplier
     * @return true if its vampire
     */
    private boolean isVampire(int mult, int first, int second) {
        List<String> removeList = new ArrayList<>();

        removeList.add(first / 10 + "");
        removeList.add(first % 10 + "");
        removeList.add(second / 10 + "");
        removeList.add(second % 10 + "");
        List<String> multList = Arrays.asList(String.valueOf(mult).split(""));
        Collections.sort(multList);
        Collections.sort(removeList);
        return multList.equals(removeList);
    }
}
