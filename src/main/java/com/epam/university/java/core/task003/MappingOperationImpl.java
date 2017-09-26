package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    /**
     * Convert source string in accordance with conditions.
     *
     * @param source source string
     * @return converted string
     * @throws IllegalArgumentException if source string not provided
     */
    @Override
    public String map(String source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        return new StringBuilder(source).reverse().toString();

    }
}
