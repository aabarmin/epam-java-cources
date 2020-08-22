package com.epam.university.java.core.task011;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>(Arrays.asList(collection));
        return getLastAfterRemoveThroughOne(list);
    }


    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        return getLastAfterRemoveThroughOne(collection);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        return getLastAfterRemoveThroughOne(collection);
    }


    private String getLastAfterRemoveThroughOne(List<String> list) {
        int pointer = 0;
        boolean isOdd = list.size() % 2 != 0;
        boolean isEven = list.size() % 2 == 0;

        while (list.size() != 1) {
            System.out.println(isEven + " " + isOdd);
            if (isOdd && (pointer > (list.size() - 1))) {
                pointer = 1;
            }
            if (isEven && (pointer > (list.size() - 1))) {
                pointer = 0;
            }

            list.remove(pointer);
            pointer++;
        }

        return list.get(0);
    }
}
