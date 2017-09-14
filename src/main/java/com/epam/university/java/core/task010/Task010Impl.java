package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> mapResult = new HashMap<>();

        // Try-catch block with resources
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            // Creating String array form file
            String[] stringArray = reader.readLine()
                    .toLowerCase()
                    .split("[^0-9a-zA-Z-']+");
            
            // Creating new entry or updating previous value
            for (String str : stringArray) {
                if (!mapResult.containsKey(str)) {
                    mapResult.put(str, 1);
                } else {
                    mapResult.put(str, mapResult.get(str) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapResult;
    }
}
