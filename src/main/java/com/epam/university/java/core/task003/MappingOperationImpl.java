package com.epam.university.java.core.task003;

import com.epam.university.java.core.validation.Validator;

/**
 * Created by Александр on 14.09.2017.
 *
 * <p>Class for string reverse
 */
public class MappingOperationImpl implements MappingOperation {
    private static final Validator VALIDATOR = Validator.newInstance(MappingOperationImpl.class);

    /**
     * Convert source string in accordance with conditions.
     *
     * @param source source string
     * @return converted string
     * @throws IllegalArgumentException if source string not provided
     */
    @Override
    public String map(String source) {
        VALIDATOR.assertNotNull(source);

        return new StringBuilder(source).reverse().toString();
    }
}
