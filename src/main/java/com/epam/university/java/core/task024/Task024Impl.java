package com.epam.university.java.core.task024;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException("String wasn't provided!");
        }
        return source.isEmpty() ? Collections.emptyList()
                : Arrays.stream(source.split("(?=[A-Z])"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}