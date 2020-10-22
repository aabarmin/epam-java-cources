package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) throws IOException {
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }
        TreeSet<String> set = new TreeSet<>();
        FileReader fileReader = new FileReader(sourceFile);
        BufferedReader reader = new BufferedReader(fileReader);

        while (reader.ready()) {
            String line = reader.readLine();
            String[] words = line.split("[.,]? ");
            for (String word : words) {

                if (!set.contains(word.toLowerCase()) && !word.equals(" ") && !word.isEmpty()) {
                    set.add(word.toLowerCase());
                }
            }

        }

        return set;
    }
}
