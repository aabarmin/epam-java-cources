package com.epam.university.java.core.task010;

import com.epam.university.java.core.util.FileHandler;
import com.epam.university.java.core.util.RegexHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Frequency calculator.
 */
public class Task010Impl implements Task010 {
    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     * @return map word to frequency of it
     */
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
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
