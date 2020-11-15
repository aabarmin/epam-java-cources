package com.epam.university.java.core.task064;

public interface Card {
    /**
     * Get the rank of the card.
     *
     * @return card rank.
     */
    int getCardRank();

    /**
     * Set the rank of the card.
     *
     * @param rank is the rank of the card.
     */
    void setCardRank(int rank);

    /**
     * Get suit of the card.
     *
     * @return card suit.
     */
    Suit getSuit();

    /**
     * Set the rank of the card.
     *
     * @param suit is the suit of the card.
     */
    void setCardSuit(Suit suit);
}
