package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task029Impl implements  Task029 {

    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        CopyOnWriteArrayList<String> word = new CopyOnWriteArrayList<>(words);
        ArrayList<String> result = new ArrayList<>(rows);
        CopyOnWriteArrayList<Indexes> indexes = new CopyOnWriteArrayList<>();

        for (int y = 0; y < result.size(); y++) {
            for (int x = 0; x < result.get(y).length(); x++) {
                if (result.get(y).charAt(x) == '-') {
                    indexes.add(new Indexes(x,y));
                }
            }
        }

        Indexes firstInd = indexes.get(0);
        String currentWord = word.get(0);
        String changedString = result
                .get(firstInd.getY())
                .replaceFirst("-", String.valueOf(currentWord.charAt(0)));
        result.set(firstInd.getY(), changedString);
        indexes.remove(0);

        while (indexes.size() != 0) {
            int ind = 1;
            for (Indexes i: indexes) {
                if (i.getX() == firstInd.getX()) {
                    changedString = result
                            .get(i.getY())
                            .replaceFirst("-", String.valueOf(currentWord.charAt(ind)));
                    result.set(i.getY(), changedString);
                    ind++;
                    indexes.remove(i);
                } else if (i.getY() == firstInd.getY()) {
                    changedString = result
                            .get(i.getY())
                            .replaceFirst("-", String.valueOf(currentWord.charAt(ind)));
                    result.set(i.getY(), changedString);
                    ind++;
                    indexes.remove(i);
                }
                if (ind == currentWord.length()) {
                    word.remove(0);
                    break;
                }
            }
            if (!indexes.isEmpty() && !word.isEmpty()) {
                firstInd = indexes.get(0);
                currentWord = word.get(0);
            }
        }
        return result;
    }
}
