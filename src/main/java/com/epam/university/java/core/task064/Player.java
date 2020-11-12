package com.epam.university.java.core.task064;

import java.util.Collection;

public interface Player {

    /**
     * Get player's id.
     *
     * @return player's id
     */
    int getId();

    /**
     * Set player's id.
     *
     * @param id is the player's id.
     */
    void setId(int id);

    /**
     * Get player's hand.
     *
     * @return player's hand
     */
    Collection<Card> getPlayerHand();

    /**
     * Set player's hand.
     *
     * @param hand is the player's hand.
     */
    void setPlayerHand(Collection<Card> hand);
}

