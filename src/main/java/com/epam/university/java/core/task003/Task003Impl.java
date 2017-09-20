package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Vadim on 15.09.2017.
 */
public class Task003Impl implements Task003 {

    boolean isArrayEmpty(String[] array) {
        return array.length == 0;
    }
    @Override
    public String[] invert(String[] source) {
        int nElements = source.length;
        String[] invertArray = new String[nElements];
        if (!isArrayEmpty(source)){
            for (int i = 0; i < nElements; i++) {
                invertArray[nElements - 1 - i] = source[i];
            }
        }
        return invertArray;
    }

    @Override
    public  String[] join(String[] first, String[] second) {

        int lengthFirst = first.length;
        int lengthSecond = second.length;
        int lengthNew = lengthFirst + lengthSecond;

        String[] newArray = new String[lengthNew];
        if (!isArrayEmpty(first) || !isArrayEmpty(second)) {
            System.arraycopy(first, 0, newArray, 0, lengthFirst);
            System.arraycopy(second, 0, newArray, lengthFirst, lengthSecond);
            }
        return newArray;
    }

    @Override
    public int findMax(int[] source) {

        if (source.length < 1){
            throw new IllegalArgumentException();
        }
        int max = source[0];
        for (int i = 1; i < source.length; i++){
            if (source[i] >= max){
                max = source[i];
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {

        for (String element: source) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        int length = 0;
        for (String element : source){
            if (condition.isValid(element)){
                length++;
            }
        }
        String[] list = new String[length];
        int index = 0;
        for (String element : source){
            if (condition.isValid(element)){
                list[index] = element;
                index++;
            }
        }
        return list;
    }
    public static boolean isElementsEquals(String one, String two){
        return one.equals(two);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        for (String element: source) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        for (String element: toRemote) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        int listlength = source.length - toRemote.length;
        String[] list = new String[listlength];
        int index = 0;
        for (int i = 0; i < source.length; i++){
            boolean check = false;
            for (int j = 0; j < toRemote.length; j++){
                if (isElementsEquals(source[i], toRemote[j])){
                    check = true;
                }
            }
            if (!check) {
                list[index] = source[i];
                index++;
            }
        }

        return list;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        for (String element: source) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
       for (int i = 0; i < source.length; i++){
            source[i] = operation.map(source[i]);
       }
        return source;
    }
    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        String[] array = new String[0];
        for (String aSource : source) {
            array = join(array, operation.flatMap(aSource));
        }
        String[] newArray = new String[10];
        int index = 1;
        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        array = invert(array);
        String current = array[0];
        newArray[0] = array[0];
        for (int i = 1; i < array.length; i++){
             if (!current.equals(array[i])){
                 newArray[index++] = array[i];
                 current = array[i];
             }
        }
        return newArray;

    }
}
