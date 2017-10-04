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

        Collection<Integer> list;

        int index = 1;
        boolean wellFormed = false;
        do {
            list = new ArrayList<>();
            int intValue = Integer.valueOf(sourceString.substring(0, index++));
            wellFormed = isStringWell(list, sourceString, intValue);
        } while (!wellFormed && index < sourceString.length());

        if( wellFormed ) {
            return list;
        }

        return Collections.emptyList();
    }

    // isStringWell
    private boolean isStringWell(Collection<Integer> collection, String sourceString, int value) {

        if (null == sourceString || value < 1) {
            return false;
        }

        String strNumber = String.valueOf(value);
        collection.add(value);

        while (strNumber.length() < sourceString.length()) {
            collection.add(++value);
            strNumber += String.valueOf(value);
        }

        return sourceString.equals(strNumber);
    }
}
