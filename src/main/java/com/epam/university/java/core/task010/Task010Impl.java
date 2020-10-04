package com.epam.university.java.core.task010;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     * @return map word to frequency of it
     */
    @Override
    public Map<String, Integer> countWordNumbers(File source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Path p = Paths.get(source.toURI());
        String info = Files.readString(p);
        String[] parts = info.split("\\s");
        for (String part : parts) {
            part = part.replaceAll("[^0-9a-zA-Z]+", "");
            part = part.toLowerCase();
        }
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replaceAll("[^0-9a-zA-Z]+", "");
            parts[i] = parts[i].replaceAll("\\p{Punct}", "");
            parts[i] = parts[i].toLowerCase();
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String part : parts) {

            if (!map.containsKey(part)) {
                map.put(part, Integer.valueOf("1"));
            } else {
                map.put(part, map.get(part) + 1);
            }

        }
        System.out.println(map.toString());
        return map;
    }
}
