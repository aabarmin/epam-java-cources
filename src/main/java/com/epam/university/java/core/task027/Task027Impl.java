package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null || sourceString.matches("[^0-9]+")) {
            throw new IllegalArgumentException();
        }
        if ('0' == sourceString.charAt(0) || "".equals(sourceString)) {
            return Collections.emptyList();
        }
        for (int i = 1; i <= sourceString.length() / 2; i++) {
            List<Integer> extractedIntegers = new ArrayList<>();
            int currentPosition = 0;
            int interval = i;
            extractedIntegers.add(Integer.parseInt(sourceString
                    .substring(currentPosition, interval)));
            currentPosition += interval;

            while (currentPosition <= sourceString.length() - interval) {
                int currentNumber = extractedIntegers.get(extractedIntegers.size() - 1);
                int nextNumber = Integer.parseInt(sourceString
                        .substring(currentPosition, currentPosition + interval));

                if (nextNumber - currentNumber == 1) {
                    extractedIntegers.add(nextNumber);
                    currentPosition += interval;
                } else if (nextNumber - currentNumber < 1) {
                    interval++;
                } else {
                    break;
                }
            }

            if (currentPosition >= sourceString.length()) {
                StringBuilder stringNumbers = new StringBuilder();
                for (Integer number : extractedIntegers) {
                    stringNumbers.append(number);
                }
                if (stringNumbers.length() != sourceString.length()) {
                    return Collections.emptyList();
                }
                return extractedIntegers;
            }
        }
        return Collections.emptyList();
    }
}