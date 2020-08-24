package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }

        List<String> strings = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

            while (reader.ready()) {
                String s = reader.readLine();
                String[] stringArr = s.split("[ ,.!?]");
                strings.addAll(Arrays.asList(stringArr));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        set.addAll(strings);
        set.remove("");

        return set;
    }
}
