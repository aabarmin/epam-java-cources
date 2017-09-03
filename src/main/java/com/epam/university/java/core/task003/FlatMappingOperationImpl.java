package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        return source.split(",");
    }
}
