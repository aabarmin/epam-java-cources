package com.epam.university.java.core.task010;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> result = new HashMap<>();
        List<String> pullOfElements = new ArrayList<>();
        try (Stream<String> streamFromFiles = Files.lines(Paths.get(source.getAbsolutePath()))) {
            pullOfElements.addAll(streamFromFiles
                    .flatMap(n -> Arrays.asList(n.toLowerCase().split("[ .,!?/'();:]+"))
                            .stream())
                    .collect(Collectors.toList()));

        } catch (Exception e) {
            System.out.println("Unable to open file");
        }
        for (String current: pullOfElements) {
            if (result.containsKey(current)) {
                result.put(current, result.get(current) + 1);
            } else {
                result.put(current, 1);
            }

        }
        return result;
    }
}
