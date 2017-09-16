package com.epam.university.java.core.task002;

/**
 * Created by Вера on 06.09.2017.
 */
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

        String s = "";
        char[] chars = sourceString.toCharArray();

        if (number > chars.length) {
            return sourceString;
        } else {
            for (int i = 0; i < number; i++) {
                s = s + chars[i];
            }
            return s;
        }
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] str = sourceString.split(separator);
        return str[0];
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }

        String s = "";
        char[] chars = sourceString.toCharArray();

        if (number > chars.length) {
            return sourceString;
        } else {
            for (int i = number; i > 0; i--) {
                s = s + chars[chars.length - i];
            }
            return s;
        }
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }

        String[] str = sourceString.split(separator);
        return str[1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }

        String[] args = sourceString.split(split);
        return args;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        }

        String s = "";
        for (int i = 0; i < sourceCollection.length - 1; i++) {
            s = s + sourceCollection[i] + glue;
        }
        s = s + sourceCollection[sourceCollection.length - 1];
        return s;
    }
}
