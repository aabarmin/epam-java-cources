package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        String invertedString = "";
        for (int i = source.length() - 1; i >= 0; i--) {
            invertedString = invertedString + source.charAt(i);
        }
        return invertedString;
    }
}
