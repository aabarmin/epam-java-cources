package com.epam.university.java.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Util class for different operations with files.
 */
public class FileHandler {
    /**
     * Returns the text contained in the source file
     * @param source
     * @return
     */
    public static String readTextFromFile(File source){
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(source.getPath()))) {
            String currentString;
            while ((currentString = br.readLine()) != null) {
                text.append(currentString);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return text.toString();
        }
        return text.toString();
    }
}
