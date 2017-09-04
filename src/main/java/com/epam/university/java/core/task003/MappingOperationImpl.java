package com.epam.university.java.core.task003;

/**
 * Created by nb on 04.09.2017.
 */
public final class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(final String source) {
        StringBuilder result = new StringBuilder(source);
        result.reverse();
        return result.toString();
    }
}
