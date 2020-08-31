package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> wordsFrequencyMap = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(source));

            while (reader.ready()) {
                String s = reader.readLine();
                s = s.replaceAll("[,.!?:;]", "");
                String[] strings = s.split(" ");

                for (String str : strings) {
                    str = str.toLowerCase();
                    if (wordsFrequencyMap.containsKey(str)) {
                        int count = wordsFrequencyMap.get(str);
                        count++;
                        wordsFrequencyMap.put(str, count);
                    } else {
                        wordsFrequencyMap.put(str, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordsFrequencyMap;
    }
}
