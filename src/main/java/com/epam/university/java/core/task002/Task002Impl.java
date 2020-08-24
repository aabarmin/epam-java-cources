package com.epam.university.java.core.task002;

import java.util.Arrays;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            return sourceString;
        }

        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] result = sourceString.split(separator);

        return result[0];
    }

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

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] result = new String[2];

        if (sourceString.contains(separator)) {
            result = sourceString.split(separator, 2);
        } else {
            result[1] = sourceString;
        }

        return result[1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }

        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null || sourceCollection.length == 0) {
            throw new IllegalArgumentException();
        }

        if (Arrays.asList(sourceCollection).contains(null)) {
            throw new IllegalArgumentException();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < sourceCollection.length; i++) {
            builder.append(sourceCollection[i]);

            if (i != sourceCollection.length - 1) {
                builder.append(glue);
            }
        }

        return builder.toString();
    }
}
