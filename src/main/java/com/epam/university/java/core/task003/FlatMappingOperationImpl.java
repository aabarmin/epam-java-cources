package com.epam.university.java.core.task003;

/**
 * Implementation of the string conversion operation.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {

    /**
     * Split the source string by the comma.
     *
     * @param source source string
     * @return array of converted strings or empty array if source not provided
     */
    @Override
    public String[] flatMap(String source) {
        return source == null ? new String[0] : source.replaceAll(" ", "").split(",");
    }

}
