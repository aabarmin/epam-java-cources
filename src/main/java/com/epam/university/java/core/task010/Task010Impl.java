package com.epam.university.java.core.task010;

import com.epam.university.java.core.util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Implementation of the frequency calculator.
 */
public class Task010Impl implements Task010 {

    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     * @return map word to frequency of it
     * @throws IllegalArgumentException if source is null
     */
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Utils.assertNonNull(source);
        try {
            return Files.lines(Paths.get(source.toURI()))
                .parallel()
                .flatMap(line -> Stream.of(line.split(" ")))
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[^a-zA-Z ]", ""))
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.reducing(0, word -> 1, Integer::sum)
                ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
