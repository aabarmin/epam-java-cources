package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> uniqeWords = new HashSet<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile))){
            while(reader.ready()){
                String line = reader.readLine();

                String[] tempArr = line.toLowerCase().split("[\\s,.:?!;]+");
                uniqeWords.addAll(Arrays.asList(tempArr));
            }

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }return uniqeWords;
    }
}
