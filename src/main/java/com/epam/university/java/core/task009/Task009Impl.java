package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
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

                if (!set.contains(word.toLowerCase()) && !word.equals(" ") && !word.isEmpty()){
                    set.add(word.toLowerCase());
                }
            }

        }

        return set;
    }
}
