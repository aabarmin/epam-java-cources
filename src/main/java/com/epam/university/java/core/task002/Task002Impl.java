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
        } else if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) throws IllegalArgumentException {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        String[] splittedString = sourceString.split(separator);
        return splittedString[0];
    }

    @Override
    public String right(String sourceString, int number) throws IllegalArgumentException {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        } else if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) throws IllegalArgumentException {
        if (sourceString == null || separator == null) {
            throw new IllegalArgumentException();
        }
        String[] splittedString = sourceString.split(separator);
        return splittedString[splittedString.length - 1];
    }

    @Override
    public String[] split(String sourceString, String split) throws IllegalArgumentException {
        if (sourceString == null || split == null) {
            throw new IllegalArgumentException();
        }
        String[] splittedString = sourceString.split(split);
        return splittedString;
    }

    @Override
    public String join(String[] sourceCollection, String glue) throws IllegalArgumentException {
        if (sourceCollection == null || sourceCollection.length == 0 || glue == null) {
            throw new IllegalArgumentException();
        }
        for (String sources :
                sourceCollection) {
            if (sources == null) {
                throw new IllegalArgumentException();
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sourceCollection.length - 1; i++) {
            String s = sourceCollection[i];
            sb.append(s).append(glue);
        }
        String gluedString = sb.toString() + sourceCollection[sourceCollection.length - 1];
        return gluedString;
    }
}
