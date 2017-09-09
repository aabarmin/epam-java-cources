package com.epam.university.java.core.task002;

/**
 * Work with strings.
 */
public interface Task002 {
    /**
     * Check if strings are equals.
     * @param firstString first string instance
     * @param secondString second string instance
     * @return if string are equals
     * @throws IllegalArgumentException if strings not provided
     */
    boolean isEquals(String firstString, String secondString);

    /**
     * Get most left @{number} of symbols.
     * @param sourceString source string
     * @param number amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    String left(String sourceString, int number);

    /**
     * Get the characters before separator.
     * @param sourceString source string
     * @param separator separator
     * @return characters before separator
     * @throws IllegalArgumentException if strings not provided
     */
    String left(String sourceString, String separator);

    /**
     * Get most right @{number} of symbols.
     * @param sourceString source string
     * @param number amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    String right(String sourceString, int number);

    /**
     * Get the characters after separator.
     * @param sourceString source string
     * @param separator separator
     * @return characters after separator
     * @throws IllegalArgumentException if strings not provided
     */
    String right(String sourceString, String separator);

    /**
     * Split source string by split character.
     * @param sourceString source string
     * @param split character to split for
     * @return array of parts
     * @throws IllegalArgumentException if strings not provided
     */
    String[] split(String sourceString, String split);

    /**
     * Connect array of strings with glue.
     * @param sourceCollection collection of strings
     * @param glue glue character
     * @return result string
     * @throws IllegalArgumentException if strings not provided
     */
    String join(String[] sourceCollection, String glue);
}
