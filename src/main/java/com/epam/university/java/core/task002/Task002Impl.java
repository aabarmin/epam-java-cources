package com.epam.university.java.core.task002;


import com.epam.university.java.core.task001.Task001Impl;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        Task001Impl.nullChecker(firstString, secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        } else if (number > sourceString.length()) {
            return sourceString;
        } else if (number < 0) {
            return sourceString;
        }

        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        } else if (number < 0) {
            return sourceString;
        } else if (number > sourceString.length()) {
            return sourceString;
        }


        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String left(String sourceString, String separator) {
        Task001Impl.nullChecker(sourceString, separator);
        int sepIndex = sourceString.indexOf(separator);

        return sourceString.substring(0, sepIndex);
    }

    @Override
    public String right(String sourceString, String separator) {
        Task001Impl.nullChecker(sourceString, separator);
        int sepIndex = sourceString.indexOf(separator) + separator.length();

        return sourceString.substring(sepIndex);
    }

    @Override
    public String[] split(String sourceString, String split) {
        Task001Impl.nullChecker(sourceString, split);

        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (glue == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        for (String element : sourceCollection) {
            if (element == null)
                throw new IllegalArgumentException();
            sb.append(element).append(glue);
        }
        String result = sb.toString();
        return result.substring(0, result.lastIndexOf(glue));
    }


}
