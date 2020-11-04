package com.epam.university.java.core.task053;

/**
 * Calculator.
 *
 * <p>
 *     A mathematical expression in a classical record is given.
 *     The expression can only contain natural, positive numbers and
 *     mathematical characters, without spaces such as:
 *     + - * / ^ ( )
 *
 *     It is necessary to calculate the result of the expression.
 *
 *     Tip: Google "reverse polish notation".
 * </p>
 *
 */

public interface Task053 {
    /**
     * Calculate the result.
     *
     * @param input Mathematical expression.
     * @return double result
     * @throws IllegalArgumentException if input parameters not valid
     */
    double calculate(String input);
}
