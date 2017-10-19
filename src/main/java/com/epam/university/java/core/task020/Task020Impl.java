package com.epam.university.java.core.task020;


import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Вера on 08.10.2017.
 */
public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {

        // нахожу первую строку
        Iterator iterator = stones.iterator();
        String stringStoneFirst = (String) iterator.next();

        // массив символов контрольной строки
        char[] charFirstStone = stringStoneFirst.toCharArray();
        Set<Character> set = new HashSet<>();
        // удаляю дубликаты из контрольной строки
        for (int i = 0; i < charFirstStone.length; i++) {
            set.add(charFirstStone[i]);
        }
        // записываю строку без дубликатов
        char[] charWithiouDublicate = new char[set.size()];
        int i = 0;
        for (Character c : set) {
            charWithiouDublicate[i] = c;
            i++;
        }

        int sum = 0;

        for (int j = 0; j < charWithiouDublicate.length; j++) {
            final int k = j;
            if (stones.stream().allMatch((s) ->
                    s.contains(String.valueOf(charWithiouDublicate[k])))) {
                sum++;
            }

        }
        return sum;

    }
}
