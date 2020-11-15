package com.epam.university.java.core.task064;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

public class Task064Impl implements Task064 {

    private List<Card> parsedCards = new ArrayList<>();

    @Override
    public Player determineWinner(String firstHand, String secondHand, String board) {
        if (firstHand == null || secondHand == null || board == null) {
            throw new IllegalArgumentException();
        }
        String[] cardCharPairsFirst = firstHand.split(",");
        String[] cardCharPairsSecond = secondHand.split(",");
        String[] cardCharPairsBoard = board.split(",");

        if (cardCharPairsFirst.length != 2
                || cardCharPairsSecond.length != 2
                || cardCharPairsBoard.length != 5) {
            throw new IllegalArgumentException();
        }

        List<Card> boardCards = getHandCards(cardCharPairsBoard);

        List<Card> firstHandCards = getHandCards(cardCharPairsFirst);
        Player firstPlayer = new PlayerImpl(1, firstHandCards);


        List<Card> secondHandCards = getHandCards(cardCharPairsSecond);
        Player secondPlayer = new PlayerImpl(2, secondHandCards);

        Combination firstPlayersCombination
                = getTheHighestCombination(firstHandCards, boardCards);
        Combination secondPlayersCombination
                = getTheHighestCombination(secondHandCards, boardCards);

        int winner = winnerIdBetween(firstPlayersCombination, secondPlayersCombination);
        if (winner == firstPlayer.getId()) {
            return firstPlayer;
        }
        if (winner == secondPlayer.getId()) {
            return secondPlayer;
        }
        return null;
    }

    private int winnerIdBetween(Combination firstPlayersCombination,
                                Combination secondPlayersCombination) {

        if (firstPlayersCombination.combinationValue
                > secondPlayersCombination.combinationValue) {
            return 1;
        } else if (secondPlayersCombination.combinationValue
                < firstPlayersCombination.combinationValue) {
            return 2;
        } else {
            if (firstPlayersCombination.theHighestCardInCombination
                    > secondPlayersCombination.theHighestCardInCombination) {
                return 1;
            } else if (firstPlayersCombination.theHighestCardInCombination
                    < secondPlayersCombination.theHighestCardInCombination) {
                return 2;
            } else {
                if (firstPlayersCombination.secondHighestCardInCombination
                        > secondPlayersCombination.secondHighestCardInCombination) {
                    return 1;
                } else if (firstPlayersCombination.secondHighestCardInCombination
                        < secondPlayersCombination.secondHighestCardInCombination) {
                    return 2;
                } else {
                    if (firstPlayersCombination.thirdHighestCardInCombination
                            > secondPlayersCombination.thirdHighestCardInCombination) {
                        return 1;
                    } else if (firstPlayersCombination.thirdHighestCardInCombination
                            < secondPlayersCombination.thirdHighestCardInCombination) {
                        return 2;
                    } else {
                        if (firstPlayersCombination.fourthHighestCardInCombination
                                > secondPlayersCombination.fourthHighestCardInCombination) {
                            return 1;
                        } else if (firstPlayersCombination.fourthHighestCardInCombination
                                < secondPlayersCombination.fourthHighestCardInCombination) {
                            return 2;
                        } else {
                            if (firstPlayersCombination.fifthCardInCombination
                                    > secondPlayersCombination.fifthCardInCombination) {
                                return 1;
                            } else if (firstPlayersCombination.fifthCardInCombination
                                    < secondPlayersCombination.fifthCardInCombination) {
                                return 2;
                            }
                        }
                    }
                }
            }
        }


        return 0;
    }


    private Card charsToCard(char rank, char suit) {
        Card card = new CardImpl();

        if (suit == 'c') {
            card.setCardSuit(Suit.CLUB);
        } else if (suit == 'd') {
            card.setCardSuit(Suit.DIAMOND);
        } else if (suit == 'h') {
            card.setCardSuit(Suit.HEART);
        } else if (suit == 's') {
            card.setCardSuit(Suit.SPADE);
        }
        if (Character.isDigit(rank)) {
            int rankInt = Integer.parseInt(String.valueOf(rank));
            if (rankInt == 1) {
                rankInt = 10;
            }
            card.setCardRank(rankInt);
        } else if (rank == 'J') {
            card.setCardRank(11);
        } else if (rank == 'Q') {
            card.setCardRank(12);
        } else if (rank == 'K') {
            card.setCardRank(13);
        } else if (rank == 'A') {
            card.setCardRank(14);
        }

        if (card.getCardRank() == 0
                || card.getSuit() == null) {
            throw new IllegalArgumentException();
        }

        if (!parsedCards.contains(card)) {
            parsedCards.add(card);
        } else {
            throw new IllegalArgumentException();
        }

        return card;
    }

    private List<Card> getHandCards(String[] cardCharPairs) {
        List<Card> hand = new ArrayList<>();
        for (String s : cardCharPairs) {
            Card newCard = charsToCard(s.charAt(0), s.charAt(s.length() - 1));
            hand.add(newCard);
        }
        return hand;
    }

    private Combination getTheHighestCombination(List<Card> playerCards, List<Card> boardCards) {
        Combination theHighestCombination = new Combination();

        List<CardImpl> commonCards = new ArrayList<>();
        for (Card playerCard : playerCards) {
            commonCards.add((CardImpl) playerCard);
        }
        for (Card boardCard : boardCards) {
            commonCards.add((CardImpl) boardCard);
        }

        if (itIsTheRoyalFlush(commonCards)) {
            theHighestCombination.combinationValue = 10;
            theHighestCombination.theHighestCardInCombination = 14;
            return theHighestCombination;
        } else if (itIsTheStraightFlush(commonCards) != -1) {
            theHighestCombination.combinationValue = 9;
            theHighestCombination.theHighestCardInCombination = itIsTheStraightFlush(commonCards);
            return theHighestCombination;
        } else if (itIsTheQuads(commonCards) != -1) {
            theHighestCombination.combinationValue = 8;
            int rankOfQuad = itIsTheQuads(commonCards);
            theHighestCombination.theHighestCardInCombination = rankOfQuad;
            theHighestCombination.secondHighestCardInCombination = rankOfQuad;
            theHighestCombination.thirdHighestCardInCombination = rankOfQuad;
            theHighestCombination.fourthHighestCardInCombination = rankOfQuad;
            List<Integer> listOfExceptions = new ArrayList<>();
            listOfExceptions.add(rankOfQuad);
            theHighestCombination.fifthCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            return theHighestCombination;
        } else if (itIsTheFullHouse(commonCards) != null) {
            theHighestCombination.combinationValue = 7;
            int[] tripsAndPair = itIsTheFullHouse(commonCards);
            theHighestCombination.theHighestCardInCombination = tripsAndPair[0];
            theHighestCombination.secondHighestCardInCombination = tripsAndPair[1];
            return theHighestCombination;
        } else if (itIsFlush(commonCards) != null) {
            theHighestCombination.combinationValue = 6;
            int[] ranks = itIsFlush(commonCards);
            theHighestCombination.theHighestCardInCombination = ranks[0];
            theHighestCombination.secondHighestCardInCombination = ranks[1];
            theHighestCombination.thirdHighestCardInCombination = ranks[2];
            theHighestCombination.fourthHighestCardInCombination = ranks[3];
            theHighestCombination.fifthCardInCombination = ranks[4];
            return theHighestCombination;
        } else if (itIsTheStraight(commonCards) != -1) {
            theHighestCombination.combinationValue = 5;
            theHighestCombination.theHighestCardInCombination = itIsTheStraight(commonCards);
            return theHighestCombination;
        } else if (itIsTheTrips(commonCards) != -1) {
            theHighestCombination.combinationValue = 4;
            int tripsRank = itIsTheTrips(commonCards);
            theHighestCombination.theHighestCardInCombination = tripsRank;
            theHighestCombination.secondHighestCardInCombination = tripsRank;
            theHighestCombination.thirdHighestCardInCombination = tripsRank;
            List<Integer> listOfExceptions = new ArrayList<>();
            listOfExceptions.add(tripsRank);
            theHighestCombination.fourthHighestCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            listOfExceptions.add(theHighestCombination.fourthHighestCardInCombination);
            theHighestCombination.fifthCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            return theHighestCombination;
        } else if (itIsTwoPairs(commonCards) != null) {
            theHighestCombination.combinationValue = 3;
            int[] ranks = itIsTwoPairs(commonCards);
            theHighestCombination.theHighestCardInCombination = ranks[0];
            theHighestCombination.secondHighestCardInCombination = ranks[0];
            theHighestCombination.thirdHighestCardInCombination = ranks[1];
            theHighestCombination.fourthHighestCardInCombination = ranks[1];
            List<Integer> listOfExceptions = new ArrayList<>();
            listOfExceptions.add(ranks[0]);
            listOfExceptions.add(ranks[1]);
            theHighestCombination.fifthCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            return theHighestCombination;
        } else if (itIsPair(commonCards) != -1) {
            theHighestCombination.combinationValue = 2;
            int pairRank = itIsPair(commonCards);
            theHighestCombination.theHighestCardInCombination = pairRank;
            theHighestCombination.secondHighestCardInCombination = pairRank;
            List<Integer> listOfExceptions = new ArrayList<>();
            listOfExceptions.add(pairRank);
            theHighestCombination.thirdHighestCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            listOfExceptions.add(theHighestCombination.thirdHighestCardInCombination);
            theHighestCombination.fourthHighestCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            listOfExceptions.add(theHighestCombination.fourthHighestCardInCombination);
            theHighestCombination.fifthCardInCombination
                    = getTheHighestCardExceptSome(commonCards, listOfExceptions);
            return theHighestCombination;
        } else {
            theHighestCombination.combinationValue = 1;
            List<Integer> ranks = getCardsByRanks(commonCards);
            theHighestCombination.theHighestCardInCombination = ranks.get(0);
            theHighestCombination.secondHighestCardInCombination = ranks.get(1);
            theHighestCombination.thirdHighestCardInCombination = ranks.get(2);
            theHighestCombination.fourthHighestCardInCombination = ranks.get(3);
            theHighestCombination.fifthCardInCombination = ranks.get(4);
            return theHighestCombination;
        }
    }

    private int getTheHighestCardExceptSome(List<CardImpl> commonCards,
                                            List<Integer> listOfExceptions) {
        List<Integer> ranks = getCardsByRanks(commonCards);
        ranks.removeAll(listOfExceptions);
        return ranks.get(0);
    }

    private int itIsTheTrips(List<CardImpl> commonCards) {
        Map<Integer, Integer> occurrences = getOccurrences(commonCards);

        int tripsRank = -1;

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 3) {
                tripsRank = key;
                break;
            }
        }

        return tripsRank;
    }

    private List<Integer> getCardsByRanks(List<CardImpl> commonCards) {
        List<Integer> listOfRanks = new ArrayList<>();
        for (CardImpl card : commonCards) {
            listOfRanks.add(card.getCardRank());
        }
        Collections.sort(listOfRanks);
        Collections.reverse(listOfRanks);
        return listOfRanks;
    }

    private int itIsPair(List<CardImpl> commonCards) {

        Map<Integer, Integer> occurrences = getOccurrences(commonCards);

        int highestPair = -1;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 2 && key > highestPair) {
                highestPair = key;
            }
        }

        return highestPair;
    }

    private int[] itIsTwoPairs(List<CardImpl> commonCards) {
        final int[] highestPairAndSecondPair = new int[2];

        Map<Integer, Integer> occurrences = getOccurrences(commonCards);

        int highestPair = 0;
        int secondPair = 0;

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value == 2 && key > highestPair) {
                secondPair = highestPair;
                highestPair = key;
            }
        }

        if (secondPair == 0) {
            return null;
        }
        highestPairAndSecondPair[0] = highestPair;
        highestPairAndSecondPair[1] = secondPair;

        return highestPairAndSecondPair;

    }

    private int[] itIsFlush(List<CardImpl> commonCards) {
        final List<CardImpl> theBiggestAmountOfSuitedCards
                = getTheBiggestAmountOfSuitedCards(commonCards);
        List<Integer> ranks = new ArrayList<>();
        if (theBiggestAmountOfSuitedCards.size() < 5) {
            return null;
        } else {
            for (int i = 0; i < theBiggestAmountOfSuitedCards.size(); i++) {
                ranks.add(theBiggestAmountOfSuitedCards.get(i).getCardRank());
            }
        }

        Collections.sort(ranks);
        Collections.reverse(ranks);
        int[] intRanks = new int[ranks.size()];

        for (int i = 0; i < ranks.size(); i++) {
            intRanks[i] = ranks.get(i);
        }

        return intRanks;
    }

    private int itIsTheStraight(List<CardImpl> commonCards) {

        CardImpl highestStraightCard = getTheHighestStraightCard(commonCards);
        if (highestStraightCard == null) {
            return -1;
        } else {
            return highestStraightCard.getCardRank();
        }
    }

    private int[] itIsTheFullHouse(List<CardImpl> commonCards) {

        final int[] tripsAndPair = new int[2];

        int tripsRank = 0;


        Map<Integer, Integer> cardsWithOccurrences = getOccurrences(commonCards);

        for (Integer cardRank : cardsWithOccurrences.keySet()) {
            if (cardsWithOccurrences.get(cardRank) == 3 && cardRank > tripsRank) {
                tripsRank = cardRank;
            }
        }


        int pairRank = 0;
        for (Integer cardRank : cardsWithOccurrences.keySet()) {
            if (cardsWithOccurrences.get(cardRank) == 2 && cardRank > tripsRank) {
                pairRank = cardRank;
            }
        }

        if (pairRank == 0 || tripsRank == 0) {
            return null;
        }

        tripsAndPair[0] = tripsRank;
        tripsAndPair[1] = pairRank;
        return tripsAndPair;
    }

    private Map<Integer, Integer> getOccurrences(List<CardImpl> cards) {
        Map<Integer, Integer> cardsWithOccurrences = new HashMap<>();
        for (CardImpl commonCard : cards) {
            int cardRank = commonCard.getCardRank();
            if (cardsWithOccurrences.containsKey(cardRank)) {
                int value = cardsWithOccurrences.get(cardRank);
                cardsWithOccurrences.put(cardRank, ++value);
            } else {
                cardsWithOccurrences.put(cardRank, 1);
            }
        }
        return cardsWithOccurrences;
    }

    private int itIsTheQuads(List<CardImpl> commonCards) {

        int valueOfQuadIs = -1;

        Map<Integer, Integer> cardsWithOccurrences = getOccurrences(commonCards);

        for (Integer cardRank : cardsWithOccurrences.keySet()) {
            if (cardsWithOccurrences.get(cardRank) == 4) {
                valueOfQuadIs = cardRank;
            }
        }


        return valueOfQuadIs;
    }

    private int itIsTheStraightFlush(List<CardImpl> commonCards) {
        int isTheStraightFlush = -1;
        List<CardImpl> suitedCards = getTheBiggestAmountOfSuitedCards(commonCards);
        if (suitedCards.size() < 5) {
            return -1;
        }

        CardImpl theHighestStraightCard = getTheHighestStraightCard(suitedCards);

        if (theHighestStraightCard != null) {
            isTheStraightFlush = theHighestStraightCard.getCardRank();
        }


        return isTheStraightFlush;
    }

    private CardImpl getTheHighestStraightCard(List<CardImpl> cards) {

        ArrayList<Integer> ranks = new ArrayList<>();
        for (CardImpl card : cards) {
            ranks.add(card.getCardRank());
        }

        Collections.sort(ranks);
        Collections.reverse(ranks);
        int prev = 0;
        int counter = 1;
        for (int i = 0; i < ranks.size(); i++) {
            if (i == 0) {
                prev = ranks.get(i);
            } else {
                if (prev - ranks.get(i) != 1) {
                    prev = ranks.get(i);
                    ranks.remove(i - 1);
                    i = 0;
                } else {
                    counter++;
                    prev = ranks.get(i);
                    if (counter == 5) {
                        prev = ranks.get(0);
                        break;
                    }
                }

            }
            if (ranks.size() < 5) {
                return null;
            }

        }

        CardImpl theHighestCard = null;
        for (CardImpl card : cards) {
            if (card.getCardRank() == prev) {
                theHighestCard = card;
                break;
            }
        }
        return theHighestCard;
    }

    private List<CardImpl> getTheBiggestAmountOfSuitedCards(List<CardImpl> commonCards) {
        List<CardImpl> suitedCards = getSuitedCards(Suit.CLUB, commonCards);

        if (getSuitedCards(Suit.HEART, commonCards).size() > suitedCards.size()) {
            suitedCards = getSuitedCards(Suit.HEART, commonCards);
        }
        if (getSuitedCards(Suit.SPADE, commonCards).size() > suitedCards.size()) {
            suitedCards = getSuitedCards(Suit.SPADE, commonCards);
        }
        if (getSuitedCards(Suit.DIAMOND, commonCards).size() > suitedCards.size()) {
            suitedCards = getSuitedCards(Suit.DIAMOND, commonCards);
        }

        return suitedCards;
    }

    private List<CardImpl> getSuitedCards(Suit suit, List<CardImpl> cards) {
        List<CardImpl> cardsOfTheSuit = new ArrayList<>();

        for (CardImpl card : cards) {
            if (card.getSuit().equals(suit)) {
                cardsOfTheSuit.add(card);
            }
        }

        return cardsOfTheSuit;
    }

    private boolean itIsTheRoyalFlush(List<CardImpl> commonCards) {
        boolean isRoyalFlush;

        isRoyalFlush = commonCards.containsAll(getTheRoyalFlush(Suit.HEART))
                || commonCards.containsAll(getTheRoyalFlush(Suit.CLUB))
                || commonCards.containsAll(getTheRoyalFlush(Suit.SPADE))
                || commonCards.containsAll(getTheRoyalFlush(Suit.DIAMOND));

        return isRoyalFlush;
    }

    private List<Card> getTheRoyalFlush(Suit suit) {
        return List.of(new CardImpl(14, suit),
                new CardImpl(13, suit),
                new CardImpl(12, suit),
                new CardImpl(11, suit),
                new CardImpl(10, suit));
    }

    private static class Combination {
        private int combinationValue = 1;
        private int theHighestCardInCombination = 1;
        private int secondHighestCardInCombination = 1;
        private int thirdHighestCardInCombination = 1;
        private int fourthHighestCardInCombination = 1;
        private int fifthCardInCombination = 1;
    }
}
