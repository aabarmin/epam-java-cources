package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {

        if (source == null) {
            throw new IllegalArgumentException();
        }

        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(source))) {
            String word;
            while ((word = buffer.readLine()) != null) {
                String[] arr = word.replaceAll("[.,!?:]", "").split(" ");
                for (String s : arr) {
                    String key = s.toLowerCase();
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
