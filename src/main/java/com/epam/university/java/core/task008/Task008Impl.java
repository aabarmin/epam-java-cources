package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        sourceString = sourceString.replaceAll("[^\\(\\)\\[\\]\\{\\}]", "");
        MyCharStack stack = new MyCharStack();
        for (char bracket : sourceString.toCharArray()) {
            switch (bracket) {
                case '(':
                case '[':
                case '{':
                    stack.push(bracket);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
            }
        }
        return stack.isEmpty();
    }
}
