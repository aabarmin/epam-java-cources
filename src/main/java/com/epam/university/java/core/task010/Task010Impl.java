package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] line = str.replaceAll("[.,!?:]", "").split(" ");
                for (String s : line) {
                    String key = s.toLowerCase();
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
        return map;
    }
}
