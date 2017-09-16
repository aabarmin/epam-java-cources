package com.epam.university.java.core.task002;

import com.epam.university.java.core.ChecksHelper;

/**
 * implemenaion class for String operations.
 *
 * @author Sergei Titov
 */
public class Task002Impl implements Task002 {

    /**
     * compares two strings.
     *
     * @param firstString first string instance
     * @param secondString second string instance
     *
     * @return true if string are equal
     *
     * @throws IllegalArgumentException if sourceCollection is null
     */
    @Override
    public boolean isEquals(String firstString, String secondString)
            throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(firstString,  secondString);
        ChecksHelper.checkForEmptyBothArguments(firstString,  secondString);
        return firstString.equals(secondString);
    }

    /**
     * gets left substring.
     *
     * @param sourceString source string
     * @param number amount of symbols to return
     *
     * @returns substring (number of letters)
     *
     * @throws IllegalArgumentException if sourceString is null or number is negative
     */
    @Override
    public String left(String sourceString, int number) throws IllegalArgumentException {

        ChecksHelper.checkForNull(sourceString);
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        int count = number >= sourceString.length() ?
                sourceString.length() :
                number;

        return sourceString.substring(0, count);
    }

    /**
     * gets left substring.
     *
     * @param sourceString source string
     * @param separator separator
     *
     * @returns substring, left-hand from separator, or null if separator was not found
     *
     * @throws IllegalArgumentException if sourceString is null
     */
    @Override
    public String left(String sourceString, String separator) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(sourceString, separator);
        String[] foundStrings = sourceString.split(separator);

        if (foundStrings.length > 0) {
            return foundStrings[0];
        }

        return null;
    }

    /**
     * gets right substring.
     *
     * @param sourceString source string
     * @param number amount of symbols to return
     *
     * @returns substring (number of letters)
     *
     * @throws IllegalArgumentException if sourceString is null or number is negative
     */
    @Override
    public String right(String sourceString, int number) throws IllegalArgumentException {

        ChecksHelper.checkForNull(sourceString);
        if (number < 0) {
            throw new IllegalArgumentException();
        }

        if (number <= sourceString.length()) {
            return sourceString.substring(sourceString.length() - number);
        }

        return sourceString;
    }

    /**
     * gets right substring.
     *
     * @param sourceString source string
     * @param separator separator
     *
     * @returns substring, right-hand from separator, or null if separator was not found
     *
     * @throws IllegalArgumentException if sourceString is null
     */
    @Override
    public String right(String sourceString, String separator) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(sourceString, separator);

        String[] foundStrings = sourceString.split(separator);
        if (foundStrings.length > 0)
            return foundStrings[ foundStrings.length - 1 ];

        return null;
    }

    /**
     * does the same as "String.split(...)".
     *
     * @param sourceString source string
     * @param split character to split for
     *
     * @return array of substrings
     *
     * @throws IllegalArgumentException if sourceString is null
     */
    @Override
    public String[] split(String sourceString, String split) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(sourceString, split);
        return sourceString.split(split);
    }

    /**
     * combines strings in one big string.
     *
     * @param sourceCollection collection of strings
     * @param glue glue character
     *
     * @return value is a string-composition of "sourceCollection" strings, jointed by "glue" value
     *
     * @throws IllegalArgumentException if sourceCollection is null
     */
    @Override
    public String join(String[] sourceCollection, String glue) throws IllegalArgumentException {

        ChecksHelper.checkForNullBothArguments(sourceCollection, glue);
        if (0 ==sourceCollection.length) {
            return "";
        }

        String value = sourceCollection[0];

        for (int i = 1; i < sourceCollection.length; i++) {
            value += (glue + sourceCollection[i]);
        }

        return value;
    }
}
