package com.epam.university.java.core.task010;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> map = new HashMap<>();
        FileReader fileReader = new FileReader(source);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("[,.]? ");
            for (String word : words) {
                if (!map.containsKey(word.toLowerCase())) {
                    map.put(word.toLowerCase(), 1);
                } else {
                    map.put(word.toLowerCase(), map.get(word.toLowerCase()) + 1);
                }
            }
        }

        return map;
    }
}
