package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 11.09.17.
 */
public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(source));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder();

        Map<String, Integer> result = new HashMap<>();

        try {
            while (reader.ready()) {
                sb.append(reader.readLine());
                Map<String, Integer> current =
                    Arrays.stream(sb.toString().split("[ ,?;:.!’]+"))
                    .map(word -> word.toLowerCase())
                    .collect(
                        HashMap<String, Integer>::new,
                        (m, k) -> m.put(k, m.containsKey(k) ? m.get(k) + 1 : 1),
                        HashMap::putAll);
                current.forEach((k, v) -> result.merge(k, v, (v1, v2) -> v1 + v2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
