package com.epam.university.java.core.task010;

import java.io.File;
import java.util.Map;

/**
 * Frequency calculator.
 */
public interface Task010 {
    /**
     * Given a textual file, you should count frequency of words in this file.
     *
     * @param source source file
     * @return map word to frequency of it
     */
    Map<String, Integer> countWordNumbers(File source);
}
