package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source.isEmpty()) {
            return new ArrayList<>();
        }

        return Arrays.asList(source
                .replaceAll("(\\p{L})(\\p{Lu})", "$1,$2")
                .toLowerCase()
                .split(",")
        );
    }
}