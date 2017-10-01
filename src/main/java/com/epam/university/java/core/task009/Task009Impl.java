package com.epam.university.java.core.task009;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) {
        HashSet<String> result = new HashSet<>();
        try {
            BufferedReader fs = new BufferedReader(new FileReader(sourceFile));
            result.addAll(Arrays.asList(
                    fs.readLine()
                            .toLowerCase()
                            .replaceAll(",","")
                            .replaceAll("\\.","")
                            .replaceAll(":","")
                            .replaceAll("\\?","")
                            .split(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
