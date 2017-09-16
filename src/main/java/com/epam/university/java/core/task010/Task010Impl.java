package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> resultMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
                String line = reader.readLine();
                String[] tempArr = line.toLowerCase().split("[\\s,.:?!;]+");
                for (String s : tempArr) {
                    Integer put = resultMap.put(s, 1);
                    if (put != null) {
                        resultMap.put(s, ++put);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultMap;
    }
}
