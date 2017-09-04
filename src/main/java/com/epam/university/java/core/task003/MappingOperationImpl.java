package com.epam.university.java.core.task003;

/**
 * MappingOperation implementation.
 */
public final class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(final String source) {
        StringBuilder result = new StringBuilder(source);
        result.reverse();
        return result.toString();
    }
}
