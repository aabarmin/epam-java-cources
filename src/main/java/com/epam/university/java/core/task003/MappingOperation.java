package com.epam.university.java.core.task003;

/**
 * String array conversion operation.
 */
public interface MappingOperation {
    /**
     * Convert source string in accordance with conditions.
     *
     * @param source source string
     * @return converted string
     * @throws IllegalArgumentException if source string not provided
     */
    String map(String source);
}
