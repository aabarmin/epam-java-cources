package com.epam.university.java.core.task002;

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

        if ((firstString == null) || (secondString == null)) {
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

        if ((sourceString == null) || (number < 0)) {
            throw new IllegalArgumentException();
        }

        number = sourceString.length() - number < 0 ? sourceString.length() : number;

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

        if ((sourceString == null) || (separator == null)) {
            throw new IllegalArgumentException();
        }

        int index = sourceString.indexOf(separator);
        index = index < 0 ? 0 : index;

        return sourceString.substring(0, index);

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

        if ((sourceString == null) || (number < 0)) {
            throw new IllegalArgumentException();
        }

        int index = sourceString.length() - number;
        index = index < 0 ? 0 : index;

        return sourceString.substring(index, sourceString.length());

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

        if ((sourceString == null) || (separator == null)) {
            throw new IllegalArgumentException();
        }

        int index = sourceString.indexOf(separator);
        index = index < 0 ? 0 : index + separator.length();

        return sourceString.substring(index, sourceString.length());

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

        if ((sourceString == null) || (split == null)) {
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

        if ((sourceCollection == null) || (glue == null)) {
            throw new IllegalArgumentException();
        }

        return String.join(glue, sourceCollection);

    }
}
