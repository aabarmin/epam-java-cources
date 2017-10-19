package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        StringBuffer buffer = new StringBuffer(source);
        String result = buffer.reverse().toString();
        return result;
    }
}
