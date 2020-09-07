package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011{
    @Override
    public String getLastName(String[] collection) {
        if (collection == null || collection.length == 0){
            throw new IllegalArgumentException();
        }

        int countOfRemovedPersons = 0;
        do {

        }
        while (countOfRemovedPersons == collection.length - 1);

        return null;
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
