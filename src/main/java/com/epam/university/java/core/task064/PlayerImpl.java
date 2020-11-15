package com.epam.university.java.core.task064;

import java.util.Collection;

public class PlayerImpl implements Player {

    private int id;
    private Collection<Card> playerHand;

    /**
     * Default player constructor.
     */
    public PlayerImpl() {
    }

    /**
     * Player constructor.
     *
     * @param id         id of the player
     * @param playerHand player's hand
     */
    public PlayerImpl(int id, Collection<Card> playerHand) {
        this.id = id;
        this.playerHand = playerHand;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Collection<Card> getPlayerHand() {
        return playerHand;
    }

    @Override
    public void setPlayerHand(Collection<Card> hand) {
        playerHand = hand;
    }

}
