package com.epam.university.java.core.task008;

import static com.epam.university.java.core.task008.BraceStack.Brace.ROUND;
import static com.epam.university.java.core.task008.BraceStack.Brace.SQUIRE;
import static com.epam.university.java.core.task008.BraceStack.Brace.FIGURED;


/**
 * implementation class for Task008.
 *
 * @author Sergei Titov
 */
public class Task008Impl implements Task008 {
    /**
     * Given a string with mathematical expression like "(1 + 2) * {[-3] - 4}",
     * checks if all the braces are correct
     *
     * @param sourceString string to check

     * @returns true if braces are valid
     */
    @Override
    public boolean isValid(String sourceString) {

        BraceStack stack = new BraceStack();

        for (char ch : sourceString.toCharArray()) {

            switch (ch) {
                /////////////////////////////////
                // opening braces
                case '(' :
                    stack.push(ROUND);
                    break;

                case '[' :
                    stack.push(SQUIRE);
                    break;

                case '{' :
                    stack.push(FIGURED);
                    break;

                ////////////////////////////////
                // closing braces
                case ')' :
                    if (!stack.tryPopValue(ROUND)) {
                        return false;
                    }
                    break;

                case ']' :
                    if (!stack.tryPopValue(SQUIRE)) {
                        return false;
                    }
                    break;

                case '}' :
                    if (!stack.tryPopValue(FIGURED)) {
                        return false;
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
