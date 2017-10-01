package com.epam.university.java.core.task027;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Numbers extraction.
 */
public class Task027Impl implements Task027 {

    /**
     * Given a number string that can be split into the sequence of two or more positive
     * integers [a1, a2, ..., an] satisfying the following conditions:
     * <p>
     *     1. ai - a(i-1) = 1 for any element
     *     2. No ai contains a leading zero
     *     3. Content of the sequence cannot be rearranged.
     * </p>
     * <p>
     *     Example: given a string "1234", result should be [1, 2, 3, 4]
     *     Example: given a string "91011", result should be [9, 10, 11]
     *     Example: given a string "99100", result should be [99, 100]
     *     Example: given a string "4123", result should be []
     * </p>
     *
     * @param sourceString source string
     * @return collection of extracted integers if all conditions are satisfied,
     *         else empty collection
     */
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString.length() < 2) {
            return Collections.emptyList();
        }
        final int halfSize = sourceString.length() / 2;
        for (int len = 1; len <= halfSize; ++len) {
            final Collection<Integer> res = new HashSet<>();
            String tempNumString = sourceString.substring(0, len);
            int index = len;
            while (index < sourceString.length()) {
                final int first = Integer.parseInt(tempNumString);
                final int second = first + 1;
                final String secondString = String.valueOf(second);
                final String potentialSecondString =
                    sourceString.substring(index, index + secondString.length());
                if (!secondString.equals(potentialSecondString)
                    || tempNumString.startsWith("0")) {
                    break;
                }
                res.add(first);
                res.add(second);
                tempNumString = potentialSecondString;
                index += secondString.length();
            }
            if (index == sourceString.length()) {
                return res;
            }
        }
        return Collections.emptyList();
    }

}
