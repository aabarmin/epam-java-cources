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
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            number = sourceString.length();
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] lines = sourceString.split(separator);
        return lines[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        if (number > sourceString.length()) {
            number = sourceString.length();
        }

        int length = sourceString.length();
        return sourceString.substring(length - number, length);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] lines = sourceString.split(separator);
        return lines[lines.length - 1];
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
        String str = "";
        for (int i = 0; i < sourceCollection.length; i++) {
            if (sourceCollection[i] == null){
                throw new IllegalArgumentException();
            }
            if (i != sourceCollection.length - 1) {
                str = str + sourceCollection[i] + glue;
            } else {
                str = str + sourceCollection[i];
            }
        }
        return str;
    }
}
