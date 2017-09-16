package com.epam.university.java.core.task003;

import com.epam.university.java.core.ChecksHelper;

/**
 * implementation class for MappingOperation
 *
 * @author Sergei Titov
 */
public class MappingOperationImpl implements MappingOperation {

    /**
     * map param string to reversed string.
     *
     * @param source source string
     *
     * @returns reversed string
     *
     * @throws IllegalArgumentException if source is null
     */
    @Override
    public String map(String source) throws IllegalArgumentException {

        ChecksHelper.checkForNull(source);
        return new StringBuilder(source).reverse().toString();
    }
}
