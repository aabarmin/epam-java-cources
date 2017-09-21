package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        String[] stringArr;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(sourceFile)))) {
            stringArr = br.readLine().toLowerCase().split("[^a-zA-Z0-9_’-]+");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new LinkedHashSet<>(Arrays.asList(stringArr));
    }
}
