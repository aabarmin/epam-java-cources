package com.epam.university.java.core.task002;

/**
 * Created by Daniil Smirnov on 04.09.2017.
 * All copy registered MF.
 */
public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        checkString(firstString);
        checkString(secondString);
        if (firstString.equals(secondString))
            return true;

        return false;
    }

    @Override
    public String left(String sourceString, int number) {
        if (number<0){
            throw new IllegalArgumentException();
        }
        checkString(sourceString);
        char[] c =sourceString.toCharArray();
        if (c.length<number)
            number=c.length;
        String newString = "";
        for (int i = 0; i < number; i++) {
            newString += String.valueOf(c[i]);
        }

        return newString;
    }

    @Override
    public String right(String sourceString, int number) {
        if (number<0){
            throw new IllegalArgumentException();
        }
        checkString(sourceString);
        char[] c =sourceString.toCharArray();
        if (c.length<number)
            number=c.length;
        String newString = "";

        for (int i = 0; i < number; i++) {
            newString += String.valueOf(c[c.length-number+i]);
        }
        return newString;
    }

    @Override
    public String left(String sourceString, String separator) {
        checkString(sourceString);
        checkString(separator);

        String[] arr = sourceString.split(separator);
        return arr[0];
    }

    @Override
    public String right(String sourceString, String separator) {
        checkString(sourceString);
        checkString(separator);

        String[] arr = sourceString.split(separator);
        return arr[arr.length-1];
    }

    @Override
    public String[] split(String sourceString, String split) {
        checkString(sourceString);
        checkString(split);
        String[] arr = sourceString.split(split);
        return arr;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        if (sourceCollection==null){
            throw new IllegalArgumentException();
        }
        checkString(glue);
        String res = "";
        for (int i = 0; i < sourceCollection.length; i++) {
            if (i!=sourceCollection.length-1)
                res+=sourceCollection[i]+glue;
            else
                res+=sourceCollection[i];
        }
        return res;
    }

    private void checkString(String s){
        if (s==null){
            throw new IllegalArgumentException();
        }
    }
}
