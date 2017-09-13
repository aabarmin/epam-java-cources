package com.epam.university.java.core.task003;

import com.epam.university.java.core.util.Utils;

/**
 * Implementation of the string array conversion operation.
 */
public class MappingOperationImpl implements MappingOperation {

    /**
     * Reverse source string.
     *
     * @param source source string
     * @return converted string
     * @throws IllegalArgumentException if source string not provided
     */
    @Override
    public String map(String source) throws IllegalArgumentException {
        Utils.assertNonNull(source);
        return new StringBuilder(source)
            .reverse()
            .toString();
    }

}
