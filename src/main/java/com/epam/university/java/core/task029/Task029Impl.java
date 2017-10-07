package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Recursion and crosswords.
 */
public class Task029Impl implements Task029 {

    /**
     * Given 10x10 crossword grid, each line in <code>rows</code> collection presents single
     * line in a crossword. Cells in the grid have values + and -. Cells marked with a -
     * need to be filled up with an appropriate characters.
     * @param rows crossword definition
     * @param words words to fill in
     * @return filled crossword
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {
        return crosswordRoutine(rows, new ArrayList<>(words));
    }

    private Collection<String> crosswordRoutine(Collection<String> rows,
                                                Collection<String> words) {
        if (words.isEmpty()) {
            return State.isComplete(rows) ? rows : Collections.emptyList();
        }
        final String word = words.iterator().next();
        words.remove(word);
        final State state = new State(rows);
        final Collection<Coord> positions = state.getAllPositions(word);
        if (positions.isEmpty()) {
            return Collections.emptyList();
        }
        for (Coord position : positions) {
            final State localState = new State(state, position, word);
            final Collection<String> localWords = new ArrayList<>(words);
            final Collection<String> localRows = fillCrossword(localState.getRows(), localWords);
            if (State.isComplete(localRows)) {
                return localRows;
            }
        }
        return state.getRows();
    }

}