package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Some text.
 */
public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        List<String> res = new ArrayList<>();
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }
        Set<String> myString = new HashSet<>();
        try (Scanner myReader = new Scanner(sourceFile)) {

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> collection = Arrays.asList(data.split(" "));

                for (String s : collection
                ) {
                    myString.add(s.toLowerCase().replaceAll("[^A-Za-z]", ""));
                }

                for (String s : myString
                ) {
                    if (!s.isEmpty()) {
                        res.add(s);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
