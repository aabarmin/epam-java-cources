package com.epam.university.java.core.task064;

import java.util.Objects;

public class CardImpl implements Card, Comparable<CardImpl> {

    private int rank;
    private Suit suit;

    /**
     * Card constructor.
     *
     * @param rank rank of the card
     * @param suit suit of the card
     */
    public CardImpl(int rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Default card constructor.
     */
    public CardImpl() {
    }

    @Override
    public int getCardRank() {
        return rank;
    }

    @Override
    public void setCardRank(int rank) {
        this.rank = rank;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public void setCardSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CardImpl card = (CardImpl) o;
        return rank == card.rank
                && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public int compareTo(CardImpl o) {
        return this.rank - o.getCardRank();
    }
}

