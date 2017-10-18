package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {

    @Override
    public String getLastName(String[] collection) {
        int nElem = collection.length;
        if (nElem == 0) {
           throw new IllegalArgumentException();
        }
        int i = 0;
        int pow = 0;
        int result = 1;
        while (nElem > pow) {
           pow = (int) Math.pow(2, i);
            result = 2 * nElem - pow;
           i++;
        }
        return collection[result - 1];
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        int nElem = collection.size();
        if (nElem == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int pow = 0;
        int result = 1;
        while (nElem > pow) {
            pow = (int) Math.pow(2, i);
            result = 2 * nElem - pow;
            i++;
        }
        return collection.get(result - 1);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        int nElem = collection.size();
        if (nElem == 0) {
            throw new IllegalArgumentException();
        }
        int i = 0;
        int pow = 0;
        int result = 1;
        while (nElem > pow) {
            pow = (int) Math.pow(2, i);
            result = 2 * nElem - pow;
            i++;
        }
        return collection.get(result - 1);
    }
}
