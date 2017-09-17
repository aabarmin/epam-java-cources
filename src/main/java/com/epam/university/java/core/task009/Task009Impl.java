package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> words = new HashSet<>();
        try {
            Scanner in = new Scanner(sourceFile);
            while (in.hasNext()) {
                words.add(in.next().toLowerCase().replaceAll("[^a-z\\-]", ""));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return words;
    }
}
