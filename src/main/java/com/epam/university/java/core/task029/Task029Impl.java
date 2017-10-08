package com.epam.university.java.core.task029;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ilya on 03.10.17.
 */
public class Task029Impl implements Task029 {


    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        List<Placement> placements = new PlacementFactory().getPlacements(rows);
        if (placements.size() != words.size()) {
            throw new IllegalArgumentException("Number of placements and words are different");
        }

        if (!recursionFind(placements, words, 0)) {
            throw new IllegalArgumentException("No matches");
        }

        int columns = rows.stream().mapToInt(s -> s.length()).findFirst().getAsInt();

        return new Field(rows.size(), columns).place(placements).getRows();
    }

    private boolean recursionFind(final List<Placement> placements, Collection<String> words,
        int counter) {
        if (counter >= placements.size()) {
            return true;
        }

        for (String word :
            words) {
            if (placements.get(counter).place(word)) {
                Collection<String> newWords = new LinkedList<>(words);
                newWords.remove(word);
                if (recursionFind(placements, newWords, counter + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


}
