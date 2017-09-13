package com.epam.university.java.core.util;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * Utility class for assignments.
 *<p>
 *     Contains static methods to avoid writing boilerplate code
 * </p>
 */
public class Utils {

    /**
     * Check if all of the given args satisfy some predicate.
     *
     * @param predicate some condition
     * @param args values to be checked
     * @param <T> type of the arguments
     * @throws IllegalArgumentException if at least one of the arguments doesn't satisfy given
     *                                  condition or no args provided
     */
    public static <T> void assertCondition(Predicate<T> predicate, T... args)
        throws IllegalArgumentException {
        if (args == null) {
            throw new IllegalArgumentException();
        }
        for (T arg: args) {
            if (!predicate.test(arg)) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Check if all of the given args are non null.
     *
     * @param objects values to be checked
     * @throws IllegalArgumentException if null object found or no args provided
     */
    public static void assertNonNull(Object... objects) throws IllegalArgumentException {
        assertCondition(Objects::nonNull, objects);
    }

    /**
     * Check if all of the given strings are non empty.
     *
     * @param strings values to be checked
     * @throws IllegalArgumentException if found empty string or no args provided
     */
    public static void assertNonEmpty(String... strings) throws IllegalArgumentException {
        assertCondition((String s) -> !s.isEmpty(), strings);
    }

    /**
     * Check if all of the given nums are non negative.
     *
     * @param nums values to be checked
     * @throws IllegalArgumentException if found negative number or no args provided
     */
    public static void assertNonNegative(Integer... nums) throws IllegalArgumentException {
        assertCondition((Integer num) -> num.compareTo(0) >= 0, nums);
    }

    /**
     * Check if all of the given nums are positive.
     *
     * @param nums values to be checked
     * @throws IllegalArgumentException if found negative or zero number or no args provided
     */
    public static void assertPositive(Integer... nums) throws IllegalArgumentException {
        assertCondition((Integer num) -> num.compareTo(0) > 0, nums);
    }

    /**
     * Check if reference to array is non null.
     *
     * @param array reference to be checked
     * @throws IllegalArgumentException if reference is null
     */
    public static void assertArrayNonNull(Object[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check if reference to an int array is non null.
     *
     * @param array reference to be checked
     * @throws IllegalArgumentException if reference is null
     */
    public static void assertArrayNonNull(int[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException();
        }
    }

}
