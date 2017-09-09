package com.epam.university.java.core.task009;

import java.io.File;
import java.util.Collection;

/**
 * Files and collections.
 */
public interface Task009 {
    /**
     * Source file contains words which separated with spaces. You need to output all different words. Same
     * word in upper and lower case should be counted as equal.
     *
     * Tip: you can use Set for it.
     *
     * @param sourceFile source file
     * @return collection of different words
     */
    Collection<String> countWords(File sourceFile);
}
