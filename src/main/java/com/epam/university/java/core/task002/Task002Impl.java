package com.epam.university.java.core.task002;

/**
 * Created by Mirabilis on 03.09.2017.
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
        String outString;
        if (number > sourceString.length()) {
            return sourceString;
        }
        outString = sourceString.substring(0,number);
        return outString;
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int index = sourceString.indexOf(separator);
        String outString = sourceString.substring(0,index);
        return outString;
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()) {
            return sourceString;
        }
        String outString = sourceString.substring(number + 2);
        return outString;
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        int index = sourceString.indexOf(separator);
        String outString = sourceString.substring(index + separator.length());
        return outString;
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null || glue == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < sourceCollection.length - 1; i++) {
            buffer.append(sourceCollection[i]);
            buffer.append(glue);
        }
        buffer.append(sourceCollection[sourceCollection.length - 1]);
        return buffer.toString();
    }
}
