package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Александр on 01.10.2017.
 * Sequence of two or more positive integers
 */
public class Task027Impl implements Task027 {
    /**
     * Given a number string that can be split into the sequence of two or more positive
     * integers [a1, a2, ..., an] satisfying the following conditions:
     *
     * <p>
     *     1. ai - a(i-1) = 1 for any element
     *     2. No ai contains a leading zero
     *     3. Content of the sequence cannot be rearranged.
     * </p>
     *
     * <p>
     *     You should extract that numbers or return an empty collection if it is not possible.
     * </p>
     *
     * <p>
     *     Example: given a string "1234", result should be [1, 2, 3, 4]
     *     Example: given a string "91011", result should be [9, 10, 11]
     *     Example: given a string "99100", result should be [99, 100]
     *     Example: given a string "4123", result should be []
     * </p>
     *
     * @param sourceString source string
     * @return collection of extracted integers
     */
    @Override
    public Collection<Integer> extract(String sourceString) {
        List<Integer> result = new ArrayList<>();
        Pattern pattern;
        Matcher matcher;
        for (int i = 1; i < sourceString.length(); i++) {
            int value = Integer.valueOf(sourceString.substring(0, i));
            String nextString = sourceString.substring(i, sourceString.length());
            pattern = Pattern.compile("(^" + String.valueOf(value + 1) + ")(\\d*)");
            matcher = pattern.matcher(nextString);
            result.clear();
            if (value == 0) {
                return result;
            }
            result.add(value);


            while (matcher.matches()) {
                pattern = Pattern.compile("(^" + String.valueOf(value + 1) + ")(\\d*)");
                matcher = pattern.matcher(nextString);
                if (matcher.find()) {
                    value = Integer.valueOf(matcher.group(1));
                    result.add(value);
                    nextString = matcher.group(2);
                    if (nextString.isEmpty()) {
                        return result;
                    }
                } else {
                    break;
                }
            }
        }

        return new ArrayList<>();
    }

}
