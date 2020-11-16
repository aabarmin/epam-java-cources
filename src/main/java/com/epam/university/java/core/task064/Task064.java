package com.epam.university.java.core.task064;

/**
 * Texas Hold'em Poker game.
 * Determine the winner of the Texas Hold'em
 * heads up (1 vs 1) game.
 *
 * <p>tip: read the rules of the game. Basically,
 * you need only the rank of the poker combinations
 * to pass the task. Combination is made up of each
 * player's hand and cards on the deck (board).
 */
public interface Task064 {
    /**
     * This method should determine the winner after
     * the showdown in Texas Hold'em.
     * Hands of players are represented by a string of two letters.
     * The first letter is the rank of the card, the second is its suit.
     *
     * <p>E.g.
     * "Js,Qh" represents the first player's hand - Jack of spades and Queen of hearts.
     * "2c,7d" represents the second player's hand - deuce of clubs and seven of diamonds.
     * "2d,2s,7h,Jc,Qs" represents the board with 5 card (showdown time).
     * result of the method should return the second player (with id == 2),
     * because he has the Full house, while the first player has only two pairs.
     *
     * @param firstHand  is the first player's hand (First player is the player with id equals 1)
     * @param secondHand is the second player's hand (Second player is the player with id equals 2)
     * @param board      represents cards on the board (common for both players)
     * @return winner of the game. If the pot was split then null should be returned.
     */
    Player determineWinner(String firstHand, String secondHand, String board);
}

