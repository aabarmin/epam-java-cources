package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) {

        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }

        Set<String> set = new LinkedHashSet<String>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(sourceFile))) {
            String word;
            while ((word = buffer.readLine()) != null) {
                String[] arr = word.replaceAll("[\\s+]", " ").split(" ");
                for (String s : arr) {
                    set.add(s.replaceAll("[^A-Za-z0-9']", "").toLowerCase());
                }
            }
            set.removeIf(s -> s.length() == 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}
