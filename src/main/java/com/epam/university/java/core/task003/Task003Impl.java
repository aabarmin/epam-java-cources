package com.epam.university.java.core.task003;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0, j = source.length - 1; i < source.length / 2 && j > (source.length - 1) / 2; i++, j--) {
            String str = source[i];
            source[i] = source[j];
            source[j] = str;
        }


        /*String[] arr = new String[source.length];
        for (int i = source.length - 1, j = 0; i >= 0 && j < arr.length; i--, j++) {
            arr[j] = source[i];
        }*/
        return source;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        return new String[0];
    }

    @Override
    public int findMax(int[] source) {
        return 0;
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
