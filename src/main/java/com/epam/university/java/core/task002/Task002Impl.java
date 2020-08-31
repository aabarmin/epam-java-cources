package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString != null && secondString != null) {
            return firstString.hashCode() == secondString.hashCode();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString != null && number >= 0) {
            if (sourceString.toCharArray().length < number) {
                return sourceString;
            } else {
                return sourceString.substring(0, number);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString != null && separator != null) {
            int index = sourceString.indexOf(separator);
            return sourceString.substring(0, index);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString != null && number >= 0) {
            if (sourceString.toCharArray().length < number) {
                return sourceString;
            } else {
                int start = sourceString.length() - number;
                return sourceString.substring(start, start + number);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString != null && separator != null) {
            int end = sourceString.length();
            int index = sourceString.indexOf(separator.trim()) + 1;
            return sourceString.substring(index, end).trim();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString != null && split != null) {
            return sourceString.split(split);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection != null && glue != null && sourceCollection.length > 0) {
            if (sourceCollection[0] != null) {
                return String.join(glue, sourceCollection);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
