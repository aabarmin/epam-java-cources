package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {

    public boolean isLast(String[] input){
        int count = 0;
        for (String element: input) {
            if (element != null){
                count++;
            }
        }
        return count != 0;
    }
    @Override
    public String getLastName(String[] collection) {
        if (collection.length == 0){
            throw new IllegalArgumentException();
        }
        int i = 0;
        int end = collection.length;
        String name = null;
        while (isLast(collection)){
            name = collection[i];
            collection[i] = null;
            i = i + 2;
            if (i == end - 1 || i == end - 2){
                name = collection[i];
                collection[i] = null;
                i = 1;
            }
        }
        return name;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        return null;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        return null;
    }
}
