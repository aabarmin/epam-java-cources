package com.epam.university.java.core.task003;

/**
 * Created by Александр on 14.09.2017.
 * Class for cpliting a string
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    /**
     * Convert source string to array of result strings.
     *
     * @param source source string
     * @return array of converted strings or empty array if source not provided
     */
    @Override
    public String[] flatMap(String source) {
        return source.split("[, ]+");
    }
}
