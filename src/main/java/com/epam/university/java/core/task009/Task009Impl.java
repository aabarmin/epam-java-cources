package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) throws FileNotFoundException {

        Scanner input = new Scanner(sourceFile);

        Set<String> words = new HashSet<>();

        while (input.hasNext()){
            words.add(input.next());
        }
        return words;
    }
}
