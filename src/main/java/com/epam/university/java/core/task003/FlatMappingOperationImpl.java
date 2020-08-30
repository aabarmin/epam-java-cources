package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        if (source == null) {
            return new String[0];
        }
        final String regEx = "\\s*,\\s*|\\s+";
        return source.trim().split(regEx);
    }
}
