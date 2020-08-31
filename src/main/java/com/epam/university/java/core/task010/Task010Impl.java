package com.epam.university.java.core.task010;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        String line = "";
        String[] lines;
        try (BufferedReader bufRdr  = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(source), StandardCharsets.UTF_8))) {
            line = bufRdr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines = line.trim().toLowerCase().split("\\s*[.]\\s+|\\s*[,]\\s+|\\s+");

        HashMap<String, Integer> resultMap = new HashMap<>();
        for (String str : lines) {
            if (resultMap.containsKey(str)) {
                int count = resultMap.get(str);
                count++;
                resultMap.put(str, count);
            } else {
                resultMap.put(str, 1);
            }
        }

        return resultMap;
    }
}
