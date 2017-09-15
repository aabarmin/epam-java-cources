package com.epam.university.java.core;

public class ChecksHelper {

    // (null)
    public static void checkForNull(Object arg) throws IllegalArgumentException {
        if( null == arg )
            throw new IllegalArgumentException();
    }

    // ([0])
    public static void checkForEmptiness(int[] arg) throws IllegalArgumentException {
        if( (null == arg) || (0 == arg.length) )
            throw new IllegalArgumentException();
    }

    // (null, null)
    public static void checkForNullBothArguments(Object firstNumber, Object secondNumber) throws IllegalArgumentException {
        if( null == firstNumber && null == secondNumber ) {
            throw new IllegalArgumentException();
        }
    }

    // (" ", " ")
    public static void checkForEmptyBothArguments(String firstNumber, String secondNumber) throws IllegalArgumentException {
        if( firstNumber.equals(" ") && secondNumber.equals(" ") ) {
            throw new IllegalArgumentException();
        }
    }
}
