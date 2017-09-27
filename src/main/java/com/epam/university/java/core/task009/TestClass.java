package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestClass {
    public static Collection<String> countWords(File sourceFile) throws FileNotFoundException {

        Scanner input = new Scanner(sourceFile);

        Set<String> words = new HashSet<>();
        int count = 0;

        while (input.hasNext()){
            words.add(input.next());
            count++;
        }
        System.out.println(count);
        return words;
    }

    public static void main(String[] args) throws FileNotFoundException {
        for (String element: countWords(new File("C:\\Users\\Zstudent\\epam-java-cources\\src\\main\\java\\com\\epam\\university\\java\\core\\task009\\words.txt"))) {
            System.out.println(element);
        }

    }
}
