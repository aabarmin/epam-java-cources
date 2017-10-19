package com.epam.university.java.core.task027;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 05.10.2017.
 */
public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {

        Collection<Integer> result = new HashSet<>();

        char[] chars = sourceString.toCharArray();

        // в массиве number будет хранится исходная строка, представленная цифрами.
        int[] number = new int[sourceString.length()];

        // заполняю массив number.
        for (int i = 0; i < chars.length; i++) {
            number[i] = Integer.parseInt("" + chars[i]);
        }

        int previousNumber = 0;
        int nextNumber = 0;
        String previousString = "";
        String nextString = "";

        // countDigit - количество цифр в числе.
        int countDigit = 1;

        // ищем первые 2 числа в последовательности, которые удовлетворяют условию.
        while (nextNumber - previousNumber != 1 && countDigit < number.length / 2) {

            previousString = "";
            nextString = "";

            for (int j = 0; j < countDigit; j++) {
                previousString += number[j];
                nextString += number[j + countDigit];
            }

            previousNumber = Integer.parseInt(previousString);
            nextNumber = Integer.parseInt(nextString);

            if (nextNumber - previousNumber != 1) {
                nextString += number[2 * countDigit];
                nextNumber = Integer.parseInt(nextString);
                countDigit++;
            }

        }

        // проверяю найденные числа на отсутствие нулей и что кол-во цифр в первом числе
        // не больше половины исходной строки
        if (previousString.startsWith("0")) {
            return result;
        }
        if (nextString.startsWith("0")) {
            return result;
        }
        if (nextNumber - previousNumber != 1) {
            return result;
        }

        result.add(previousNumber);

        // количество цифр в числе
        countDigit = nextString.length();
        //индекс массива с которого нужно начинать искать следующий элемент
        int index = previousString.length() + nextString.length();
        previousNumber = nextNumber;

        while (index + countDigit < number.length + 1) {
            nextString = "";

            for (int j = 0; j < countDigit; j++) {
                nextString += number[index + j];
            }

            nextNumber = Integer.parseInt(nextString);

            if (nextNumber - previousNumber != 1) {
                nextString += String.valueOf(number[index + countDigit]);
                nextNumber = Integer.parseInt(nextString);
                countDigit++;
            }

            if (nextNumber - previousNumber == 1) {
                // проверка начинается ли число с нуля.
                if (nextString.startsWith("0")) {
                    Collection<Integer> result2 = new HashSet<>();
                    return result2;
                }
                result.add(previousNumber);
                previousNumber = nextNumber;
                index += countDigit;
            }


        }

        result.add(previousNumber);

        return result;
    }
}