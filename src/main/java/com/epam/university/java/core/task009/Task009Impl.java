package com.epam.university.java.core.task009;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Implementation class for Task009.
 *
 * @author Sergei Titov
 */
public class Task009Impl implements Task009 {
    /**
     * Source file contains words which separated with spaces.
     * <p>
     * You need to output all different words.
     * Same word in upper and lower case should be counted as equal.
     * </p>
     * <p>
     * Tip: you can use Set for it.
     * </p>
     *
     * @param sourceFile source file
     * @return collection of different words
     */
    @Override
    public Collection<String> countWords(File sourceFile) {

        try {
            return Files.readAllLines(Paths.get(sourceFile.getAbsolutePath()))
                    .stream()
                    .map(l -> l.split(" "))
                    .flatMap(Arrays::stream)
                    .map(l -> l.toLowerCase().replaceAll("[^\\w]", ""))
                    .collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
