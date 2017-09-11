package com.epam.university.java.core.task009;

import com.epam.university.java.core.utils.Validator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Validator.validateNotNull(sourceFile,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        try {
            return Files.lines(Paths.get(sourceFile.toURI()))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(element -> element.replaceAll("[^\\P{P}-]+", ""))
                    .map(element -> element.toLowerCase())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}