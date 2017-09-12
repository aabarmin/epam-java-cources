package com.epam.university.java.core.task009;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> result = new HashSet<>();
        try (Stream<String> streamFromFiles = Files.lines(Paths.get(sourceFile.getAbsolutePath()))) {
            result = streamFromFiles
                    .flatMap(n -> Arrays.asList(n.toLowerCase().split("[ .,!?/'();:]+"))
                            .stream())
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println("Unable to open file");
        }
        return result;
    }
}
