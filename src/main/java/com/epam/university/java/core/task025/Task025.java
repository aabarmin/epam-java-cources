package com.epam.university.java.core.task025;

/**
 * Cosmic radiation.
 */
public interface Task025 {
    /**
     * Martian exploration ship has been broken and sent several SOS messages back to Earth.
     * Some letters of the SOS message are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, determine how many letters of SOS
     * has been changed by radiation.
     *
     * <p>
     *     Example: source SOSOASOB, result is 4
     * </p>
     *
     * @param sourceMessage received message
     * @return amount of altered letters
     */
    int getAmountOfAlteredLetters(String sourceMessage);
}
