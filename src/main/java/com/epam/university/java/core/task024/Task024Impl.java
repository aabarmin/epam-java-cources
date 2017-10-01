package com.epam.university.java.core.task024;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Task024Impl implements Task024 {

    /**
     * Given a string with camel case word, you should separate this string
     * into collection of words.
     *
     * <p>
     *     Example: source string is saveChangesInTheEditor, result is
     *     [save, changes, in, the, editor]
     * </p>
     *
     * @param source source string
     * @return collection of words
     */
    @Override
    public Collection<String> getWordsCount(String source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        List<String> strings = new LinkedList<>();

        if (source.length() == 0) {
            return strings;
        }


        char[] sourceCharArray = source.toCharArray();
        sourceCharArray[0] = Character.toLowerCase(sourceCharArray[0]);

        int k = 0;
        int i;

        for (i = 0; i < sourceCharArray.length; ++i) {

            char c = sourceCharArray[i];
            sourceCharArray[i] = Character.toLowerCase(c);

            if (sourceCharArray[i] != c) {
                strings.add(new String(Arrays.copyOfRange(sourceCharArray, k, i)));
                k = i;
            }

        }

        strings.add(new String(Arrays.copyOfRange(sourceCharArray, k, i)));

        return strings;

    }

}
