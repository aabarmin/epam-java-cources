package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) {

        Scanner input = null;
        try {
            input = new Scanner(sourceFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Set<String> result = new HashSet<>();

        String temp;

        while (input.hasNext()) {
            temp = input.next();
            String[] allWords = temp.split("[,.:!?]+");
            for (String word : allWords) {
                word = word.toLowerCase();
                result.add(word);
            }
        }
        return result;
    }
}
