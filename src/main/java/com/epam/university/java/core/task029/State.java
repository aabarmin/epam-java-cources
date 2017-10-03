package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * State of the crossword.
 */
public class State {

    private final ArrayList<String> rows;

    public State(Collection<String> rows) {
        this.rows = new ArrayList<>(rows);
    }

    /**
     * Constructs the state from the previous by adding a new word to specified position.
     * @param prevState previous state
     * @param position insert position
     * @param word new word
     */
    public State(State prevState, Coord position, String word) {
        rows = new ArrayList<>(prevState.getRows());
        final int rowIdx = position.getRow();
        final int colIdx = position.getCol();
        if (position.getDirection().equals(Direction.Horizontal)) {
            final String row = rows.get(rowIdx);
            rows.set(
                rowIdx,
                row.substring(0, colIdx) + word
                    + row.substring(colIdx + word.length())
            );
        } else {
            for (int idx = 0, i = colIdx; idx < word.length(); ++idx) {
                final String row = rows.get(i);
                rows.set(
                    i++,
                    row.substring(0, rowIdx) + word.charAt(idx) + row.substring(rowIdx + 1)
                );
            }
        }
    }

    /**
     * Check whether the state has a complete crossword.
     * @return <code>true</code> if complete else <code>false</code>
     */
    public boolean isComplete() {
        return isComplete(rows);
    }

    /**
     * Check if the given collection of the strings doesn't contain dashes.
     * @param rows collection to check
     * @return <code>true</code> if doesn't contain else <code>false</code>
     */
    public static boolean isComplete(Collection<String> rows) {
        if (rows == null || rows.isEmpty()) {
            return false;
        }
        for (String row : rows) {
            if (row.contains("-")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get rows value.
     * @return value
     */
    public Collection<String> getRows() {
        return rows;
    }

    /**
     * Get all possible positions where the given word can be inserted.
     * @param word word
     * @return collection of positions
     */
    public Collection<Coord> getAllPositions(String word) {
        final String wordPattern = toPattern(word);
        final String stringPattern = "(^(" + wordPattern + ")$)" // word fills the whole row
            + '|'
            + "([+]+(" + wordPattern + ")$)" // word is at the end
            + '|'
            + "([+]+(" + wordPattern + ")[+]+)" // word is somewhere in the middle
            + '|'
            + "(^(" + wordPattern + ")[+]+)"; // word is at the beginning
        final Pattern pattern = Pattern.compile(stringPattern);
        Collection<Coord> res = positionsByDirection(
            rows,
            pattern,
            word.length(),
            Direction.Horizontal
        );
        res.addAll(positionsByDirection(
            transpose(), // columns
            pattern,
            word.length(),
            Direction.Vertical
        ));
        return res;
    }

    /**
     * Transpose rows to get cols.
     * @return cols value
     */
    private ArrayList<String> transpose() {
        ArrayList<String> cols = new ArrayList<>();
        for (int i = 0, width = rows.get(0).length(); i < width; ++i) {
            final StringBuilder builder = new StringBuilder();
            for (String row : rows) {
                builder.append(row.charAt(i));
            }
            cols.add(builder.toString());
        }
        return cols;
    }

    /**
     * Get all possible positions to insert a word represented by a <code>pattern</code> and
     * with length equals to <code>wlen</code>. Search in the given direction.
     * @param lines rows or cols value
     * @param pattern pattern describing a word
     * @param wlen length of the word
     * @param dir direction
     * @return collection of the positions
     */
    private Collection<Coord> positionsByDirection(ArrayList<String> lines, Pattern pattern,
                                                   int wlen, Direction dir) {
        Collection<Coord> res = new ArrayList<>();
        for (int i = 0; i < lines.size(); ++i) {
            final Matcher matcher = pattern.matcher(lines.get(i));
            if (matcher.find()) {
                int gidx = -1; // group index
                for (int j = 0; j <= matcher.groupCount(); ++j) {
                    final String group = matcher.group(j);
                    if (group != null && group.length() == wlen) {
                        gidx = j;
                        break;
                    }
                }
                if (gidx < 0) {
                    throw new RuntimeException("smth went wrong");
                }
                res.add(new Coord(i, matcher.start(gidx), dir));
            }
        }
        return res;
    }

    /**
     * Convert a <code>word</code> to a pattern to match a word with possible dashes.
     * <p>
     *     Example: word = "Hello", possible match = "He--o", pattern = [H-][e-][l-][l-][o-]
     * </p>
     * @param word word
     * @return pattern
     */
    private String toPattern(String word) {
        return word.chars()
            .mapToObj(i -> String.format("[%c-]", i))
            .collect(Collectors.joining());
    }

}
