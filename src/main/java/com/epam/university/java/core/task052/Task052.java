package com.epam.university.java.core.task052;

/**
 * The Luhn algorithm.
 */
public interface Task052 {
    /**
     * Validate bank card number.
     * Come up with a method that will check the validity of the bank card numbers
     * <p>
     *    Bank card numbers must be between 14-19 digits in length,
     *    and pass the Luhn test, described below:
     * </p>
     *
     * <p>
     *     1. Remove the last digit (this is the "check digit").
     *     2. Reverse the number.
     *     3. Double the value of each digit in odd-numbered positions.
     *     If the doubled value has more than 1 digit, add
     *     the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
     *     4. Add all digits.
     *     5. Subtract the last digit of the sum (from step 4) from 10.
     *     The result should be equal to the check digit from step 1.
     * </p>
     *
     * <p>
     *     Examples: validateCard(1234567890123456) ➞ false
     *      check digit = 6, num = 123456789012345
     *      num reversed = 543210987654321
     *      digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
     *      sum = 58
     *      10 - 8 = 2 (not equal to 6) ➞ false
     *
     *      validateCard(1234567890123452) ➞ true
     *      // Same as above, but check digit checks out.
     * </p>
     *
     * @param number a bankcard number
     * @return suitable for Luhn demands
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */

    boolean validateCard(long number);
}
