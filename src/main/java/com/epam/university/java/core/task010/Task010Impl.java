package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Scanner input = null;
        try {
            input = new Scanner(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> result = new HashMap<>();

        String temp;
        int count = 0;
        while (input.hasNext()) {
            temp = input.next();
            String[] allWords = temp.toLowerCase().split("[,.:!?]");
            for (String word: allWords) {
                Integer frequency = result.get(word);
                result.put(word, frequency == null ? 1 : frequency + 1);
            }
        }
        return result;
    }
}
