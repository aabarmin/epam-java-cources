package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;


public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        String[] strArr = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
            strArr = br.readLine().toLowerCase().split("[^a-zA-Z0-9_’-]+");
        } catch (IOException e) {

        }
        Set<String> str = new LinkedHashSet<String>(Arrays.asList(strArr));
        return str;
    }
}
