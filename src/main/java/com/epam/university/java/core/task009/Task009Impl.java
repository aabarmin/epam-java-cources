package com.epam.university.java.core.task009;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> setOfWords = new HashSet<>();
        try (Scanner reader = new Scanner(new BufferedReader(new FileReader(sourceFile)))) {
            reader.useDelimiter(" ");
            /*
            * reader.useDelimiter("[^A-Za-z]");
            * Why doesnt work? dont work properly with commas and question marks
            */
            while (reader.hasNext()) {
                setOfWords.add(reader.next().toLowerCase().replaceAll("[^a-z]", ""));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return setOfWords;
    }
}
