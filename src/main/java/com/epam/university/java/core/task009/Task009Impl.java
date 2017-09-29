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

        Set<String> words = new HashSet<>();

        String temp;

        while (input.hasNext()){
            temp = input.next();
            //String[] s = temp.toLowerCase().split("\\pP");
            String[] s = temp.toLowerCase().split("[-,.:!?]");
            for (int i = 0; i < s.length; i++){
                words.add(s[i]);
            }
        }
        System.out.println(words.size());
        return words;
    }
}
