package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        check(firstString, secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        check(sourceString, number);
        return sourceString.substring(0, Math.min(number, sourceString.length()));
    }

    @Override
    public String left(String sourceString, String separator) {
        check(sourceString, separator);
        return sourceString.substring(0, sourceString.indexOf(separator));
    }

    @Override
    public String right(String sourceString, int number) {
        check(sourceString, number);
        return sourceString.substring(number > sourceString.length() ? 0 : number + 1).trim();
    }

    @Override
    public String right(String sourceString, String separator) {
        check(sourceString, separator);
        return sourceString.substring(sourceString.indexOf(separator) + 1).trim();
    }

    @Override
    public String[] split(String sourceString, String split) {
        check(sourceString, split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        check(sourceCollection, glue);
        return String.join(glue, sourceCollection);
    }

    private void check(String[] stringArr, String str) {
        if (stringArr == null || str == null || str.length() == 0 || stringArr.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void check(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void check(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException();
        }
    }

    private void check(String str, int number) {
        if (str == null || str.length() == 0 || number < 0) {
            throw new IllegalArgumentException();
        }

    }
}
