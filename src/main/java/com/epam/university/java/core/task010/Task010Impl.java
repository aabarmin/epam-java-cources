package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        String text = "";
        try {
            Scanner scanner = new Scanner(source);
            while (scanner.hasNext()) {
                text += scanner.nextLine();
            }
            ;
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found. Path: " + source);
        }

        text = text.replaceAll("[\\.,]", "");
        String[] words = text.split("\\s+");

        HashMap<String, Integer> mapOfWords = new HashMap<>();
        for (String word : words) {
            if (mapOfWords.containsKey(word)) {
                int count = mapOfWords.get(word);
                mapOfWords.put(word, ++count);
            } else {
                int count = 1;
                mapOfWords.put(word.toLowerCase(), count);
            }
        }
        return mapOfWords;
    }
}
