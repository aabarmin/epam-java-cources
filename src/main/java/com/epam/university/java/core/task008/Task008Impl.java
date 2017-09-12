package com.epam.university.java.core.task008;

public class Task008Impl implements Task008 {

    /**
     * Determines is the provided character closing brace or not.
     *
     * @param ch input character
     * @return true if character is closing brace
     */
    private boolean isClosingBrace(char ch) {
        return ch == '}' || ch == ')' || ch == ']';
    }

    /**
     * Determines is the provided character opening brace or.
     *
     * @param ch input character
     * @return true if character is opening brace
     */
    private boolean isOpeningBrace(char ch) {
        return ch == '{' || ch == '(' || ch == '[';
    }

    /**
     * Determines whether there are unclosed opening braces inside
     * the braces, ending with closing brace {@code str}.
     *
     * @param stack stack of previously processed braces.
     * @param str   closing brace.
     * @return true if braces has not unclosed opening braces inside
     */
    private boolean hasNotUnclosedOpBraceInside(CustomStack<String> stack, String str) {
        int cntRound = 0;
        int cntSquare = 0;
        int cntBrace = 0;
        while (stack.hasNext()) {
            switch (stack.getValue().charAt(0)) {
                case '(': {
                    cntRound -= 1;
                    break;
                }
                case '{': {
                    cntBrace -= 1;
                    break;
                }
                case '[': {
                    cntSquare -= 1;
                    break;
                }
                case ')': {
                    cntRound += 1;
                    break;
                }
                case '}': {
                    cntBrace += 1;
                    break;
                }
                case ']': {
                    cntSquare += 1;
                    break;
                }
                default: {
                    break;
                }
            }
            if (cntRound == -1 && ")".equals(str) && cntSquare == 0 && cntBrace == 0) {
                return true;
            }
            if (cntSquare == -1 && "]".equals(str) && cntRound == 0 && cntBrace == 0) {
                return true;
            }
            if (cntBrace == -1 && "}".equals(str) && cntSquare == 0 && cntRound == 0) {
                return true;
            }
            stack = stack.pop();
        }
        return false;
    }

    @Override
    public boolean isValid(String sourceString) {
        CustomStack<String> stack = new CustomStack<>();
        for (int i = 0; i < sourceString.length(); i++) {

            if (isClosingBrace(sourceString.charAt(i))) {
                if (hasNotUnclosedOpBraceInside(stack,
                                                String.valueOf(sourceString.charAt(i)))) {
                    stack = stack.push(String.valueOf(sourceString.charAt(i)));
                } else {
                    return false;
                }
            }
            if (isOpeningBrace(sourceString.charAt(i))) {
                stack = stack.push(String.valueOf(sourceString.charAt(i)));
            }
        }
        return true;
    }
}
