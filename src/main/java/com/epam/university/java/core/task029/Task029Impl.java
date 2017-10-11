package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Вера on 11.10.2017.
 */
public class Task029Impl implements Task029 {
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        List<String> listRows = new ArrayList<>();
        List<String> listWords = new ArrayList<>();

        for (String s : rows) {
            listRows.add(s);
        }

        for (String s : words) {
            listWords.add(s);
        }

        char[] firstWord = listWords.get(0).toCharArray();
        int index = -1;
        int i = 0;

        while (i < listRows.size() && index == -1) {
            // Возвращает индекс первого вхождения указанного символа в данной строке.
            index = listRows.get(i).indexOf('-');
            if (index != -1) {
                // проверяю что это слово по вертикали
                // если выше есть буква
                // char charAt(int index) Возвращает символ по указанному индексу.
                if (i > 0 && listRows.get(i - 1).charAt(index) != '+') {
                    for (int j = 0; j < firstWord.length; j++) {
                        char[] chars = listRows.get(i - 1 + j).toCharArray();
                        chars[index] = firstWord[j];
                        String newListRows = String.valueOf(chars);
                        listRows.remove(i - 1 + j);
                        listRows.add(i - 1 + j, newListRows);
                    }
                    // если ниже есть прочерк
                } else if (listRows.get(i + 1).charAt(index) == '-') {
                    for (int j = 0; j < firstWord.length; j++) {
                        char[] chars = listRows.get(i + j).toCharArray();
                        chars[index] = firstWord[j];
                        String newListRows = String.valueOf(chars);
                        listRows.remove(i + j);
                        listRows.add(i + j, newListRows);
                    }
                } else if (index > 0 && listRows.get(i).charAt(index - 1) != '+') {
                    // проверяю что это слово по горизонтали
                    // если левее есть буква
                    char[] chars = listRows.get(i).toCharArray();

                    for (int j = 0; j < firstWord.length; j++) {

                        chars[index - 1 + j] = firstWord[j];
                    }

                    String newListRows = String.valueOf(chars);
                    listRows.remove(i);
                    listRows.add(i, newListRows);
                } else if (listRows.get(i).charAt(index + 1) != '+') {

                    char[] chars = listRows.get(i).toCharArray();
                    for (int j = 0; j < firstWord.length; j++) {

                        chars[index + j] = firstWord[j];
                    }

                    String newListRows = String.valueOf(chars);
                    listRows.remove(i);
                    listRows.add(i, newListRows);
                }

            }
            i++;
        }

        //listRows.stream().forEach(m -> System.out.println(m));
        //System.out.println("============================");

        //listWords.stream().forEach(m -> System.out.println(m));

        listWords.remove(0);
        if (listWords.size() == 0) {
            return listRows;
        } else {
            return fillCrossword(listRows, listWords);
        }
    }
}
