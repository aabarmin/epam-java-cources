package com.epam.university.java.core.task009;

import com.epam.university.java.core.util.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Implementation of the files and collections task.
 */
public class Task009Impl implements Task009 {

    /**
     * Source file contains words separated by spaces.
     * <p>
     *     You need to output all different words.
     *     Same word in upper and lower case should be counted as equal.
     * </p>
     * <p>
     *     Tip: you can use Set for it.
     * </p>
     *
     * @param sourceFile source file
     * @return collection of different words
     * @throws IllegalArgumentException if source file is null
     */
    @Override
    public Collection<String> countWords(File sourceFile) throws IllegalArgumentException {
        Utils.assertNonNull(sourceFile);
        try {
            String[] words = new String(
                Files.readAllBytes(Paths.get(sourceFile.toURI()))
            ).replaceAll("[^a-zA-Z ]", "").split(" ");
            return Arrays.stream(words)
                .parallel()
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
