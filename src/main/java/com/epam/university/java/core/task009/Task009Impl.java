package com.epam.university.java.core.task009;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task009Impl implements Task009 {
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


    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> stringSet = new TreeSet<>();
        try {
            String fileText = read(sourceFile);
            String[] words = fileText.split("( )|([!] )|([?] )|([.] )|([,] )");
            for (String word : words) {
                stringSet.add(word.toLowerCase());
            }
        } catch (Exception ex) {
            System.out.println("File not Found");
        }
        return stringSet;
    }
}
