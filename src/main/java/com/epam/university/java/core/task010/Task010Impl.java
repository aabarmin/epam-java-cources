package com.epam.university.java.core.task010;

import com.epam.university.java.core.utils.common.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Class implements Task010
 */
public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Validator.validateNotNull(source, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Map<String, Long> wordsMap;
        try {
            return Files.lines(Paths.get(source.toURI())).parallel()
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(String::toLowerCase)
                    .map(element -> element.replaceAll("[^\\P{P}-]+",
                            ""))
                    .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.reducing(0, e -> 1,
                                    Integer::sum)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}