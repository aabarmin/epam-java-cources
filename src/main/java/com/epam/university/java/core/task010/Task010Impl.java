package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Romin Nuro on 21.08.2020 2:46.
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
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> wordsFrequencies = new HashMap<>();
        try {
            Scanner scanner = new Scanner(source);
            scanner.useDelimiter("[.,:?]?\\s+");
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                if (wordsFrequencies.containsKey(word)) {
                    wordsFrequencies.compute(word, (k, v) -> v += 1);
                } else {
                    wordsFrequencies.put(word, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return wordsFrequencies;
    }
}
