package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CustomFileReader {
    /**
     * Reads file.
     * @param file input file.
     * @return text of file.
     * @throws FileNotFoundException if file not found.
     */
    public String read(File file) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append(" ");
                }
            } finally {
                in.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
