package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        final Map<String, Integer> mapOfWords = new HashMap<>();
        String word;
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(source)))) {
            reader.useDelimiter(" ");
            while (reader.hasNext()) {
                word = reader.next().toLowerCase().replaceAll("[^a-z]", "");
                Integer i = mapOfWords.get(word);
                if (i == null) {
                    i = 1;
                } else {
                    i += 1;
                }
                mapOfWords.put(word, i);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return mapOfWords;
    }


}
