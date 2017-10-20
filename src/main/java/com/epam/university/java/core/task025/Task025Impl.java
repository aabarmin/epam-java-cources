package com.epam.university.java.core.task025;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        int lettersCount = 0;
        String message = "SOS";
        Pattern p = Pattern.compile("[A-Z][A-Z][A-Z]");
        Matcher m = p.matcher(sourceMessage);
        while (m.find()) {
            String check = m.group(0);
            if (!message.equals(check)) {
                for (byte i = 0; i < check.length(); i++) {
                    if (check.charAt(i) != message.charAt(i)) {
                        lettersCount++;
                    }
                }
            }
        }
        return lettersCount;
    }
}
