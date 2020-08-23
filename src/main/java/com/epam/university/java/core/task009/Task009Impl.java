package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        String text = "";
        try {
            Scanner scanner = new Scanner(sourceFile);
            while (scanner.hasNext()) {
                text += scanner.nextLine();
            }
            ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        text = text.replaceAll("[\\.,]", "");
        String[] words = text.split("\\s+");

        HashSet<String> setWords = new HashSet<>();
        for (String word : words) {
            if (word.length() != 0) {
                setWords.add(word.toUpperCase().trim());
            }
        }

        return setWords;
    }
}
