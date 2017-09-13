package com.epam.university.java.core.task003;

/**
 * Created by Vadim on 09.09.2017.
 */
public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        int nElements = source.length;
        for (String element: source) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        if (nElements < 1){
            throw new IllegalArgumentException();
        }
        String[] invertArray = new String[nElements];

        for (int i = 0; i < nElements; i++) {
            invertArray[nElements - 1 - i] = source[i];
        }
        return invertArray;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        int lengthFirst = first.length;
        int lengthSecond = second.length;
        int lengthNew = lengthFirst + lengthSecond;

        for (String element: first) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        if ( lengthFirst < 1){
            throw new IllegalArgumentException();
        }
        for (String element: second) {
            if (element == null){
                throw new IllegalArgumentException();
            }
        }
        if ( lengthSecond < 1){
            throw new IllegalArgumentException();
        }

        String[] newArray = new String[lengthNew];

        System.arraycopy(first, 0, newArray, 0, lengthFirst - 1);
        System.arraycopy(second, 0, newArray, lengthFirst, lengthSecond - 1);
        return newArray;
    }

    @Override
    public int findMax(int[] source) {

        if (source.length < 1){
            throw new IllegalArgumentException();
        }
        int max = 0;
        for (int element: source){
            if (element >= max){
                max = element;
            }
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        return new String[0];
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        return new String[0];
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        return new String[0];
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        return new String[0];
    }
}
