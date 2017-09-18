package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        String[] strArr = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(source));
            strArr = br.readLine().toLowerCase().split("[^a-zA-Z0-9_’-]+");
            Map<String,Integer> map = new HashMap<String, Integer>();

        }catch (IOException e){

        }
        return null;
    }
}
