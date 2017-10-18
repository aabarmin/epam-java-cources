package com.epam.university.java.core.task003;


import java.util.Arrays;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {

        return source.split("\\s*,\\s*");
    }
}

