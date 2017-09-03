package com.epam.university.java.core.task003;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    /**
     * Convert source string to array of result strings.
     *
     * @param source source string
     * @return array of converted strings or empty array if source not provided
     */
    @Override
    public String[] flatMap(String source) {
        return source.split(",");
    }
}
