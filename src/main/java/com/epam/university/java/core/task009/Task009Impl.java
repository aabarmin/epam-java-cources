package com.epam.university.java.core.task009;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
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
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }
        Set<String> setOfWords = new LinkedHashSet<>();
        try {
            Scanner scanner = new Scanner(sourceFile);
            String words = scanner.nextLine();
            String[] wordsArray = words.trim().replaceAll("[^a-zA-Z\\-\\s]", "")
                    .split("\\s+");
            for (int i = 0; i < wordsArray.length; i++) {
                String currentWord = wordsArray[i].toLowerCase();
                setOfWords.add(currentWord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setOfWords;
    }
}
