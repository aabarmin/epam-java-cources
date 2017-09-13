package com.epam.university.java.core.task009;

import com.epam.university.java.core.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Александр on 12.09.2017.
 */
public class Task009Impl implements Task009 {
    Validator VALIDATOR = Validator.newInstance(Task009Impl.class);
    /**
     * Source file contains words which separated with spaces.
     * <p>
     * You need to output all different words.
     * Same word in upper and lower case should be counted as equal.
     * </p>
     * <p>
     * Tip: you can use Set for it.
     * </p>
     *
     * @param sourceFile source file
     * @return collection of different words
     */
    @Override
    public Collection<String> countWords(File sourceFile) {
        VALIDATOR.assertNotNull(sourceFile);

        Set<String> result = new TreeSet<>();
        List <String> lines = new ArrayList<>();

        try {
            lines.addAll(Files.readAllLines(sourceFile.toPath()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String line : lines){
            result.addAll(Arrays.stream(line
                    .replaceAll("[^A-Za-z ]", "")
                    .toLowerCase().split(" "))
                    .collect(Collectors.toSet()));
        }

        return result;
    }
}
