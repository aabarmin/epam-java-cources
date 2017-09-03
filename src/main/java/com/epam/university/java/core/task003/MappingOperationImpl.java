package com.epam.university.java.core.task003;

/**
 * Created by Dremina on 03.09.2017.
 */
public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        return new StringBuilder(source).reverse().toString();
    }
}
