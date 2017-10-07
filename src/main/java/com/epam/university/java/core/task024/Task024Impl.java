package com.epam.university.java.core.task024;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 27.09.17.
 */
public class Task024Impl implements Task024 {

    @Override
    public Collection<String> getWordsCount(String source) {

        StringBuilder sb = new StringBuilder();

        Stream.of(source.split(""))
            .flatMap(s -> {
                if (s.matches("\\p{javaUpperCase}")) {
                    return Stream.of(" ", s);
                } else {
                    return Stream.of(s);
                }
            }).forEach(s -> sb.append(s));

        List<String> result = Stream.of(sb.toString().split(" "))
            .map(s -> s.toLowerCase())
            .filter(s -> !"".equals(s))
            .collect(Collectors.toList());

        return result;
    }


}
