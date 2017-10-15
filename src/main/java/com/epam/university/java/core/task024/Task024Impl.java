package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
        Collection<String> result = new ArrayList<>();
        if (!source.isEmpty()) {
            result = Stream.of(source.split("(?=\\p{Lu})"))
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }
        return result;
    }
}