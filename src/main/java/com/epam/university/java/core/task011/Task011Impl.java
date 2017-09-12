package com.epam.university.java.core.task011;

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        List<String> names = new LinkedList<>();
        names.addAll(Arrays.asList(collection));
        for (int j = 0; j < names.size(); j++) {
            names.remove(j);
            if (j == names.size()) {
                j = 0;
            }
        }
        return names.get(0);
    }

    @Override
    public String getLastName(ArrayList<String> collection) {

        for (int j = 0; j < collection.size(); j++) {
            collection.remove(j);
            if (j == collection.size()) {
                j = 0;
            }
        }
        return collection.get(0);
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        for (int j = 0; j < collection.size(); j++) {
            collection.remove(j);
            if (j == collection.size()) {
                j = 0;
            }
        }
        return collection.get(0);
    }
}
