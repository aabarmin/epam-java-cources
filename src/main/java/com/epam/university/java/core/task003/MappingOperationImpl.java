package com.epam.university.java.core.task003;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        char[] result = source.toCharArray();
        ArrayUtils.reverse(result);
        return String.valueOf(result);
    }
}
