package com.epam.university.java.core.task003;

/**
 * String conversion operation.
 */
public interface FlatMappingOperation {
    /**
     * Convert source string to array of result strings.
     *
     * @param source source string
     * @return array of converted strings or empty array if source not provided
     */
    String[] flatMap(String source);
}
