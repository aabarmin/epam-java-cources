package com.epam.university.java.core.task009;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Implementation class for Task009.
 */
public class Task009Impl implements Task009 {
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

        // just making an experiment with stylechecker
        int aX = 2;
        int aY = 2;
        int cX = 2;
        int cY = 2;

        int dx = cX - aX;
        int dy = aY - cY;
        int d = (dx - dy) / 2;

        int dX = aX + d;
        int dY = cY - d;
        int bX = cX - d;
        int bY = aY + d;

        int sum = dX + dY + bX + bY;
        System.out.println( "" + sum );

        try {
            return Files.readAllLines(Paths.get(sourceFile.getAbsolutePath()))
                    .stream()
                    .map(l -> l.split(" "))
                    .flatMap(Arrays::stream)
                    .collect(Collectors.toSet());
        }
        catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
