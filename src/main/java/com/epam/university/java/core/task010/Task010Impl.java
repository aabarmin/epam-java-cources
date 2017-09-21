package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        String[] stringsArr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(source)))) {
            stringsArr = br.readLine().toLowerCase().split("[^a-zA-Z0-9_’-]+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, Integer> map = new HashMap<>();
        for (String string : stringsArr) {
            Integer frequency = map.get(string);
            map.put(string, frequency == null ? 1 : frequency + 1);
        }
        return map;
    }
}
