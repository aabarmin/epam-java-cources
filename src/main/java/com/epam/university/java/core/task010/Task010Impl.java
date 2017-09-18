package com.epam.university.java.core.task010;

import com.epam.university.java.core.util.FileHandler;
import com.epam.university.java.core.util.RegexHelper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Frequency calculator.
 */
public final class Task010Impl implements Task010 {
    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     * @return map word to frequency of it
     */
    @Override
    public Map<String, Integer> countWordNumbers(final File source) {
        String text = FileHandler.readTextFromFile(source);
        String[] wordsArray = text.split(RegexHelper.REGEX_NON_WORDS);

        Map<String, Integer> resultMap = new HashMap<>();
        for (String word : wordsArray) {
            if (!word.isEmpty()) {
                word = word.toLowerCase();
                if (resultMap.containsKey(word)) {
                    resultMap.put(word, resultMap.get(word) + 1);
                } else {
                    resultMap.put(word, 1);
                }
            }
        }
        return resultMap;
    }
}
