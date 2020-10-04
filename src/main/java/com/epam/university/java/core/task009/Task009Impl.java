package com.epam.university.java.core.task009;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public Collection<String> countWords(File sourceFile) throws IOException {
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }
        Path p = Paths.get(sourceFile.toURI());
        String info = Files.readString(p);
        String[] parts = info.split("\\s");
        for (String part : parts) {
            part = part.replaceAll("[^0-9a-zA-Z]+", "");
            part = part.toLowerCase();
        }
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replaceAll("[^0-9a-zA-Z]+", "");
            parts[i] = parts[i].replaceAll("\\p{Punct}", "");
            parts[i] = parts[i].toLowerCase();
        }
        String[] unique = Arrays.stream(parts).distinct().toArray(String[]::new);
        List<String> list = new ArrayList<>(Arrays.asList(unique));
        list.removeAll(Arrays.asList("", null));
        Set<String> words = new HashSet<String>();
        for (String x : list) {
            words.add(x);
        }
        return words;
    }
}