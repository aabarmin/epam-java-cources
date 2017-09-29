package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
    public static Collection<String> countWords(File sourceFile) throws FileNotFoundException {

        Scanner input = new Scanner(sourceFile);

        Set<String> words = new HashSet<>();

        String temp;


        ArrayList<String> list = new ArrayList<>();

        while (input.hasNext()){
            temp = input.next();
            //String[] s = temp.toLowerCase().split("\\pP");
            String[] s = temp.toLowerCase().split("[-,.:!?’]");
            for (int i = 0; i < s.length; i++){
                //System.out.println(s[i]);
                words.add(s[i]);
            }
        }
        System.out.println(words.size());
        return words;
    }

    public static void main(String[] args) throws FileNotFoundException {
        for (String element: countWords(new File("C:\\Users\\Zstudent\\epam-java-cources\\src\\main\\resources\\task009\\words.txt"))) {
            System.out.println(element);
        }
    }
}
