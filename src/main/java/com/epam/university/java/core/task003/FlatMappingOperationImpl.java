package com.epam.university.java.core.task003;


public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String[] array = source.split(",");
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].trim();
        }
        return array;
    }
}
