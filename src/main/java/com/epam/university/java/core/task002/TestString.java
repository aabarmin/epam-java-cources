package com.epam.university.java.core.task002;

/**
 * Created by Vadim on 09.09.2017.
 */
public class TestString {
    public static String left(String sourceString, int number) {
        if (sourceString == null || number < 0){
            throw new IllegalArgumentException();
        }
        int length = sourceString.length();
        if (number > length){
            throw new StringIndexOutOfBoundsException();
        }
        return sourceString.substring(0, number);
    }
    public static String join(String[] sourceCollection, String glue) {
        if (sourceCollection == null){
            throw new IllegalArgumentException();
        }
        String result = "";
        int arrlength = sourceCollection.length;
        for (int i = 0; i < arrlength - 1; i++) {
                result = result + sourceCollection[i] + glue;
        }
        result = result + sourceCollection[arrlength - 1];
        return result;
    }

    public static void main(String[] args) {
        System.out.println(left("string", 3));
        String[] source = {"a","b","c"};
        System.out.println(join(source, "+"));
    }
}
