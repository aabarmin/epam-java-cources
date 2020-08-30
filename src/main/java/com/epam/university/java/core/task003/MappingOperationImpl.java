package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        char[] chars = source.toCharArray();
        char[] invertedChars = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            invertedChars[i] = chars[chars.length - i - 1];
        }
        String invertedString = invertedChars.toString();
        return invertedString;
    }
}
