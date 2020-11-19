package com.epam.university.java.core.task053;

import com.epam.university.java.core.task008.Task008Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task053Impl implements Task053 {

    private static final List<String> characters = List.of(
            "+", "-", "*", "/", "^", "(", ")"
    );

    private static final Map<Character, Integer> operators = Map.of(
            '+', 1,
            '-', 1,
            '*', 2,
            '/', 2,
            '^', 3,
            '(', 5,
            ')', 0
    );

    @Override
    public double calculate(String input) {
        if (!validate(input)) {
            throw new IllegalArgumentException();
        }

        String rpnString = fromInfiniteToRpn(input);


        StringBuilder builder;
        while (!isCounted(rpnString)) {
            builder = new StringBuilder();
            String[] strings = rpnString.split(" ");
            if (strings.length < 3) {
                break;
            }
            String operator = null;
            int index = 0;
            for (int i = 0; i < strings.length; i++) {
                if (characters.contains(strings[i])) {
                    index = i;
                    operator = strings[i];
                    break;
                }
            }
            double result = 0;
            double first = Double.parseDouble(strings[index - 2]);
            double second = Double.parseDouble(strings[index - 1]);

            switch (operator) {
                case "+": {
                    result = first + second;
                    break;
                }
                case "-": {
                    result = first - second;
                    break;
                }
                case "*": {
                    result = first * second;
                    break;
                }
                case "/": {
                    result = first / second;
                    break;
                }
                case "^": {
                    result = Math.pow(first, second);
                    break;
                }
                default: {
                }
            }

            strings[index] = String.valueOf(result);
            strings[index - 1] = "";
            strings[index - 2] = "";

            for (String string : strings) {
                if (!string.isEmpty()) {
                    builder.append(string).append(" ");
                }
            }
            rpnString = builder.toString();
        }


        return Double.parseDouble(rpnString);
    }

    private boolean isCounted(String rpnString) {

        for (char c : rpnString.toCharArray()) {
            if (operators.containsKey(c)) {
                return false;
            }
        }

        return true;
    }


    private String fromInfiniteToRpn(String infiniteStr) {
        StringBuilder rpnString = new StringBuilder();
        List<Character> stack = new ArrayList<>();

        for (int i = 0; i < infiniteStr.length(); i++) {
            char currChar = infiniteStr.charAt(i);
            if (Character.isDigit(currChar)) {
                rpnString.append(currChar);
            } else {
                if (currChar != '('
                        && currChar != ')') {
                    rpnString.append(' ');
                }
                stack.add(currChar);
                while (!stackIsOkay(stack)) {
                    char lastOperator = stack.remove(stack.size() - 2);
                    if (lastOperator != '('
                            && lastOperator != ')') {
                        if (rpnString.charAt(rpnString.length() - 1) != ' ') {
                            rpnString.append(' ').append(lastOperator);
                        } else {
                            rpnString.append(lastOperator).append(' ');
                        }
                    }
                    if (lastOperator == '(') {
                        stack.remove(stack.size() - 1);
                    }
                }
            }
        }

        while (stack.size() != 0) {
            char topCharacter = stack.remove(stack.size() - 1);
            rpnString.append(" ").append(topCharacter);
        }

        return rpnString.toString();
    }

    private boolean stackIsOkay(List<Character> stack) {

        int priority = 0;
        for (Character character : stack) {
            if (operators.get(character) <= priority) {
                return false;
            }
            priority = operators.get(character);
            if (character == '(') {
                priority = 0;
            }
        }


        return true;
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
            if (!Character.isDigit(c) && !operators.containsKey(c)) {
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
