package com.epam.university.java.core.task066;

public class Task066Impl implements Task066 {

    @Override
    public long repeatString(String infiniteString, long limiter) {

        if (infiniteString == null || limiter < 0) {
            throw new IllegalArgumentException();
        }
        long occurrences = 0;
        StringBuilder newString = new StringBuilder();
        long amountOfRepeats;
        long restOfTheStringLength;

        if (limiter > infiniteString.length()) {
            occurrences = findOccurrences(infiniteString, 'a');
            amountOfRepeats = limiter / infiniteString.length();
            occurrences *= amountOfRepeats;

            restOfTheStringLength = limiter % infiniteString.length();
            newString.append(getShortenedString(infiniteString, (int) restOfTheStringLength));
        } else {
            newString.append(getShortenedString(infiniteString, (int) limiter));
        }

        occurrences += findOccurrences(newString.toString(), 'a');


        return occurrences;
    }

    private long findOccurrences(String string, char letter) {
        int counter = 0;

        char[] chArr = string.toCharArray();
        for (char c : chArr) {
            if (c == letter) {
                counter++;
            }
        }

        return counter;
    }


    private String getShortenedString(String infiniteString, int limiter) {
        char[] charsString = infiniteString.toCharArray();
        char[] shortenedString = new char[limiter];
        System.arraycopy(charsString, 0, shortenedString, 0, limiter);
        return new String(shortenedString);
    }
}
