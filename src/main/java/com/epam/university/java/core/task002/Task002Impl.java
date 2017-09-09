package com.epam.university.java.core.task002;

public class Task002Impl implements  Task002{

    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null){
            throw new IllegalArgumentException();
        }

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number > sourceString.length()){
            number = sourceString.length();
        }

        return sourceString.substring(0,number);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
        if (number >= sourceString.length()){
            number = sourceString.length();
        }
        int leftIndex = sourceString.length()-number;
        int rightIndex = sourceString.length();


        return sourceString.substring(leftIndex,rightIndex);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }

        return sourceString.substring(0,sourceString.indexOf(separator));
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        int leftIndex = sourceString.lastIndexOf(separator) + separator.length();

        return sourceString.substring(leftIndex,sourceString.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null || split == null) {
            throw  new IllegalArgumentException();
        }
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null|| sourceCollection.length == 0 || glue == null) {
            throw  new IllegalArgumentException();
        }
        return String.join(glue,sourceCollection);

    }
}
