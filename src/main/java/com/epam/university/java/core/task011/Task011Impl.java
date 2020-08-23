package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> people = new ArrayList<>(Arrays.asList(collection));
        int index = -1;
        while (true) {
            if (people.size() == 1) {
                return people.get(0);
            }
            index++;
            System.out.println(people.toString() + index);
            if (index > people.size() - 1) {
                index = Math.abs(people.size() - index);
            }
            people.remove(index);
        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        int index = -1;
        while (true) {
            if (collection.size() == 1) {
                return collection.get(0);
            }
            index++;
            System.out.println(collection.toString() + index);
            if (index > collection.size() - 1) {
                index = Math.abs(collection.size() - index);
            }
            collection.remove(index);
        }
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        if (collection == null || collection.size() == 0) {
            throw new IllegalArgumentException();
        }
        int index = -1;
        while (true) {
            if (collection.size() == 1) {
                return collection.get(0);
            }
            index++;
            System.out.println(collection.toString() + index);
            if (index > collection.size() - 1) {
                index = Math.abs(collection.size() - index);
            }
            collection.remove(index);
        }
    }
}
