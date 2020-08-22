package com.epam.university.java.core.task003;

import java.util.Set;
import java.util.TreeSet;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        return new StringBuffer(source).reverse().toString();
    }
}
