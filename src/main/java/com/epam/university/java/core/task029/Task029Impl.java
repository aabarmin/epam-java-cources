package com.epam.university.java.core.task029;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Task029Impl implements Task029 {

    /**
     * Given 10x10 crossword grid, each line in <code>rows</code> collection presents single
     * line in a crossword. Cells in the grid have values + and -. Cells marked with a -
     * need to be filled up with an appropriate characters.
     *
     * <p>
     *     Example:
     *          source matrix is:
     *              +-++++++++
     *              +-++++++++
     *              +-++++++++
     *              +-----++++
     *              +-+++-++++
     *              +-+++-++++
     *              +++++-++++
     *              ++------++
     *              +++++-++++
     *              +++++-++++
     *          words list is [LONDON, DELHI, ICELAND, ANKARA]
     *          result matrix is
     *              +L++++++++
     *              +O++++++++
     *              +N++++++++
     *              +DELHI++++
     *              +O+++C++++
     *              +N+++E++++
     *              +++++L++++
     *              ++ANKARA++
     *              +++++N++++
     *              +++++D++++
     *
     * </p>
     *
     * @param rows crossword definition
     * @param words words to fill in
     * @return filled crossword
     */
    @Override
    public Collection<String> fillCrossword(Collection<String> rows, Collection<String> words) {

        if (rows == null || words == null) {
            throw new IllegalArgumentException();
        }

        final Task028Inner task028Inner = new Task028Inner();
        task028Inner.fillCrosswordRecursive(new ArrayList<>(rows), new ArrayList<>(words));
        return task028Inner.getFilledCrossword();

    }

    private class Task028Inner {

        private final Collection<String> filledCrossword = new ArrayList<>();

        public Collection<String> getFilledCrossword() {
            return filledCrossword;
        }

        public void fillCrosswordRecursive(List<String> rows, List<String> words) {

            if (words.size() == 0) {
                filledCrossword.clear();
                filledCrossword.addAll(rows);
                return;
            }

            for (String word : words) {

                List<Character> charList = word
                        .chars()
                        .mapToObj(c -> (char) c)
                        .collect(Collectors.toList());

                Deque<Character> charStack = new LinkedList<>(charList);
                List<String> rc = new ArrayList<>(rows);
                List<String> wc = new ArrayList<>(words);
                Position d = getNextDashPoint(rc);

                // word horizontally
                if (d.getX() < rc.get(d.getY()).length() - 1
                        && rc.get(d.getY()).charAt(d.getX() + 1) != '+') {

                    // check left char
                    if (d.getX() > 0
                            && rc.get(d.getY()).charAt(d.getX() - 1) != '+') {
                        if (rc.get(d.getY()).charAt(d.getX() - 1) != charStack.pollFirst()) {
                            continue;
                        }
                    }

                    while (charStack.size() > 0) {

                        if (d.getX() > rc.get(d.getY()).length() - 1
                                || rc.get(d.getY()).charAt(d.getX()) == '+') {
                            break;
                        }

                        if (fillChar(rc, d, charStack)) {
                            d.setX(d.getX() + 1);
                        } else {
                            break;
                        }

                    }

                // word vertically
                } else {

                    // check top char
                    if (d.getY() > 0
                            && rc.get(d.getY() - 1).charAt(d.getX()) != '+') {
                        if (rc.get(d.getY() - 1).charAt(d.getX()) != charStack.pollFirst()) {
                            continue;
                        }
                    }

                    while (charStack.size() > 0) {

                        if (d.getY() > rc.size() - 1
                                || rc.get(d.getY()).charAt(d.getX()) == '+') {
                            break;
                        }

                        if (fillChar(rc, d, charStack)) {
                            d.setY(d.getY() + 1);
                        } else {
                            break;
                        }

                    }

                }

                if (charStack.size() == 0) {
                    wc.remove(word);
                    fillCrosswordRecursive(rc, wc);
                }

            }

        }

        private Position getNextDashPoint(List<String> rows) {

            Position dash = new Position(-1, -1);

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

        private boolean fillChar(List<String> rows, Position dash, Deque<Character> charStack) {

            if (rows.get(dash.getY()).charAt(dash.getX()) == '-') {
                StringBuilder newRow = new StringBuilder(rows.get(dash.getY()));
                newRow.setCharAt(dash.getX(), charStack.pollFirst());
                rows.set(dash.getY(), newRow.toString());
                return true;
            } else if (rows.get(dash.getY()).charAt(dash.getX()) == charStack.peekFirst()) {
                charStack.pollFirst();
                return true;
            }

            return false;

        }

    }

}
