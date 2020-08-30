package com.epam.university.java.core.task003;

import java.util.Arrays;

/**
 * Some docs.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String[] result = source.replace(" ", "").split(",");
        return result;
    }
}
