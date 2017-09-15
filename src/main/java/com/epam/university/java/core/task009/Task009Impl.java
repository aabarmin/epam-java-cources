package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Daniil Smirnov on 15.09.2017.
 * All copy registered MF.
 */
public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {

        String fileRes = "";
        try {
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);
            fileRes = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileRes = fileRes.toLowerCase();
        fileRes = fileRes
                .replaceAll("\\.","")
                .replaceAll("-","")
                .replaceAll("’","")
                .replaceAll(",","")
                .replaceAll("\\?","")
                .replaceAll(":","");
        String[] array = fileRes.split(" ");
        Set<String> result = new HashSet<>();
        Collections.addAll(result,array);

        return result;
    }
}
