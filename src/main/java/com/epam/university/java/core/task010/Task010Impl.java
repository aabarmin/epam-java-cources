package com.epam.university.java.core.task010;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implementation class for Task010.
 *
 * @author Sergei Titov
 */
public class Task010Impl implements Task010 {
    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     *
     * @returns the map of word to it's frequency
     */
    @Override
    public Map<String, Integer> countWordNumbers(File source) {

        try {
            return Files.readAllLines(Paths.get(source.getAbsolutePath()))
                    .stream()
                    .map(l -> l.split(" "))
                    .flatMap(Arrays::stream)
                    .map(l -> l.toLowerCase().replaceAll("[^\\w]", ""))
                    .collect(Collectors.toMap(entry -> entry, entry -> 1, (v1, v2) -> (v1 + 1)));

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}