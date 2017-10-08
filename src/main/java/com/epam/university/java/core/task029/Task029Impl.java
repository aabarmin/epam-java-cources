package com.epam.university.java.core.task029;

import java.util.*;

/**
 * Created by Daniil Smirnov on 08.10.2017.
 * All copy registered MF.
 */
public class Task029Impl implements Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        ArrayList<String> AL = new ArrayList<>(rows);
        Map<Integer, Integer> horizontalFilds = new HashMap<>();
        Map<Integer, Integer> verticalFilds = new HashMap<>();
        int verticalCount = 1;
        int horizontalCount = 1;
        int horizontalLenght = 0;
        int verticalLenght = 0;

        for (int i = 0; i < AL.size(); i++) {
            String[] strings = AL.get(i).split("");
            for (int j = 0; j < strings.length; j++) {

                if (strings[j].equals("-")) {
                    if (AL.get(i+1).split("")[j].equals("-")) {
                        horizontalFilds.put(i,j);
                    }
                }
            }

        }
        return null;
    }

    private class Mark {
        private boolean horizontal;
        private List<Mark> connections = new ArrayList<>();
        private int size;

    }
}
