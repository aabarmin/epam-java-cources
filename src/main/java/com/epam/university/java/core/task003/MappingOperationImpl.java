package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        String out = "";
        for (int i = source.length() - 1; i >= 0; i--) {
            out += source.charAt(i);
        }
        return out;
    }
}
