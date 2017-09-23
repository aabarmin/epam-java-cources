package com.epam.university.java.core;

/**
 * class is to be used by all the TaskXXX classes for params consistency checking.
 *
 * @author  Sergei Titov
 */

public class ChecksHelper {

    /**
     * serves as exception-thrower in case of too bad parameter.
     *
     * @param arg is to be checked for not being a null
     * @throws IllegalArgumentException otherwise
     */
    public static void checkForNull(Object arg) throws IllegalArgumentException {
        if (null == arg) {
            throw new IllegalArgumentException();
        }
    }

    /**
    * serves as exception-thrower in case of too bad parameter.
    *
    * @param arg is to be checked for not being a null or an empty array
    * @throws IllegalArgumentException otherwise
    */
    public static void checkForEmptiness(int[] arg) throws IllegalArgumentException {
        if ((null == arg) || (0 == arg.length)) {
            throw new IllegalArgumentException();
        }
    }

    /**
    * serves as exception-thrower in case of too bad parameters.
    *
    * @param firstNumber is to be checked for not being a null
    * @param secondNumber is to be checked for not being a null
    * @throws IllegalArgumentException otherwise
    */
    public static void checkForNullBothArguments(
            Object firstNumber,
            Object secondNumber) throws IllegalArgumentException {

        if (null == firstNumber && null == secondNumber) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * serves as exception-thrower in case of too bad parameters.
     *
     * @param firstNumber is to be checked for not being only a single whitespace-char string
     * @param secondNumber is to be checked for not being only a single whitespace-char string
     * @throws IllegalArgumentException otherwise
     */
    public static void checkForEmptyBothArguments(
            String firstNumber,
            String secondNumber) throws IllegalArgumentException {

        if (firstNumber.equals(" ") && secondNumber.equals(" ")) {
            throw new IllegalArgumentException();
        }
    }
}
