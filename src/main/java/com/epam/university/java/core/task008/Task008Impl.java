package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {

        sourceString = sourceString.replaceAll("[^\\[\\]\\(\\)\\{\\}]+", "");
        char[] charArray = sourceString.toCharArray();
        MyStack<Character> stack = new MyStack<>(charArray.length);
        for (char ch : charArray) {
            if ((ch == ')' || ch == '}' || ch == ']') && stack.isEmtpy()) {
                return false;
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (stack.lookTop() == '(' && ch == ')'
                    || stack.lookTop() == '{' && ch == '}'
                    || stack.lookTop() == '[' && ch == ']') {
                stack.pop();
            }
        }
        return stack.isEmtpy();
    }
}