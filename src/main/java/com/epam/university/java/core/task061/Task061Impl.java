package com.epam.university.java.core.task061;

import java.util.Map;

public class Task061Impl implements Task061 {

    private Map<Integer, Character> toRoman = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M');

    private Map<Character, Integer> toArabic = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);


    @Override
    public String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException();
        }
        StringBuilder line = new StringBuilder();

        int amountOfMs = number / 1000;
        int amountOfCs = (number / 100) % 10;
        int amountOfXs = (number / 10) % 10;
        int amountOfIs = number % 10;


        line.append(getStringFromAmount(amountOfMs, 1000));
        line.append(getStringFromAmount(amountOfCs, 100));
        line.append(getStringFromAmount(amountOfXs, 10));
        line.append(getStringFromAmount(amountOfIs, 1));


        return line.toString();
    }

    private String getStringFromAmount(int amountOfDigits, int digit) {
        StringBuilder outputLine = new StringBuilder();

        char right;
        char left;
        if (amountOfDigits == 9) {
            right = toRoman.get(digit * 10);
            left = toRoman.get(digit);
            outputLine.append(left).append(right);
        }
        if (amountOfDigits > 5 && amountOfDigits < 9) {
            left = toRoman.get(digit * 5);
            right = toRoman.get(digit);
            outputLine.append(left);
            for (int i = 0; i < amountOfDigits - 5; i++) {
                outputLine.append(right);
            }
        }
        if (amountOfDigits == 5) {
            outputLine.append(toRoman.get(digit * 5));
        }
        if (amountOfDigits == 4) {
            right = toRoman.get(digit * 5);
            left = toRoman.get(digit);
            outputLine.append(left).append(right);
        }
        if (amountOfDigits < 4) {
            right = toRoman.get(digit);
            for (int i = 0; i < amountOfDigits; i++) {
                outputLine.append(right);
            }
        }


        return outputLine.toString();
    }


    @Override
    public int convertToArabic(String number) {

        if (number == null) {
            throw new IllegalArgumentException();
        }

        int arabicNumber = 0;

        int rightNumber;
        int leftNumber = 0;

        for (int i = number.length() - 2; i >= 0; i--) {
            if (toArabic.get(number.charAt(i + 1)) == null
                    || toArabic.get(number.charAt(i)) == null) {
                throw new IllegalArgumentException();
            }
            rightNumber = toArabic.get(number.charAt(i + 1));
            leftNumber = toArabic.get(number.charAt(i));

            if (rightNumber > leftNumber) {
                arabicNumber += rightNumber - leftNumber;
                i--;
            } else {
                arabicNumber += rightNumber;
            }
        }

        arabicNumber += leftNumber;
        return arabicNumber;
    }
}
