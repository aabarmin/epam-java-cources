package com.epam.university.java.core.task010;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        HashMap<String, Integer> resultMain = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        try {
            BufferedReader fs = new BufferedReader(new FileReader(source));
            result.addAll(Arrays.asList(
                    fs.readLine()
                            .toLowerCase()
                            .replaceAll(",","")
                            .replaceAll("\\.","")
                            .replaceAll(":","")
                            .replaceAll("\\?","")
                            .split(" ")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s: result) {
            if (resultMain.containsKey(s)) {
                int oldValue = resultMain.get(s);
                int newValue = oldValue + 1;
                resultMain.replace(s, oldValue, newValue);
            } else {
                resultMain.put(s, 1);
            }
        }
        return resultMain;
    }
}
