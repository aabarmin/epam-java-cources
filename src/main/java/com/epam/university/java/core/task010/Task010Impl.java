package com.epam.university.java.core.task010;

import com.epam.university.java.core.task009.CustomFileReader;


import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Task010Impl implements Task010 {
    private void addToMap(Map<String, Integer> map, String word) {
        if (map.containsKey(word)) {
            map.replace(word, map.get(word) + 1);
        } else {
            map.put(word, 1);
        }
    }


    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> wordsFreq = new HashMap<String, Integer>();
        try {
            CustomFileReader fileReader = new CustomFileReader();
            String fileText = fileReader.read(source);
            String[] words = fileText.split("( )|([!] )|([?] )|([.] )|([,] )");
            Arrays.stream(words).map(String::toLowerCase)
                    .forEach(word -> addToMap(wordsFreq, word));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return wordsFreq;
    }
}
