package com.epam.university.java.core.task009;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
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
        double s1_x, s1_y, s2_x, s2_y;
        s1_x = 3;
        s1_y = 3;
        s2_x = 3;
        s2_y = 3;

        double s = (-s1_y * (3) + s1_x * (3)) / (-s2_x * s1_y + s1_x * s2_y);
        double t = ( s2_x * (3) - s2_y * (3)) / (-s2_x * s1_y + s1_x * s2_y);

        double x=0;
        double y=0;
        if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
            // Collision detected at the following coordinates
            x = 5 + (t * s1_x);
            y = 4 + (t * s1_y);
        }
        System.out.println("" + x + y);

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
