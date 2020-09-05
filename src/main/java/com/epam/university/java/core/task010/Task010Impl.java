package com.epam.university.java.core.task010;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> mapOfWords = new HashMap<>();
        int countOfWord = 0;
        String matchingWord;
        try {
            Scanner scanner = new Scanner(source);
            String words = scanner.nextLine();
            String[] wordsArray = words.toLowerCase()
                    .trim()
                    .replaceAll("[^a-zA-Z\\-\\s]", "")
                    .split("\\s+");

            for (int i = 0; i < wordsArray.length; i++) {
                matchingWord = wordsArray[i];
                for (int j = 0; j < wordsArray.length; j++) {
                    if (matchingWord.equals(wordsArray[j])) {
                        countOfWord++;
                    }
                }
                mapOfWords.put(matchingWord, countOfWord);
                countOfWord = 0;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapOfWords;
    }
}
