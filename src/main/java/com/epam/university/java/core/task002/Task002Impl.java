package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString)
            throws IllegalArgumentException {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) throws IllegalArgumentException {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        String result = sourceString.substring(0, min(number, sourceString.length()));
        return result;
    }

    @Override
    public String left(String sourceString, String separator) throws IllegalArgumentException {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        String result = sourceString.split(separator)[0];
        return result;
    }

    @Override
    public String right(String sourceString, int number) throws IllegalArgumentException {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        String result;
        if (sourceString.length() < number) {
            result = sourceString.substring(0);
        } else {
            result = sourceString.substring(sourceString.length() - number);
        }
        return result;
    }

    @Override
    public String right(String sourceString, String separator) throws IllegalArgumentException {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        String[] results = sourceString.split(separator);

        return results[results.length - 1];
    }

    @Override
    public String[] split(String sourceString, String split) throws IllegalArgumentException {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        String[] result = sourceString.split(split);
        return result;
    }

    @Override
    public String join(String[] sourceCollection, String glue) throws IllegalArgumentException {
        if (sourceCollection == null || sourceCollection.length == 0 || glue == null) {
            throw new IllegalArgumentException();
        }
        for (String string : sourceCollection) {
            if (string == null) {
                throw new IllegalArgumentException();
            }
        }
        String result = String.join(glue, sourceCollection);
        return result;
    }

    private int min(int firstNumber, int secondNumber) {
        int min = 0;
        if (firstNumber > secondNumber) {
            min = secondNumber;
        } else {
            min = firstNumber;
        }
        return min;
    }
}
