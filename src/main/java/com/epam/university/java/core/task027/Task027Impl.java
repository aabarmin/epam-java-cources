package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ilya on 30.09.17.
 */
public class Task027Impl implements Task027 {

    @Override
    public Collection<Integer> extract(String sourceString) {
        String[] numbers = sourceString.split("");

        int startNumberLength = 0;

        Collection<Integer> resultNumbers = new ArrayList<>();

        while (startNumberLength < numbers.length) {

            startNumberLength++;
            String stringStartNumber = "";

            for (int i = 0; i < startNumberLength; i++) {
                stringStartNumber += numbers[i];
            }

            int startNumber = Integer.parseInt(stringStartNumber);
            int nextNumber = startNumber;

            int length = 0;

            String result = "";

            while (length < numbers.length) {
                resultNumbers.add(nextNumber);
                String stringNextNumber = Integer.toString(nextNumber);
                length += stringNextNumber.length();
                result += stringNextNumber;
                Pattern pattern = Pattern.compile("^" + result);
                Matcher matcher = pattern.matcher(sourceString);
                if (!matcher.find()) {
                    result = "";
                    resultNumbers.clear();
                    break;
                }
                nextNumber++;
            }

            if (sourceString.equals(result)) {
                break;
            }


        }

        return resultNumbers;
    }
}
