package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if ((firstString == null || secondString == null)) {
            throw new IllegalArgumentException();
        } else if (firstString.equals("") || secondString.equals("")) {
            return true;
        } else {
            return firstString.equals(secondString);
        }
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        } else if (number < 0) {
            throw new IllegalArgumentException();
        } else {
            if (number > sourceString.length()) {
                return sourceString;
            } else {
                return sourceString.substring(0, number);
            }
        }
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        } else {
            return sourceString.split(separator)[0];
        }
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        } else if (number < 0) {
            throw new IllegalArgumentException();
        } else {
            if (number > sourceString.length()) {
                return sourceString;
            } else {
                return sourceString.substring(sourceString.length() - 5, sourceString.length());
            }
        }
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        } else {
            return sourceString.split(separator)[1];
        }
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        } else {
            return sourceString.split(split);
        }
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        } else {
            return sourceCollection[0] + glue + sourceCollection[1];
        }
    }
}
