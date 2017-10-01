package com.epam.university.java.core.task024;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {
         String result = Stream.of(source.split(""))
                .flatMap(s -> {
                    if (s.matches("[А-ЯA-Z]")) {
                        return Stream.of(" ", s);
                    } else {
                        return Stream.of(s);
                    }
                }).collect(
                         StringBuilder::new,
                         StringBuilder::append,
                         StringBuilder::append
                 ).toString();
        return Stream.of(result.split(" "))
                .map(String::toLowerCase)
                .filter(s -> !s.equals(""))
                .collect(Collectors.toList());
    }
}