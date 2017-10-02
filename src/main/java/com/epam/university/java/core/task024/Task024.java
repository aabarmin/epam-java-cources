package com.epam.university.java.core.task024;

import java.util.Collection;

/**
 * Camels and cases.
 */
public interface Task024 {
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
    Collection<String> getWordsCount(String source);
}
