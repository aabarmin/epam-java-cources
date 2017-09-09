package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ilya on 09.09.17.
 */
public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

        StringBuilder sb = new StringBuilder();

        while(reader.ready()){
            sb.append(reader.readLine());
        }

        //And count of every word too
        Map<String, Integer> result =
                Arrays.stream(sb.toString().split("[ ,?;:.!’]+"))
                //.forEach(System.out::println);
                .map(word -> word.toLowerCase())
                .collect(HashMap<String, Integer>::new, (m, k) -> m.put(k, m.containsKey(k) ? m.get(k) + 1 : 1), HashMap::putAll);

        System.out.println(result);


        return result.keySet();
    }



}
