package com.epam.university.java.core.task009;

import java.io.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вера on 16.09.2017.
 */
public class Task009Impl implements Task009 {

    @Override
    public Collection<String> countWords(File sourceFile) {
        Set<String> set = new HashSet<>();

        try {
            FileInputStream filestream = new FileInputStream(sourceFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(filestream));
            String s;
            while ((s = reader.readLine()) != null) {
                char[] chars = s.toCharArray();
                // строка без знаков препинания
                String withoutSign = "";
                for (int i = 0; i < chars.length; i++) {
                    if (!(33 <= chars[i] && chars[i] <= 63)) {
                        withoutSign = withoutSign + String.valueOf(chars[i]);
                    }
                }
                // строку без знаков препинания разделяю по пробелам
                String[] str = withoutSign.split("\\s+");

                //добавляю уникальные элементы в множество
                for (int i = 0; i < str.length; i++) {
                    if (!(set.contains(str[i].toLowerCase()))) {
                        set.add(str[i].toLowerCase());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return set;
    }
}
