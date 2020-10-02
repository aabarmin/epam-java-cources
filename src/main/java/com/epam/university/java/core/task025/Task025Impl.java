package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    /**
     * Martian exploration ship has been broken and sent several SOS messages back to Earth.
     * Some letters of the SOS message are altered by cosmic radiation during transmission.
     * Given the signal received by Earth as a string, determine how many letters of SOS
     * has been changed by radiation.
     *
     * <p>
     * Example: source SOSOASOB, result is 4
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
        if (sourceMessage.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chars = sourceMessage.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (i % 3) {
                case 0:
                case 2:
                    if (!(chars[i] == 'S' || chars[i] == 's')) {
                        count++;
                    }
                    break;
                case 1:
                    if (!(chars[i] == 'O' || chars[i] == 'o')) {
                        count++;
                    }
                    break;
                default:
                    break;
            }
        }

        return count;
    }
}
