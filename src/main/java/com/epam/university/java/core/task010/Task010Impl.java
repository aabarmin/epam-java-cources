package com.epam.university.java.core.task010;

import com.epam.university.java.core.validations.CheckArgument;

import java.io.*;
import java.util.*;

/**
 * Created by Dremina on 17.09.2017.
 */
public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) throws IOException {
        String strLine;
        CheckArgument.validateNullValue(source);
        ArrayList<String> removeDuplicates = new ArrayList<String>();
        Map<String, Integer> hashMap = new HashMap<String, Integer>();


        try {

            FileInputStream fstream = new FileInputStream(source.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            strLine = br.readLine().toLowerCase();
            List<String> template = Arrays.asList(strLine.split(" "));


            for(int i = 0; i < template.size(); i++){
                String s = template.get(i).replaceAll("[,.!:?;]+$", "");
                int k = 1;
                if (hashMap.containsKey(s)) {
                    k += hashMap.get(s);
                }
                hashMap.put(s, k);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
