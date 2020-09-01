package com.epam.university.java.core.task024;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        if (source.length() == 0) {
            return Collections.EMPTY_LIST;
        }

        String regex = "(?<=\\p{Lower})(?=\\p{Upper})";
        Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CHARACTER_CLASS);

        String[] str = pattern.split(source);

        return Arrays.asList(str).stream().map(String::toLowerCase).collect(Collectors.toList());
    }
}
