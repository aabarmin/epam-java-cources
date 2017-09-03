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
        if (number == 0) return null;
        if (number > sourceString.length()) number = sourceString.length();
        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number == 0) return null;
        if (number > sourceString.length()) number = sourceString.length();
        return sourceString.substring(sourceString.length() - number, sourceString.length());
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int endIndex = sourceString.indexOf(separator);

        return sourceString.substring(0, endIndex);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int beginIndex = sourceString.lastIndexOf(separator) + separator.length();

        return sourceString.substring(beginIndex, sourceString.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        String[] output = new String[2];
        output[0] = left(sourceString, split);
        output[1] = right(sourceString, split);
        return output;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        }
        String output = sourceCollection[0];
        if (sourceCollection.length > 1) {
            for (int i = 1; i < sourceCollection.length; i++) {
                output += glue + sourceCollection[i];
            }
        }
        return output;
    }
}
