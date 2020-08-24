package com.epam.university.java.core.task009;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;


public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> setStr = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            String str;
            while ((str = reader.readLine()) != null) {
                String[] line = str.replaceAll("[\\s+]", " ").split(" ");
                for (String s : line) {
                    setStr.add(s.replaceAll("[^A-Za-z0-9’]", "").toLowerCase());
                }
            }
            setStr.removeIf(s -> s.length() == 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return setStr;
    }
}
