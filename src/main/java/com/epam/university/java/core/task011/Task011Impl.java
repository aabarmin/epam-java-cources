package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        String stayPerson = null;
        int i = 0;
        while (true) {
            collection[i] = null;
            do {
                i = (i + 1) < collection.length ? (i + 1) : 0;
            } while (collection[i] == null);
            if (collection[i].equals(stayPerson)) {
                break;
            }
            stayPerson = collection[i];
            do {
                i = (i + 1) < collection.length ? (i + 1) : 0;
            } while (collection[i] == null);
        }

        return stayPerson;
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        String stayPerson = null;
        int i = 0;
        while (true) {
            collection.remove(i);
            if (i == collection.size()) {
                i = 0;
            }
            if (collection.get(i).equals(stayPerson)) {
                break;
            }
            stayPerson = collection.get(i);
            i = (i + 1) < collection.size() ? (i + 1) : 0;
        }
        return stayPerson;
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        String stayPerson = null;
        int i = 0;
        while (true) {
            collection.remove(i);
            if (i == collection.size()) {
                i = 0;
            }
            if (collection.get(i).equals(stayPerson)) {
                break;
            }
            stayPerson = collection.get(i);
            i = (i + 1) < collection.size() ? (i + 1) : 0;
        }
        return stayPerson;
    }
}
