package com.epam.university.java.core.task024;

import com.epam.university.java.core.Validator;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {
    private Validator validator = Validator.getInstance();

    @Override
    public Collection<String> getWordsCount(String source) {
        validator.validate(source);
        final String pattern = "(?=\\p{Lu})";
        return source.isEmpty()
                ? Collections.emptyList()
                : Arrays.stream(source.split(pattern))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
