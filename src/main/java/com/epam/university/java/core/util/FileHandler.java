package com.epam.university.java.core.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Util class for different operations with files.
 */
public final class FileHandler {

    /**
     * Private constructor, not meant to be instantiated.
     */
    private FileHandler() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns the text contained in the source file.
     *
     * @param source the file to read text from
     * @return text in UTF-8 encoding containing in a file
     */
    public static String readTextFromFile(final File source) {
        StringBuilder text = new StringBuilder();
        try (InputStreamReader reader = new InputStreamReader(
                new FileInputStream(source.getPath()), "UTF-8")) {

            int i;
            // read till the end of the file
            while ((i = reader.read()) != -1) {
                // int to character
                text.append((char) i);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return text.toString();
        }
        return text.toString();
    }
}
