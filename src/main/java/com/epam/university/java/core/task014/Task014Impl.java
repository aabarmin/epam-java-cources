package com.epam.university.java.core.task014;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Vampire numbers.
 */
public class Task014Impl implements Task014 {

    /**
     * Returns a collection of the 4-digit vampire numbers.
     * <p>
     *     A vampire number has an even number of digits and is formed by
     *     multiplying a pair of numbers containing half the number of digits
     *     of the result. The digits are taken from the original number
     *     in any order. Pairs of trailing zeroes are not allowed.
     * </p>
     * <p>
     *     Example: 1260 = 21 * 60
     * </p>
     * <p>
     *     {@see https://en.wikipedia.org/wiki/Vampire_number}
     * </p>
     * @return collection of vampire numbers
     */
    @Override
    public Collection<VampireNumber> getVampireNumbers() {
        final int numLength = 4; // test requires 4-digit vampires
        final int start = (int) Math.pow(10, numLength - 1);
        final int end = (int) Math.pow(10, numLength) - 1;
        return IntStream.rangeClosed(start, end)
            .mapToObj(this::getVampireFangs)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    /**
     * Prepares input for the @link{Task014Impl#getFangsRecursively} method.
     *
     * @param vampire potentially vampire number
     * @return Optional of VampireNumber
     */
    private Optional<VampireNumber> getVampireFangs(int vampire) {
        int[] digits = String.valueOf(vampire)
            .chars()
            .map(ch -> ch - '0')
            .toArray();
        if (digits.length % 2 > 0) { // calculate fangs only for even-length numbers
            return Optional.empty();
        }
        int[] counts = new int[10]; // occurrence of the available digits
        for (int digit : digits) {
            ++counts[digit];
        }
        return getFangsRecursively(
            vampire,
            0,
            0,
            counts,
            (int) Math.pow(10, digits.length - 2)
        );
    }

    /**
     * Recursively computes the fang values for the given number.
     *
     * @param vampire number to check
     * @param prevLeft value of the left fang from the previous call
     * @param prevRight value of the right fang from the previous call
     * @param counts array of ten numbers representing the occurrence of still
     *               available digits
     * @param divider power of 100, is divided by 100 each next level in the search tree.
     *                Determines the number of right-most digits of the given number that
     *                are ignored at first in the algorithm
     * @return Optional of VampireNumber
     */
    private Optional<VampireNumber> getFangsRecursively(int vampire, int prevLeft, int prevRight,
                                                        int[] counts, int divider) {
        if (divider < 1) { // end of recursion
            // if multiplication of the fangs is equal to the vampire value
            // and there is no trailing zeros in both fangs, than this is a
            // truly vampire number
            return prevLeft * prevRight == vampire && (prevLeft % 10 + prevRight % 10 != 0)
                ? Optional.of(new VampireNumberImpl(vampire, prevLeft, prevRight))
                : Optional.empty();
        }

        int v = vampire / divider; // left-most digits of potential vampire number
        // shift decimal digits of partial fangs to the left to make room for the
        // next digits
        prevLeft *= 10;
        prevRight *= 10;
        // calculate the min/max left fang digit that can potentially contribute to a
        // solution
        int minLeftDigit = Math.max(v / (prevRight + 10) - prevLeft, 0);
        int maxLeftDigit = prevRight == 0
            ? 9
            : Math.min((v + 1) / prevRight - prevLeft, 9);
        for (int leftDigit = minLeftDigit; leftDigit <= maxLeftDigit; ++leftDigit) {
            if (counts[leftDigit] == 0) {
                continue; // digit is not available
            }
            int leftFang = prevLeft + leftDigit;
            --counts[leftDigit];
            // calculate the min/max right fang digit that can potentially contribute
            // to a solution
            int minRightDigit = Math.max(v / (leftFang + 1) - prevRight, 0);
            int maxRightDigit = leftFang == 0
                ? 9
                : Math.min((v + 1) / leftFang - prevRight, 9);
            for (int rightDigit = minRightDigit; rightDigit <= maxRightDigit; ++rightDigit) {
                if (counts[rightDigit] == 0) {
                    continue;
                }
                int rightFang = prevRight + rightDigit;
                --counts[rightDigit];
                Optional<VampireNumber> result = getFangsRecursively(vampire, leftFang, rightFang,
                    counts, divider / 100);
                if (result.isPresent()) { // found a solution
                    return result;
                }
                ++counts[rightDigit]; // restore counts
            }
            ++counts[leftDigit];
        }
        return Optional.empty(); // solution not found
    }

}