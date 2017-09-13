package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {

    private void checkForNull(Object... objects) {
        if (objects == null) {
            throw new IllegalArgumentException();
        }
        for (Object obj : objects) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public boolean isEquals(String firstString, String secondString) {
        checkForNull(firstString, secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        checkForNull(sourceString);
        if (isBordersCorrect(sourceString, number)) {
            return sourceString.substring(0, number);
        }
        return sourceString;
    }

    @Override
    public String left(String sourceString, String separator) {
        checkForNull(sourceString, separator);
        int pos = sourceString.indexOf(separator);
        return sourceString.substring(0, pos);
    }

    private boolean isBordersCorrect(String sourceString, int number) {
        int length = sourceString.length();
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return length > number;
    }

    @Override
    public String right(String sourceString, int number) {
        checkForNull(sourceString);
        if (isBordersCorrect(sourceString, number)) {
            return sourceString.substring(sourceString.length() - number);
        }
        return sourceString;
    }

    @Override
    public String right(String sourceString, String separator) {
        checkForNull(sourceString, separator);
        int pos = sourceString.lastIndexOf(separator);
        return sourceString.substring(pos + separator.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        checkForNull(sourceString, split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        checkForNull(sourceCollection, glue);
        StringBuilder sb = new StringBuilder();
        for (String s : sourceCollection) {
            sb.append(s);
            sb.append(glue);
        }
        sb.delete(sb.length() - glue.length(), sb.length());
        return sb.toString();
    }
}
