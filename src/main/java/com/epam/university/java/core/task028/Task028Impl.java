package com.epam.university.java.core.task028;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Recursion.
 */
public class Task028Impl implements Task028 {
    /**
     * Find the number of ways that a given integer <code>value</code> can be expressed as the
     * sum of the Nth power of unique, natural numbers.
     *
     * <p>
     *     Examples:
     *          value is 10, power is 2, result is 1 because 10 = 1^2 + 3^2
     *          value is 100, power is 2, result is 3 because 100 = 10^2 =
     *                  6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2
     * </p>
     *
     * @param value value number
     * @param power power
     * @return number of ways
     */
    @Override
    public int getWays(int value, int power) {
        // init nums coollection with values from sqrt(value) to 1 in power = power
        List<Integer> nums = new ArrayList<>();
        for (int i = (int)Math.round(Math.sqrt(value)); i > 0; i--) {
            nums.add((int)Math.round(Math.pow(i, power)));
        }

        return getNum(nums, 0, value);
    }

    /**
     * Recursive get ways for (value - current).
     * @param nums collection
     * @param index start index for next valie < current
     * @param value valur - current
     * @return num of ways
     */
    private int getNum(List<Integer> nums, int index, int value) {
        int result = 0;
        for (int i = index; i < nums.size(); i++) {
            if (nums.get(i) == value) {
                result++;
            }
            if (nums.get(i) > value) {
                continue;
            }
            if (nums.get(i) < value) {
                result += getNum(nums, i + 1, value - nums.get(i));
            }
        }

        return result;
    }
}
