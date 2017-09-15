package com.epam.university.java.core.task003;

import com.epam.university.java.core.ChecksHelper;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) throws IllegalArgumentException {

        ChecksHelper.checkForNull( source );
        return new StringBuilder(source).reverse().toString();
    }
}
