package com.epam.university.java.core.task002;

/**
 * Created by Romin Nuro on 14.08.2020 0:51.
 */
public class Task002Impl implements Task002 {
    /**
     * Check if strings are equals.
     *
     * @param firstString  first string instance
     * @param secondString second string instance
     * @return if string are equals
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }
        return firstString.equals(secondString);
    }

    /**
     * Get most left @{number} of symbols.
     *
     * @param sourceString source string
     * @param number       amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()) {
            number = sourceString.length();
        }
        return sourceString.substring(0, number);
    }

    /**
     * Get the characters before separator.
     *
     * @param sourceString source string
     * @param separator    separator
     * @return characters before separator
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.split(separator)[0];
    }

    /**
     * Get most right @{number} of symbols.
     *
     * @param sourceString source string
     * @param number       amount of symbols to return
     * @return new string
     * @throws IllegalArgumentException if string not provided or number less then zero
     */
    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number);
    }

    /**
     * Get the characters after separator.
     *
     * @param sourceString source string
     * @param separator    separator
     * @return characters after separator
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        if (!sourceString.contains(separator)) {
            return sourceString;
        }
        return sourceString.split(separator)[1];
    }

    /**
     * Split source string by split character.
     *
     * @param sourceString source string
     * @param split        character to split for
     * @return array of parts
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.split(split);
    }

    /**
     * Connect array of strings with glue.
     *
     * @param sourceCollection collection of strings
     * @param glue             glue character
     * @return result string
     * @throws IllegalArgumentException if strings not provided
     */
    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null
                || glue == null
                || sourceCollection.length == 0) {
            throw new IllegalArgumentException();
        }
        String result = sourceCollection[0];
        for (int i = 1; i < sourceCollection.length; i++) {
            result = result.concat(glue).concat(sourceCollection[i]);
        }
        return result;
    }
}