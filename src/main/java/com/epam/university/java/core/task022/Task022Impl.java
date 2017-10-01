package com.epam.university.java.core.task022;

import java.util.Collection;

/**
 * Created by Вера on 29.09.2017.
 */
public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        int[] array = new int[numbers.size()];
        int i = 0;
        for (Integer n : numbers) {
            array[i] = n;
            i++;
        }
        int min = array[0];
        i = 0;
        // ищем минимальный элемент массива и записывает в i - его индекс
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                i = j;
            }
        }

        int resultSum = 0;
        for (int j = 0; j < array.length; j++) {
            if (i != j) {
                resultSum += array[j];
            }
        }

        return resultSum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        int[] array = new int[numbers.size()];
        int i = 0;
        for (Integer n : numbers) {
            array[i] = n;
            i++;
        }
        int max = array[0];
        i = 0;
        // ищем максимальный элемент массива и записывает в i - его индекс
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                i = j;
            }
        }

        int resultSum = 0;
        for (int j = 0; j < array.length; j++) {
            if (i != j) {
                resultSum += array[j];
            }
        }

        return resultSum;
    }
}
