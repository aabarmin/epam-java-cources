package com.epam.university.java.core.task029;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Deque;

public class CrosswordFilling {
    private final Collection<String> filledCrossword = new ArrayList<>();

    public Collection<String> getCrossword() {
        return filledCrossword;
    }

    private Coordinates getNextDash(List<String> rows) {
        Coordinates dash = new Coordinates(-1, -1);
        for (int y = 0; y < rows.size(); y++) {
            int x = rows.get(y).indexOf('-');
            if (x > -1) {
                dash.setX(x);
                dash.setY(y);
                break;
            }
        }
        return dash;
    }

    private boolean fillChar(List<String> rows, Coordinates dash, Deque<Character> stack) {
        if (rows.get(dash.getY()).charAt(dash.getX()) == '-') {
            StringBuilder newRow = new StringBuilder(rows.get(dash.getY()));
            newRow.setCharAt(dash.getX(), stack.pollFirst());
            rows.set(dash.getY(), newRow.toString());
            return true;
        } else if (rows.get(dash.getY()).charAt(dash.getX()) == stack.peekFirst()) {
            stack.pollFirst();
            return true;
        }
        return false;
    }

    /**
     * Fill crossword recursively.
     *
     * @param rows  crossword field
     * @param words words to insert into the crossword
     */
    public void fillCrossword(List<String> rows, List<String> words) {
        if (words.size() == 0) {
            filledCrossword.clear();
            filledCrossword.addAll(rows);
            return;
        }

        for (String word : words) {
            Deque<Character> stack = new ArrayDeque<>();
            for (Character ch : word.toCharArray()) {
                stack.add(ch);
            }
            List<String> intermedRows = new ArrayList<>(rows);
            List<String> intermedWords = new ArrayList<>(words);
            Coordinates coord = getNextDash(intermedRows);

            if (coord.getX() < intermedRows.get(coord.getY()).length() - 1
                    && intermedRows.get(coord.getY()).charAt(coord.getX() + 1) != '+') {
                if (coord.getX() > 0
                        && intermedRows.get(coord.getY()).charAt(coord.getX() - 1) != '+') {
                    if (intermedRows.get(coord.getY()).charAt(coord.getX() - 1)
                            != stack.pollFirst()) {
                        continue;
                    }
                }
                while (stack.size() > 0) {
                    if (coord.getX() > intermedRows.get(coord.getY()).length() - 1
                            || intermedRows.get(coord.getY()).charAt(coord.getX()) == '+') {
                        break;
                    }
                    if (fillChar(intermedRows, coord, stack)) {
                        coord.setX(coord.getX() + 1);
                    } else {
                        break;
                    }
                }
            } else {
                if (coord.getY() > 0
                        && intermedRows.get(coord.getY() - 1).charAt(coord.getX()) != '+') {
                    if (intermedRows.get(coord.getY() - 1).charAt(coord.getX())
                            != stack.pollFirst()) {
                        continue;
                    }
                }
                while (stack.size() > 0) {
                    if (coord.getY() > intermedRows.size() - 1
                            || intermedRows.get(coord.getY()).charAt(coord.getX()) == '+') {
                        break;
                    }
                    if (fillChar(intermedRows, coord, stack)) {
                        coord.setY(coord.getY() + 1);
                    } else {
                        break;
                    }
                }
            }
            if (stack.size() == 0) {
                intermedWords.remove(word);
                fillCrossword(intermedRows, intermedWords);
            }
        }
    }
}