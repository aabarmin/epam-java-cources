package com.epam.university.java.core.task025;

/**
 * Created by Romin Nuro on 11.09.2020 14:13.
 */
public class Task025Impl implements Task025 {
    /**
     * Martian exploration ship has been broken and sent several SOS messages back to Earth.
     * Some letters of the SOS message are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, determine how many letters of SOS
     * has been changed by radiation.
     *
     * <p>
     * Example: source SOSOASOB, result is 2
     * </p>
     *
     * @param sourceMessage received message
     * @return amount of altered letters
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage != null && sourceMessage.length() == 0) {
            return 0;
        }
        if (sourceMessage == null || sourceMessage.charAt(0) != 'S') {
            throw new IllegalArgumentException();
        }
        char[] letters = sourceMessage.toCharArray();
        int alteredLetters = 0;
        for (int i = 0; i < letters.length; i += 3) {
            if (letters[i] != 'S') {
                alteredLetters++;
            }
            if (i + 1 < letters.length && letters[i + 1] != 'O') {
                alteredLetters++;
            }
            if (i + 2 < letters.length && letters[i + 2] != 'S') {
                alteredLetters++;
            }
        }
        return alteredLetters;
    }
}
