package com.epam.university.java.core.task009;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation class for Task009.
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
            Collection<String> words = Files.readAllLines(Paths.get(sourceFile.getAbsolutePath()))
                    .stream()
                    .map(l -> l.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toSet());

            Set<String> set = new HashSet<>();
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z0-9]", "");
                set.add( word.toLowerCase() );
            }
            return set;
        }
        catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
