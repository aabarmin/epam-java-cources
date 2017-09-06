package com.epam.university.java.core.task003;

import static com.epam.university.java.core.task003.Task003Impl.errorMessageForSourceIfNull;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if (source == null) {
            throw new IllegalArgumentException(errorMessageForSourceIfNull);
        }
        return new StringBuilder(source).reverse().toString();
    }
}