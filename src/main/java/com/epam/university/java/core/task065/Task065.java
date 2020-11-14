package com.epam.university.java.core.task065;

/**
 * Tic-tac-toe game.
 */

public interface Task065 {
    /**
     * In the Task you have to determine the winner
     * after the third move of Noughts in the Tic-tac-toe game.
     * As input data you have the field represented as a three String.
     * Each String is representing the line (from the top to the bottom order).
     * O - is the Nought.
     * X - is the Cross.
     * # - is the empty cell.
     *
     * @param firstLine  is the top line of the field.
     * @param secondLine is the middle line of the field.
     * @param thirdLine  is the bottom line of the field.
     * @return String "Crosses win" or "Noughts win" or "Draw" depending on the result of the game
     */
    String determineTheResultOfGame(String firstLine, String secondLine, String thirdLine);
}
