package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (source.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<String> strList = new ArrayList<>(Arrays
                .asList(source
                        .split("(?<=.)(?=\\p{Lu})")
                ));
        return strList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
