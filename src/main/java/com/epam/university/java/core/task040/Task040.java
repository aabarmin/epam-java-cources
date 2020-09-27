package com.epam.university.java.core.task040;

/**
 * Ten-Pin Bowling
 */
public interface Task040 {

    /**
     * Count the score of Ten-Pin Bowling game.
     * Tip: read the rules of game
     * @param str representing a player's ten frames. Frames separated by " ".
     *            Each frame is two characters (shots) - digits or 'X' or '/'.
     *            'X' - means "strike", '/' - means spare.
     * @return total score of player.
     */
    int countScore(String str);
}
