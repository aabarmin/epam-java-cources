package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task009Impl implements Task009 {



    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> stringSet = new TreeSet<>();
        try {
            CustomFileReader fileReader = new CustomFileReader();
            String fileText = fileReader.read(sourceFile);
            String[] words = fileText.split("( )|([!] )|([?] )|([.] )|([,] )");
            for (String word : words) {
                stringSet.add(word.toLowerCase());
            }
        } catch (Exception ex) {
            System.out.println("File not Found");
        }
        return stringSet;
    }
}
