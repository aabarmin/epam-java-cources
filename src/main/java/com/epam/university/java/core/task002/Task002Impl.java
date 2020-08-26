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
            return sourceString;
        }
        return sourceString.substring(0,number);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int leftIndex = sourceString.indexOf(separator);
        return sourceString.substring(0,leftIndex);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        int countCharactersFromRight = sourceString.length() - number;
        return sourceString.substring(countCharactersFromRight);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int rightIndex = sourceString.indexOf(separator) + separator.length();
        return sourceString.substring(rightIndex);
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
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < sourceCollection.length) {
            if (sourceCollection[i] == null) {
                throw new IllegalArgumentException();
            }
            stringBuilder.append(sourceCollection[i]);
            i++;
            if (i != sourceCollection.length) {
                stringBuilder.append(glue);
            }
        }
        return stringBuilder.toString();
    }
}
