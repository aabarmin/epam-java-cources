package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if(source == null)
            throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(source);
        return sb.reverse().toString();
    }
}
