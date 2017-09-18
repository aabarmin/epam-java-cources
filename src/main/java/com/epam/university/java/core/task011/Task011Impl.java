package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Вера on 16.09.2017.
 */
public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        // k - счетчик ненулевых элементов массива
        int k = collection.length;
        int i = 0;
        int countOfCircle = 1; // какой круг по счету
        int indicatorExistNotNullElementAtTheEnd = 0;
        while (k != 1) {
            while (i < collection.length) {
                collection[i] = null;
                i = i + 2 * countOfCircle;
            }
            // возвращаюсь к последнему удаленному элементу и проверяю наличие непустых элементов
            // в оставшемся конце массива
            i = i - 2 * countOfCircle;
            indicatorExistNotNullElementAtTheEnd = 0;
            for (int j = i; j < collection.length; j++) {
                if (collection[j] != null) {
                    indicatorExistNotNullElementAtTheEnd++;
                }
            }
            // нахожу первый ненулевой элемент с начала массива
            // если в конце массива есть ненулевой элемент, то счетчик будет начинаться с первого
            // ненулевогоэлемента массива
            // если в конце массива все нулевые элементы, то счетчик будет начинаться
            // со второго ненулевого элемента с начала массива
            for (int j = 0; j < collection.length; j++) {
                if (collection[j] != null) {
                    i = j;
                    break;
                }
            }
            //нахожу второй ненулевой элемент в массиве
            if (indicatorExistNotNullElementAtTheEnd == 0) {
                for (int j = i + 1; j < collection.length; j++) {
                    if (collection[j] != null) {
                        i = j;
                        break;
                    }
                }
            }

            k = 0;
            // считаю оставшееся количество ненулевых элементов в массиве
            for (int j = 0; j < collection.length; j++) {
                if (collection[j] != null) {
                    k++;
                }
            }
        }

        // нахожу единственный ненклевой элемент в массиве
        String result = "";
        for (int j = 0; j < collection.length; j++) {
            if (collection[j] != null) {
                result = collection[j];
            }
        }

        return result;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        int i = 0;
        while (collection.size() != 1) {

            // пока не дошли до последнего или предпоследнего элемента листа
            // удаляем элементы
            while (i != collection.size() - 1 && i != collection.size() - 2) {
                collection.remove(i);
                i++;
            }
            collection.remove(i);

            // если удалили последний элемент из листа, переходим по кругу ко второму элементу
            // с начала
            // если удалили второй элемент с конца листа, переходим по кругу
            // к первому элементу с начала листа
            if (i == collection.size()) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        int i = 0;
        while (collection.size() != 1) {

            // пока не дошли до последнего или предпоследнего элемента листа
            // удаляем элементы
            while (i != collection.size() - 1 && i != collection.size() - 2) {
                collection.remove(i);
                i++;
            }
            collection.remove(i);

            // если удалили последний элемент из листа, переходим по кругу ко второму элементу
            // с начала
            // если удалили второй элемент с конца листа, переходим по кругу
            // к первому элементу с начала листа
            if (i == collection.size()) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return collection.get(0);
    }
}
