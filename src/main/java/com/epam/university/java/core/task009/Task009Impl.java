package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> resultSet = new HashSet<>();

        // Try-catch block with resources
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile))) {
            // Creating String array form file
            String[] stringArray = reader.readLine()
                    .toLowerCase()
                    .split("[^0-9a-zA-Z-']+");

            // Adding words to Set
            for (String str : stringArray) {
                resultSet.add(str.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
