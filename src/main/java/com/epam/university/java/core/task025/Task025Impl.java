package com.epam.university.java.core.task025;

/**
 * Implementation class for Task025.
 *
 * @author Sergei Titov
 */
public class Task025Impl implements Task025 {

    private final static String word = "SOS";
    private final int length = word.length();

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {

        int amount = 0;

        for (int i = 0; i < sourceMessage.length(); i++) {
            if (sourceMessage.charAt(i) != word.charAt(i % length) ) {
                amount++;
            }
        }

        return amount;
    }
}
