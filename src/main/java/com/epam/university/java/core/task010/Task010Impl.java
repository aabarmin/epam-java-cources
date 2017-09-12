package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


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

        Map<String, Integer> wordsMap = new HashMap<>();

        try {

            try (Scanner sc = new Scanner(source)) {

                while (sc.hasNext()) {
                    String word = sc.next().toLowerCase().replaceAll("[^a-z0-9]", "");
                    if (wordsMap.containsKey(word)) {
                        wordsMap.put(word, wordsMap.get(word) + 1);
                    } else {
                        wordsMap.put(word, 1);
                    }
                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

        return wordsMap;


    }
}
