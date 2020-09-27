package com.epam.university.java.core.task003;

/**
 * Some docs.
 */
public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        } else {
            StringBuilder stringBuilder = new StringBuilder(source);
            stringBuilder.reverse();
            return stringBuilder.toString();
        }
    }
}
