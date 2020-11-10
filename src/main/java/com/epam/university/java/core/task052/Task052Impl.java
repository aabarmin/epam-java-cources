package com.epam.university.java.core.task052;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Task052Impl implements Task052 {
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


    @Override
    public boolean validateCard(long number) {
        if (String.valueOf(number).length() < 14
                || String.valueOf(number).length() > 19
                || number < 0) {
            throw new IllegalArgumentException();
        }
        int checkDigit = (int) (number % 10);
        List<String> digits = Arrays.asList(String.valueOf(number / 10).split(""));
        List<Integer> integers = digits
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(integers);
        for (int i = 0; i < integers.size(); i++) {
            if (i % 2 == 0) {
                int product = integers.get(i) * 2;
                if (product > 9) {
                    product = product % 10 + product / 10;
                }
                integers.set(i, product);
            }
        }
        Integer sum = integers.stream().reduce(Integer::sum).orElse(0);
        return 10 - sum % 10 == checkDigit;
    }
}
