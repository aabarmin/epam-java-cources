package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    public static final String firstStringsMessageForIllegalArgumentException = "first string must have the value";
    public static final String secondStringsMessageForIllegalArgumentException = "second string must have the value";
    public static final String sourceStringsMessageForIllegalArgumentException = "source string must have the value";
    public static final String numbersMessageForIllegalArgumentException = "number should be positive";
    public static final String separatorsStringsMessageForIllegalArgumentException = "separator must have the value";
    public static final String sourceCollectionsMessageForIllegalArgumentException = "sources collection must have the value";
    public static final String gluesMessageForIllegalArgumentException = "glue string must have the value";

    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null) {
            throw new IllegalArgumentException(firstStringsMessageForIllegalArgumentException);
        }
        if (secondString == null) {
            throw new IllegalArgumentException(secondStringsMessageForIllegalArgumentException);
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == "") {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (sourceString == null) {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (number < 0) {
            throw new IllegalArgumentException(numbersMessageForIllegalArgumentException);
        }
        if (sourceString.length() < number) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == "") {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (sourceString == null) {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (number < 0) {
            throw new IllegalArgumentException(numbersMessageForIllegalArgumentException);
        }
        if (sourceString.length() < number) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number, sourceString.length());
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == "") {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (sourceString == null) {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (separator == "") {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        if (separator == null) {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        return sourceString.split(separator)[0];
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == "") {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (sourceString == null) {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (separator == "") {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        if (separator == null) {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        return sourceString.split(separator)[1];
    }

    @Override
    public String[] split(String sourceString, String split) {

        if (sourceString == "") {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (sourceString == null) {
            throw new IllegalArgumentException(sourceStringsMessageForIllegalArgumentException);
        }
        if (split == "") {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        if (split == null) {
            throw new IllegalArgumentException(separatorsStringsMessageForIllegalArgumentException);
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null) {
            throw new IllegalArgumentException(sourceCollectionsMessageForIllegalArgumentException);
        }
        if (glue == null) {
            throw new IllegalArgumentException(gluesMessageForIllegalArgumentException);
        }
        return String.join(glue, sourceCollection);
    }
}