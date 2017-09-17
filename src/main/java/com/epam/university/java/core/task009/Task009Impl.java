package com.epam.university.java.core.task009;

import com.epam.university.java.core.validations.CheckArgument;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Dremina on 10.09.2017.
 */
public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) throws IOException {
        String strLine;
        CheckArgument.validateNullValue(sourceFile);
        ArrayList<String> removeDuplicates = new ArrayList<String>();

        try {

            FileInputStream fstream = new FileInputStream(sourceFile.getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            strLine = br.readLine().toLowerCase();
            List <String> template = Arrays.asList(strLine.split(" "));


            for(int i = 0; i < template.size(); i++){
                String s = template.get(i).replaceAll("[,.!:?;]+$", "");

                 if (removeDuplicates.indexOf(s) == -1) {
                     removeDuplicates.add(s);
                 }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return removeDuplicates;
    }


}
