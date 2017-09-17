package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> output = new HashMap<>();
        String currentWord;
        Integer value;
        try {
            Scanner in = new Scanner(source);
            while (in.hasNext()) {
                value = 0;
                currentWord = in.next().toLowerCase().replaceAll("[^a-z]", "");
                if (output.containsKey(currentWord)) {
                    value = output.get(currentWord);
                }
                output.put(currentWord, ++value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
}
