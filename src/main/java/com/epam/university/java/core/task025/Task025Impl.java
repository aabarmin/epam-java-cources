package com.epam.university.java.core.task025;

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
     * @param sourceMessage received message
     * @return amount of altered letters
     */
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        final String[] strings = sourceMessage.split("(?<=\\G...)"); // split by 3 letters
        final String sos = "SOS";
        int count = 0;
        for (String s : strings) {
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != sos.charAt(i)) {
                    ++count;
                }
                count += sos.length() - s.length();
            }
        }
        return count;
    }

}
