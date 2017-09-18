package com.epam.university.java.core.task010;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вера on 16.09.2017.
 */
public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        Map<String, Integer> map = new HashMap<>();

        try {
            FileInputStream filestream = new FileInputStream(source);
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
                // строку без знаков препинания перевожу в нижний регистр и
                // разделяю по пробелам
                String stringLowerCase = withoutSign.toLowerCase();
                String[] str = stringLowerCase.split("\\s+");

                //добавляю уникальные элементы в множество
                for (int i = 0; i < str.length; i++) {
                    if (map.containsKey(str[i])) {
                        int count = map.get(str[i]) + 1;
                        // удаляем этот элемент, чтобы далее его снова добавить
                        // но уже с новым значением
                        map.remove(str[i]);
                        map.put(str[i], count);
                    } else {
                        map.put(str[i], 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка");
        }
        return map;
    }
}
