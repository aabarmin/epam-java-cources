package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    private StringBuilder stringBuilder;

    public MappingOperationImpl() {
        stringBuilder = new StringBuilder();
    }

    @Override
    public String map(String source) {
        stringBuilder.setLength(0);
        stringBuilder.append(source);
        return stringBuilder.reverse().toString();
    }
}
