package com.epam.university.java.core.task003;

/**
 * Created by Mirabilis on 03.09.2017.
 */
public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        StringBuilder result = new StringBuilder(source);
        return result.reverse().toString();
    }
}
