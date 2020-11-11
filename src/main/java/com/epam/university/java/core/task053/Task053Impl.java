package com.epam.university.java.core.task053;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task053Impl implements Task053 {
    @Override
    public double calculate(String input) {
        checkInput(input);

        List<String> polish = polishNotation(input);
        Deque<Double> stack = new ArrayDeque<>();

        for (String unit : polish) {
            if (Character.isDigit(unit.charAt(0))) {
                stack.push(Double.parseDouble(unit));
            } else {
                double x2 = stack.pop();
                double x1 = stack.pop();
                if (unit.equals("+")) {
                    stack.push(x1 + x2);
                }
                if (unit.equals("-")) {
                    stack.push(x1 - x2);
                }
                if (unit.equals("*")) {
                    stack.push(x1 * x2);
                }
                if (unit.equals("/")) {
                    stack.push(x1 / x2);
                }
                if (unit.equals("^")) {
                    stack.push(Math.pow(x1, x2));
                }
            }
        }
        return stack.pop();
    }

    private List<String> polishNotation(String input) {
        List<String> split = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+|[+,\\-,*,\\/,^,(,)]");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            split.add(input.substring(matcher.start(),matcher.end()));
        }
        Set<String> ops = Set.of("+", "-", "*", "/", "^", "(", ")");
        List<String> result = new ArrayList<>();
        Deque<String> stack = new ArrayDeque<>();
        for (String unit : split) {
            if (!ops.contains(unit)) {
                result.add(unit);
            } else if (!unit.equals(")")) {
                while (!stack.isEmpty()
                        && comparePriority(unit, stack.peek()) < 1
                        && !unit.equals("(")) {
                    result.add(stack.pop());
                }
                stack.push(unit);
            } else {
                do {
                    unit = stack.pop();
                    if (!unit.equals("(")) {
                        result.add(unit);
                    }
                } while (!unit.equals("("));
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    private void checkInput(String input) {
        if (input == null || input.length() < 3) {
            throw new IllegalArgumentException();
        }
        List<Character> operators = List.of('+', '-', '*', '/', '^', '(', ')');
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar) && !operators.contains(aChar)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private int comparePriority(String op1, String op2) {
        Map<String, Integer> priorities = Map.of(
                "(", 0,
                "+", 1,
                "-", 1,
                "*", 2,
                "/", 2,
                "^", 3);
        return priorities.get(op1) - priorities.get(op2);
    }
}
