package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Task010Impl implements Task010 {

    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Scanner input = null;
        try {
            input = new Scanner(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Map<String, Integer> words = new HashMap<>();

        String temp;

        while (input.hasNext()){
            temp = input.next();
            String[] s = temp.toLowerCase().split("[-,.:!?]");
            
        }
        System.out.println(words.size());
        return words;
    }
}
