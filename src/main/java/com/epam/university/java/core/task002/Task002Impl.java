package com.epam.university.java.core.task002;

import com.epam.university.java.core.Validator;

public class Task002Impl implements Task002 {
    private Validator validator = Validator.getInstance();

    @Override
    public boolean isEquals(String firstString, String secondString) {
        validator.validate(firstString, secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        validator.validate(sourceString);
        if (isBordersCorrect(sourceString, number)) {
            return sourceString.substring(0, number);
        }
        return sourceString;
    }

    @Override
    public String left(String sourceString, String separator) {
        validator.validate(sourceString, separator);
        final int pos = sourceString.indexOf(separator);
        return sourceString.substring(0, pos);
    }

    private boolean isBordersCorrect(String sourceString, int number) {
        final int length = sourceString.length();
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return length > number;
    }

    @Override
    public String right(String sourceString, int number) {
        validator.validate(sourceString);
        if (isBordersCorrect(sourceString, number)) {
            return sourceString.substring(sourceString.length() - number);
        }
        return sourceString;
    }

    @Override
    public String right(String sourceString, String separator) {
        validator.validate(sourceString, separator);
        final int pos = sourceString.lastIndexOf(separator);
        return sourceString.substring(pos + separator.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        validator.validate(sourceString, split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        validator.validate(sourceCollection, glue);
        StringBuilder sb = new StringBuilder();
        for (String s : sourceCollection) {
            sb.append(s);
            sb.append(glue);
        }
        sb.delete(sb.length() - glue.length(), sb.length());
        return sb.toString();
    }
}
