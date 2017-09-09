package com.epam.university.java.core.task009;

import java.io.File;
import java.util.*;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> result = new HashSet<>();
        try (Scanner fileInput = new Scanner(sourceFile)) {
            result.addAll(Arrays.asList(fileInput.nextLine().toLowerCase().split(" ")));
        } catch (Exception e) {
            System.out.println("Unable to open file");
        }
        return result;
    }
}
