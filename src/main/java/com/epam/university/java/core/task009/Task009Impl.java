package com.epam.university.java.core.task009;

import com.epam.university.java.core.util.FileHandler;
import com.epam.university.java.core.util.RegexHelper;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * Files and collections.
 */
public final class Task009Impl implements Task009 {
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
    public Collection<String> countWords(final File sourceFile) {
        String text = FileHandler.readTextFromFile(sourceFile);
        String[] wordsArray = text.split(RegexHelper.REGEX_NON_WORDS);

        Set<String> uniqueWordsSet = new LinkedHashSet<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                uniqueWordsSet.add(word);
            }
        }
        return uniqueWordsSet;
    }
}
