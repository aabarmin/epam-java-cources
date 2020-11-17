package com.epam.university.java.core.task053;

import com.epam.university.java.core.task008.Task008Impl;

import java.util.ArrayList;
import java.util.List;

public class Task053Impl implements Task053 {

    private static final List<Character> characters = List.of(
            '+', '-', '*', '/', '^', '(', ')'
    );

    @Override
    public double calculate(String input) {
        if (!validate(input)) {
            throw new IllegalArgumentException();
        }
        List<Character> digits = new ArrayList<>();
        List<Character> operators = new ArrayList<>();


        for (Character c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                digits.add(' ');
                operators.add(c);
            }
        }
        digits.add(' ');

        List<Double> numbers = fromDigitsToInts(digits);

        return 0;
    }






    private String fromInfiniteToRpn(String infiniteStr){
        StringBuilder rpnString = new StringBuilder();


        return rpnString.toString();
    }

    private List<Double> fromDigitsToInts(List<Character> digits) {
        List<Double> numbers = new ArrayList<>();

        StringBuilder strNum = new StringBuilder();

        for (Character c : digits) {
            if (c != ' ') {
                strNum.append(c);
            } else {
                double num = Double.parseDouble(strNum.toString());
                strNum.delete(0, strNum.length());
                numbers.add(num);
            }
        }


        return numbers;
    }

    private boolean validate(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            return false;
        }
        Task008Impl bracketsChecker = new Task008Impl();
        if (!bracketsChecker.isValid(input)) {
            return false;
        }
        int amountOfDigits = 0;
        int amountOfOperators = 0;
        for (Character c : input.toCharArray()) {
            if (!Character.isDigit(c) && !characters.contains(c)) {
                return false;
            } else if (Character.isDigit(c)) {
                amountOfDigits++;
            } else if (c != '(' && c != ')') {
                amountOfOperators++;
            }
        }
        if (amountOfDigits <= amountOfOperators) {
            return false;
        }
        return true;
    }
}
