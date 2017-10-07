package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Implementation class for Task027.
 *
 * @author Sergei Titov
 */
public class Task027Impl implements Task027 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Integer> extract(String sourceString) {

        if (null == sourceString || sourceString.length() < 2) {
            return Collections.emptyList();
        }

        int position = 1;
        boolean wellFormed;
        Collection<Integer> list = new ArrayList<>();

        do {
            list.clear();
            wellFormed = isStringWell(list,
                    sourceString,
                    Integer.valueOf(sourceString.substring(0, position++)));

        } while (!wellFormed && position < sourceString.length());

        if (!wellFormed) {
            list.clear();
        }
        return list;
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
