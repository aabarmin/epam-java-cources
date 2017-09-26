package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task009Impl implements Task009 {
    /**
     * Source file contains words which separated with spaces.
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
     */
    @Override
    public Collection<String> countWords(File sourceFile) {

        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }

        Set<String> wordsSet = new HashSet<>();

        try {

            try (Scanner sc = new Scanner(sourceFile)) {

                while (sc.hasNext()) {
                    String word = sc.next();
                    wordsSet.add(word.toLowerCase().replaceAll("[^a-z0-9]", ""));
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        return wordsSet;

    }

}
