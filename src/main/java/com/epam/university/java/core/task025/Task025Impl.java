package com.epam.university.java.core.task025;

import java.util.stream.Collectors;

/**
 * Cosmic radiation.
 */
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
        return sourceMessage.toUpperCase()
            .chars()
            .mapToObj(i -> (char)i)
            .filter(ch -> ch != 'S')
            .filter(ch -> ch != 'O')
            .collect(Collectors.toList())
            .size();
    }

}
