package com.epam.university.java.core.task025;

/**
 * Created by ilya on 27.09.17.
 */
public class Task025Impl implements Task025 {

    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        final String sos = "SOS";

        if("".equals(sourceMessage)){
            return 0;
        }

        String[] letters = sourceMessage.split("");

        int count = 0;
        for (int i = 0; i < letters.length; i++) {
            if (!letters[i].equals(Character.toString(sos.charAt(i % 3)))) {
                count++;
            }
        }

        return count;
    }
}
