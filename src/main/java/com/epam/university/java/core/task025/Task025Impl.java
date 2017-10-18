package com.epam.university.java.core.task025;


/**
 * {@inheritDoc}
 */
public class Task025Impl implements Task025 {
    /**
     * {@inheritDoc}
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        char[] sosString = "SOS".toCharArray();
        int alteredLettersCounter = 0;

        for (int i = 0; i < sourceMessage.length(); i++) {
            int k = i >= sosString.length ? i % sosString.length : i;

            if (sosString[k] != sourceMessage.charAt(i)) {
                alteredLettersCounter++;
            }
        }
        return alteredLettersCounter;
    }
}
