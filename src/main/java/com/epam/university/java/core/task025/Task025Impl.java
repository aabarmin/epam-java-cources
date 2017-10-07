package com.epam.university.java.core.task025;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        if (sourceMessage == null) {
            throw new IllegalArgumentException();
        }
        int count = 0;

        Pattern pattern = Pattern.compile("SOS|(SO.)|(S.S)|(.OS)|(S..)|(.S.)|(..S)|(...)");
        Matcher matcher = pattern.matcher(sourceMessage);
        while (matcher.find()) {
            if (matcher.group(1) != null || matcher.group(2) != null ||  matcher.group(3) != null){
                count++;
            }
            if (matcher.group(4) != null || matcher.group(5) != null ||  matcher.group(6) != null){
                count+=2;

            }
            if (matcher.group(7) != null){
                count+=3;
            }
        }
        return count;
    }
}
