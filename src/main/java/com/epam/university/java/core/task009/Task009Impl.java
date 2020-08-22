package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;


public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> setStr = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] line = str.replaceAll("[.!?,]","").split(" ");
                for (String s : line) {
                    setStr.add(s.toLowerCase());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setStr;
    }
}
