package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }
        return firstString.equals(secondString);
    }


    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        return number > sourceString.length() ? sourceString
                : sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.substring(sourceString.indexOf(separator) + separator.length());
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.substring(0, sourceString.indexOf(separator));
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        return number > sourceString.length() ? sourceString : sourceString.substring(0, number);
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        String begin = sourceString.substring(0, sourceString.indexOf(split));
        String end = sourceString.substring(sourceString.indexOf(split) + split.length());
        String[] str = {begin, end};
        return str;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        }
        String finalString = new String();
        for (int i = 0; i < sourceCollection.length; i++) {
            finalString += sourceCollection[i];
            if (i != sourceCollection.length - 1) {
                finalString += glue;
            }
        }
        return finalString;
    }
}
