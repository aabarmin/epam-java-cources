package com.epam.university.java.core.task002;

/**
 * Created by Vadim on 09.09.2017.
 */
public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        if (firstString == null || secondString == null){
            throw new IllegalArgumentException();
        }
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        if (sourceString == null || number < 0){
            throw new IllegalArgumentException();
        }
        int length = sourceString.length();
        if (length < number){
           return sourceString.substring(0, length);
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        if (sourceString == null || number < 0){
            throw new IllegalArgumentException();
        }
        int length = sourceString.length();
        if (length < number){
            return sourceString.substring(0, length);
        }
        return sourceString.substring(number + 2, length);
    }

    @Override
    public String left(String sourceString, String separator) {
        if (sourceString == null){
            throw new IllegalArgumentException();
        }
        int end = sourceString.indexOf(separator);
        return sourceString.substring(0, end);
    }

    @Override
    public String right(String sourceString, String separator) {
        if (sourceString == null){
            throw new IllegalArgumentException();
        }
        int begin = sourceString.lastIndexOf(separator);
        int length = sourceString.length();
        return sourceString.substring(begin + 2, length);
    }

    @Override
    public String[] split(String sourceString, String split) {
        if (sourceString == null){
            throw new IllegalArgumentException();
        }
        int begin = sourceString.indexOf(split);
        int length = sourceString.length();
        String[] arr = new String[2];
        arr[0] = sourceString.substring(0, begin);
        arr[1] = sourceString.substring(begin + 2, length);
        return arr;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null){
            throw new IllegalArgumentException();
        }
        StringBuilder result = new StringBuilder();
        int arrlength = sourceCollection.length;
        for (int i = 0; i < arrlength - 1; i++) {
            result.append(sourceCollection[i]).append(glue);
        }
        result.append(sourceCollection[arrlength - 1]);
        return result.toString();
    }
}
