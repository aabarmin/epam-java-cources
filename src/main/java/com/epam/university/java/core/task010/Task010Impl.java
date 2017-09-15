package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Daniil Smirnov on 15.09.2017.
 * All copy registered MF.
 */
public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        String fileRes = "";
        try {
            FileReader fr = new FileReader(source);
            BufferedReader br = new BufferedReader(fr);
            fileRes = br.readLine();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getLocalizedMessage());
        }
        fileRes = fileRes.toLowerCase();
        String[] words = fileRes.split(" ");
        Map<String,Integer> map = new HashMap<>();
        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s,map.get(s) + 1);
            } else {
                map.put(s,1);
            }
        }

        return map;
    }
}
