package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    /**
     * Martian exploration ship has been broken and sent several SOS messages back to Earth.
     * Some letters of the SOS message are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, determine how many letters of SOS
     * has been changed by radiation.
     *
     * <p>
     *     Example: source SOSOASOB, result is 2
     * </p>
     *
     * @param sourceMessage received message
     * @return amount of altered letters
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {

        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }

        int amount = 0;
        char[] sourceMessageCharArr = sourceMessage.toCharArray();
        char next = 'S';

        for (int i = 0; i < sourceMessageCharArr.length; i++) {

            if (sourceMessageCharArr[i] != next) {
                amount++;
            }
            if ((i + 1) % 3 == 0) {
                next = 'S';
            } else {
                next = (next == 'S' ? 'O' : 'S');
            }

        }

        return amount;

    }
}
