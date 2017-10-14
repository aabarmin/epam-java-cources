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
        int result = 0;
        char[] matchedString = "SOS".toCharArray();
        for (int i = 0; i < sourceMessage.length(); i = i + matchedString.length) {
            char[] temp = sourceMessage.substring(i, i + matchedString.length).toCharArray();
            for (int j = 0; j < matchedString.length; j++) {
                if (temp[j] != matchedString[j]) {
                    result++;
                }
            }
        }
        return result;
    }
}
