package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        StringBuilder input = new StringBuilder();
        input.append(source);
        input.reverse();
        return input.toString();
    }
}
