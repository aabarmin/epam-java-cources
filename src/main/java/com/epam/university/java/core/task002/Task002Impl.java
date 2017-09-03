package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        checkArguments(firstString, secondString);

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        checkArguments(sourceString, number);

        if (sourceString.length() <= number) {
            return sourceString;
        }

        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        checkArguments(sourceString, number);

        if (sourceString.length() <= number) {
            return sourceString;
        }

        return sourceString.substring(sourceString.length() - number, sourceString.length());
    }

    @Override
    public String left(String sourceString, String separator) {
        checkArguments(sourceString, separator);

        int stopIndex = sourceString.indexOf(separator);
        return sourceString.substring(0, stopIndex);
    }

    @Override
    public String right(String sourceString, String separator) {
        checkArguments(sourceString, separator);

        int startIndex = sourceString.lastIndexOf(separator) + separator.length();
        return sourceString.substring(startIndex, sourceString.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        checkArguments(sourceString, split);

        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        checkArguments(sourceCollection, glue);

        return String.join(glue, sourceCollection);
    }

    private void checkArguments(String firstArg, String secondArg) {
        if (firstArg == null || secondArg == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] firstArg, String secondArg) {
        if (firstArg == null || secondArg == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String firstArg, int secondArg) {
        if (firstArg == null || secondArg < 0) {
            throw new IllegalArgumentException();
        }
    }
}
