package com.epam.university.java.core.task029;

import java.util.Collection;

/**
 * Recursion and crosswords.
 */
public interface Task029 {
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
    Collection<String> fillCrossword(Collection<String> rows, Collection<String> words);
}
