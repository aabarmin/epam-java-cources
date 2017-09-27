package com.epam.university.java.core.task024;

import com.epam.university.java.core.util.Utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Camels and cases.
 */
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
        Utils.assertNonNull(source);
        final String pattern = "(?=\\p{Lu})"; // handles non-ascii uppercase letters
        return source.isEmpty()
            ? Collections.emptyList()
            : Arrays.stream(source.split(pattern))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

}
