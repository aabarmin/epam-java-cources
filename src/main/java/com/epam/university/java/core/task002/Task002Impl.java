package com.epam.university.java.core.task002;

import com.epam.university.java.core.util.Utils;

/**
 * Implementation of the operations with strings.
 */
public class Task002Impl implements Task002 {

    /**
     * Check if strings are equal.
     *
     * @param firstString first string instance
     * @param secondString second string instance
     * @return if string are equal
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public boolean isEquals(String firstString, String secondString)
        throws IllegalArgumentException {
        Utils.assertNonNull(firstString, secondString);
        return firstString.equals(secondString);
    }

    /**
     * Get first @{number} symbols of the given string.
     *
     * @param sourceString source string
     * @param number amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    @Override
    public String left(String sourceString, int number) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString);
        Utils.assertNonNegative(number);
        return sourceString.substring(0, Math.min(number, sourceString.length()));
    }

    /**
     * Get the characters before separator.
     *
     * @param sourceString source string
     * @param separator separator
     * @return characters before separator
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String left(String sourceString, String separator) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString, separator);
        int idx = sourceString.indexOf(separator);
        return sourceString.substring(0, Math.min(Math.max(idx, 0), sourceString.length()));
    }

    /**
     * Get last @{number} symbols of the given string.
     *
     * @param sourceString source string
     * @param number amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    @Override
    public String right(String sourceString, int number) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString);
        Utils.assertNonNegative(number);
        return sourceString.substring(Math.max(0, sourceString.length() - number));
    }

    /**
     * Get the characters after separator.
     *
     * @param sourceString source string
     * @param separator separator
     * @return characters before separator
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String right(String sourceString, String separator) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString, separator);
        int idx = sourceString.indexOf(separator);
        return sourceString.substring(Math.min(sourceString.length(), idx + separator.length()));
    }

    /**
     * Split source string by split sequence.
     * @param sourceString source string
     * @param split pattern to split for
     * @return array of tokens
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String[] split(String sourceString, String split) throws IllegalArgumentException {
        Utils.assertNonNull(sourceString, split);
        return sourceString.split(split);
    }

    /**
     * Connect array of strings with the delimiter.
     *
     * @param sourceCollection collection of strings
     * @param glue delimiter character
     * @return result string
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String join(String[] sourceCollection, String glue) throws IllegalArgumentException {
        Utils.assertArrayNonNull(sourceCollection);
        Utils.assertNonNull(glue);
        return String.join(glue, sourceCollection);
    }

}
