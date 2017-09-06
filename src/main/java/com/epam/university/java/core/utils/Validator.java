package com.epam.university.java.core.utils;

public class Validator {
    public static void validateNotNull(Object firstParameter, Object secondParameter,
                                       String messageForFirstParameterIfNull,
                                       String messageForSecondParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
    }

    public static void validateNotNull(Object parameter, String messageIfNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
    }

    public static void validateValueAndLengthNotNull(Object firstParameter, Object secondParameter,
                                                     String messageForFirstParameterIfNull,
                                                     String messageForSecondParameterIfNull,
                                                     String messageForFirstParameterIfLengthNull,
                                                     String messageForSecondParameterIfLengthNull) {
        validateValueAndLengthNotNull(firstParameter, messageForFirstParameterIfNull,
                messageForFirstParameterIfLengthNull);
        validateValueAndLengthNotNull(secondParameter, messageForSecondParameterIfNull,
                messageForSecondParameterIfLengthNull);
    }

    public static void validateValueAndLengthNotNull(Object parameter, String messageIfNull,
                                                     String messageIfLengthNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
        if (parameter == "") {
            throw new IllegalArgumentException(messageIfLengthNull);
        }
    }

    public static void validateNotNegative(long parameter, String messageIfNegative) {
        if (parameter < 0) {
            throw new IllegalArgumentException(messageIfNegative);
        }
    }

    public static double[] validateParseDouble(String firstString, String secondString,
                                               String firstNumbersMessageForNumberFormatException,
                                               String secondNumbersMessageForNumberFormatException) {
        double firstDouble;
        double secondDouble;
        try {
            firstDouble = Double.parseDouble(firstString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(firstNumbersMessageForNumberFormatException);
        }
        try {
            secondDouble = Double.parseDouble(secondString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(secondNumbersMessageForNumberFormatException);
        }
        return new double[]{firstDouble, secondDouble};
    }
}