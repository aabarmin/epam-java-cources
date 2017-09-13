package com.epam.university.java.core.task002;

import com.epam.university.java.core.validation.Validator;

/**
 * Created by Александр on 06.09.2017.
 */
public class Task002Impl implements Task002 {
    private static Validator VALIDATOR = Validator.newInstance(Task002Impl.class);


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
        VALIDATOR.assertNotNull(firstString);
        VALIDATOR.assertNotNull(secondString);

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
        VALIDATOR.assertNotNull(sourceString);
        VALIDATOR.validNum(number, num -> num > 0);

        if (number > sourceString.length()) {
            return sourceString;
        } else {
            return sourceString.substring(0, number);
        }
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
        VALIDATOR.assertNotNull(sourceString);
        VALIDATOR.assertNotNull(separator);

        int endIndex = sourceString.indexOf(separator);
        return sourceString.substring(0, endIndex);
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
        VALIDATOR.assertNotNull(sourceString);
        VALIDATOR.assertNotNull(separator);

        int startIndex = sourceString.indexOf(separator);
        return sourceString.substring(startIndex + separator.length(), sourceString.length());
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
        VALIDATOR.assertNotNull(sourceString);
        VALIDATOR.validNum(number, num -> num > 0);

        if (number > sourceString.length()) {
            return sourceString;
        } else {
            return sourceString.substring(sourceString.length() - number, sourceString.length());
        }
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
        VALIDATOR.assertNotNull(sourceString);
        VALIDATOR.assertNotNull(split);

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
        VALIDATOR.assertNotNull(sourceCollection);
        VALIDATOR.assertNotNull(glue);

        return String.join(glue, sourceCollection);
    }
}
