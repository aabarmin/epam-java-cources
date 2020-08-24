package com.epam.university.java.core.task003;


public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        StringBuilder builder = new StringBuilder(source);
        return builder.reverse().toString();
    }
}
