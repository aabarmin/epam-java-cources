package com.epam.university.java.core.task002;

/**
 * Created by A.Sluzhbin on 21.08.2020
 */

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if ((sourceString == null || number < 0)) {
            throw new IllegalArgumentException("Arguments not valid.");
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        String[] parts = sourceString.split(separator);
        return parts[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException("Arguments not valid.");
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        if (!sourceString.contains(separator)) {
            return sourceString;
        }
        String[] parts = sourceString.split(separator);
        return parts[1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null | split == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null || sourceCollection.length == 0
                || sourceCollection[0] == null) {
            throw new IllegalArgumentException("Arguments not found.");
        }
        return String.join(glue, sourceCollection);
    }
}
