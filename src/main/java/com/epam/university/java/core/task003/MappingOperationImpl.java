package com.epam.university.java.core.task003;

/**
 * Created by Вера on 06.09.2017.
 */
public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }

        char[] chars = source.toCharArray();
        char[] result = new char[chars.length];

        for (int i = 0; i < chars.length ; i++) {
            result[i] = chars[chars.length - i - 1];
        }

        return String.valueOf(result);
    }
}
