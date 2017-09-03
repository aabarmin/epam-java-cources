package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ilya on 02.09.17.
 */
public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        List<String> resultList = Arrays.asList(source.split(","))
                .stream()
                .map(n -> n.trim())
                .collect(Collectors.toList());

        return resultList.toArray(new String[0]);
    }
}
