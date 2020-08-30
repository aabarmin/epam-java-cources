package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * author Dmitry Novikov 29-Aug-20.
 */
public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        Map<String, Integer> myMap = new HashMap<>();
        List<String> clearCollection = new ArrayList<>();
        try (Scanner myReader = new Scanner(source)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> collection = Arrays.asList(data.split(" "));
                for (String s : collection
                ) {
                    clearCollection.add(s.toLowerCase().replaceAll("[^A-Za-z]", ""));
                }
            }
            for (String s : clearCollection
            ) {
                if (myMap.containsKey(s)) {
                    int temp = myMap.get(s).intValue();
                    myMap.put(s, ++temp);
                } else {
                    myMap.put(s, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return myMap;
    }
}
