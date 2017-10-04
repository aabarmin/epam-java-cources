package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Implementation class for Task026.
 *
 * @author Sergei Titov
 */
public class Task027Impl implements Task027 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Integer> extract(String sourceString) {

        int digitsCount = 1;
        boolean wellFormed;
        Collection<Integer> list;

        do {
            list = new ArrayList<>();
            wellFormed = isStringWell(list,
                    sourceString,
                    Integer.valueOf(sourceString.substring(0, digitsCount++)));

        } while (!wellFormed && digitsCount < sourceString.length());

        if (wellFormed) {
            return list;
        }

        return Collections.emptyList();
    }

    // isStringWell
    private boolean isStringWell(Collection<Integer> collection, String sourceString, int value) {

        if (null == sourceString || value < 1) {
            return false;
        }

        String digits = String.valueOf(value);
        collection.add(value);

        while (digits.length() < sourceString.length()) {
            collection.add(++value);
            digits += String.valueOf(value);
        }

        return sourceString.equals(digits);
    }
}
