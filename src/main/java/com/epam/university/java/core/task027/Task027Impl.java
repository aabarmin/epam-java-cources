package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Romin Nuro on 08.09.2020 16:31.
 */
public class Task027Impl implements Task027 {
    /**
     * Given a number string that can be split into the sequence of two or more positive
     * integers [a1, a2, ..., an] satisfying the following conditions:
     *
     * <p>
     * 1. ai - a(i-1) = 1 for any element
     * 2. No ai contains a leading zero
     * 3. Content of the sequence cannot be rearranged.
     * </p>
     *
     * <p>
     * You should extract that numbers or return an empty collection if it is not possible.
     * </p>
     *
     * <p>
     * Example: given a string "1234", result should be [1, 2, 3, 4]
     * Example: given a string "91011", result should be [9, 10, 11]
     * Example: given a string "99100", result should be [99, 100]
     * Example: given a string "4123", result should be []
     * </p>
     *
     * @param sourceString source string
     * @return collection of extracted integers
     */
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= sourceString.length() / 2; i++) {
            List<Integer> result = new ArrayList<>();
            String sequence = sourceString.substring(0, i);
            int first = Integer.parseInt(sequence);
            if (first == 0) {
                break;
            }
            result.add(first);
            int counter = 1;
            while (sequence.length() < sourceString.length()) {
                sequence = sequence.concat(String.valueOf(first + counter));
                result.add(first + counter);
                counter++;
            }
            if (sourceString.equals(sequence)) {
                return result;
            }
        }
        return new ArrayList<Integer>();
    }
}
