package com.epam.university.java.core.utils.common;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validation utility.
 */
public class Validator {
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_NULL
            = "first parameter can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_NULL
            = "second parameter can't be null";
    public static final String MESSAGE_FOR_THIRD_PARAMETER_IF_NULL
            = "third parameter can't be null";
    public static final String MESSAGE_FOR_FOURTH_PARAMETER_IF_NULL
            = "fourth parameter can't be null";
    public static final String MESSAGE_FOR_FIFTH_PARAMETER_IF_NULL
            = "fifth parameter can't be null";
    public static final String MESSAGE_FOR_SOURCE_IF_NULL
            = "source can't be null";
    public static final String MESSAGE_IF_VIOLATES_LOWER_BORDER
            = "source can't violate lower border";
    public static final String MESSAGE_IF_VIOLATES_UPPER_BORDER
            = "source can't violate upper border";
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL
            = "first parameter's length can't be null";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL
            = "second parameter's length can't be null";
    public static final String
            MESSAGE_FOR_FIRST_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION
            = "can't convert first input value to number";
    public static final String
            MESSAGE_FOR_SECOND_PARAMETER_IF_NUMBER_FORMAT_EXCEPTION
            = "can't convert second input value to number";
    public static final String MESSAGE_IF_NEGATIVE =
            "number should be positive";
    public static final String MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE =
            "first parameter can't be negative";
    public static final String MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE =
            "second parameter can't be negative";
    public static final String MESSAGE_IF_ILLEGAL_ARGUMENT =
            "illegal argument assigned";
    public static final String MESSAGE_IF_COLLECTION_EMPTY =
            "collection can't be empty";
    public static final String MESSAGE_IF_ILLEGAL_IPV4_ADDRESS =
            "IP Address not in correct";
    public static final String MESSAGE_IF_STRING_EMPTY =
            "input string is empty";

    /**
     * Validates parameters not null.
     *
     * @param firstParameter                  first parameter to check
     * @param secondParameter                 second parameter to check
     * @param messageForFirstParameterIfNull  message if parameter is null
     * @param messageForSecondParameterIfNull message if parameter is null
     * @throws IllegalArgumentException if at least one of parameters is not
     *                                  provided
     */
    public static void validateNotNull(
            Object firstParameter, Object secondParameter,
            String messageForFirstParameterIfNull,
            String messageForSecondParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
    }

    /**
     * Validates parameters not null.
     *
     * @param firstParameter                  first parameter to check
     * @param secondParameter                 second parameter to check
     * @param thirdParameter                  second parameter to check
     * @param messageForFirstParameterIfNull  message if first parameter is null
     * @param messageForSecondParameterIfNull message if second parameter is
     *                                        null
     * @param messageForThirdParameterIfNull  message if third parameter is null
     * @throws IllegalArgumentException if at least one of parameters is not
     *                                  provided
     */
    public static void validateNotNull(
            Object firstParameter, Object secondParameter,
            Object thirdParameter, String messageForFirstParameterIfNull,
            String messageForSecondParameterIfNull,
            String messageForThirdParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
        validateNotNull(thirdParameter, messageForThirdParameterIfNull);
    }

    /**
     * Validates parameters not null.
     *
     * @param firstParameter                  first parameter to check
     * @param secondParameter                 second parameter to check
     * @param thirdParameter                  third parameter to check
     * @param fourthParameter                 fourth parameter to check
     * @param fifthParameter                  fifth parameter to check
     * @param messageForFirstParameterIfNull  message if first parameter is null
     * @param messageForSecondParameterIfNull message if second parameter is
     *                                        null
     * @param messageForThirdParameterIfNull  message if third parameter is null
     * @param messageForFourthParameterIfNull message if fourth parameter is
     * @param messageForFifthParameterIfNull  message if fifth parameter is
     *                                        null
     * @throws IllegalArgumentException if at least one of parameters is not
     *                                  provided
     */
    public static void validateNotNull(
            Object firstParameter, Object secondParameter, Object
            thirdParameter, Object fourthParameter, Object fifthParameter,
            String messageForFirstParameterIfNull, String
                    messageForSecondParameterIfNull, String
                    messageForThirdParameterIfNull, String
                    messageForFourthParameterIfNull, String
                    messageForFifthParameterIfNull) {
        validateNotNull(firstParameter, messageForFirstParameterIfNull);
        validateNotNull(secondParameter, messageForSecondParameterIfNull);
        validateNotNull(thirdParameter, messageForThirdParameterIfNull);
        validateNotNull(fourthParameter, messageForFourthParameterIfNull);
        validateNotNull(fifthParameter, messageForFifthParameterIfNull);
    }

    /**
     * Validates parameter not null.
     *
     * @param parameter     parameter to check
     * @param messageIfNull message if parameter is null
     * @throws IllegalArgumentException if parameter not provided
     */
    public static void validateNotNull(Object parameter, String messageIfNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
    }

    /**
     * Validates value and length of parameters.
     *
     * @param firstParameter                        first parameter to check
     * @param secondParameter                       second parameter to check
     * @param messageForFirstParameterIfNull        message if first
     *                                              parameter is null
     * @param messageForSecondParameterIfNull       message if second parameter
     *                                              is null
     * @param messageForFirstParameterIfLengthNull  message if first parameter's
     *                                              length is null
     * @param messageForSecondParameterIfLengthNull message if first parameter's
     *                                              length is null
     * @throws IllegalArgumentException if parameters not provided or ""
     */
    public static void validateValueAndLengthNotNull(
            Object firstParameter,
            Object secondParameter,
            String messageForFirstParameterIfNull,
            String messageForSecondParameterIfNull,
            String messageForFirstParameterIfLengthNull,
            String messageForSecondParameterIfLengthNull) {
        validateValueAndLengthNotNull(firstParameter,
                messageForFirstParameterIfNull,
                messageForFirstParameterIfLengthNull);
        validateValueAndLengthNotNull(secondParameter,
                messageForSecondParameterIfNull,
                messageForSecondParameterIfLengthNull);
    }

    /**
     * Validates value and length of parameter.
     *
     * @param parameter           parameter to check
     * @param messageIfNull       message if parameter is
     *                            null
     * @param messageIfLengthNull message if parameter's
     *                            length is null
     * @throws IllegalArgumentException if parameter not provided or ""
     */
    public static void validateValueAndLengthNotNull(
            Object parameter, String messageIfNull,
            String messageIfLengthNull) {
        if (parameter == null) {
            throw new IllegalArgumentException(messageIfNull);
        }
        if (parameter == "") {
            throw new IllegalArgumentException(messageIfLengthNull);
        }
    }

    /**
     * Validates parameter not negative.
     *
     * @param parameter         parameter to check
     * @param messageIfNegative message if parameter is
     *                          negative
     * @throws IllegalArgumentException if parameter is negative
     */
    public static void validateNotNegative(long parameter, String
            messageIfNegative) {
        if (parameter < 0) {
            throw new IllegalArgumentException(messageIfNegative);
        }
    }

    /**
     * Validates parameters not negative.
     *
     * @param firstParameter                      parameter to check
     * @param messageForFirstParameterIfNegative  message if first parameter is
     *                                            negative
     * @param messageForSecondParameterIfNegative message if second parameter is
     *                                            negative
     * @throws IllegalArgumentException if at least one parameter is negative
     */
    public static void validateNotNegative(
            long firstParameter, long secondParameter,
            String messageForFirstParameterIfNegative,
            String messageForSecondParameterIfNegative) {
        validateNotNegative(firstParameter, messageForFirstParameterIfNegative);
        validateNotNegative(secondParameter,
                messageForSecondParameterIfNegative);
    }

    /**
     * Validates number format (double).
     *
     * @param firstString                                  string to check
     * @param secondString                                 string to check
     * @param firstNumbersMessageForNumberFormatException  message if
     *                                                     format error
     * @param secondNumbersMessageForNumberFormatException message if
     *                                                     format error
     * @return double[]
     * @throws NumberFormatException if it is not possible
     *                               to parse parameter/parameters to double
     */
    public static double[] validateParseDouble(
            String firstString, String secondString,
            String firstNumbersMessageForNumberFormatException,
            String secondNumbersMessageForNumberFormatException) {
        double firstDouble;
        double secondDouble;
        try {
            firstDouble = Double.parseDouble(firstString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(
                    firstNumbersMessageForNumberFormatException);
        }
        try {
            secondDouble = Double.parseDouble(secondString);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(
                    secondNumbersMessageForNumberFormatException);
        }
        return new double[]{firstDouble, secondDouble};
    }

    /**
     * Validates parameter is in range.
     *
     * @param value                        value to check
     * @param lowerBorder                  minimum possible value to input
     * @param upperBorder                  maximum possible value to input
     * @param messageIfViolatesLowerBorder message if value
     *                                     is violates minimum limit
     * @param messageIfViolatesUpperBorder message if value
     *                                     is violates upper limit
     * @throws IllegalArgumentException if parameter violates limits of range
     */
    public static boolean validateValueRange(double value, double lowerBorder,
                                             double upperBorder,
                                             String messageIfViolatesLowerBorder,
                                             String messageIfViolatesUpperBorder) {
        if (value < lowerBorder) {
            throw new IllegalArgumentException(value + " - "
                    + messageIfViolatesLowerBorder + " - " + lowerBorder);
        }
        if (value > upperBorder) {
            throw new IllegalArgumentException(messageIfViolatesUpperBorder);
        }
        return true;
    }

    /**
     * Validates value exists in Enum.
     *
     * @param value                    value to check
     * @param enumValues               enum values to look in
     * @param messageIfIllegalArgument message if value doesn't belongs to
     *                                 enum
     * @return <code>boolean</code> true if value exists in Enum
     * @throws IllegalArgumentException if parameter doesn't exists in enum
     */
    public static <E extends Enum<E>> boolean
    validateEnum(E value, E[] enumValues, String messageIfIllegalArgument)
            throws IllegalArgumentException {
        for (E enumValue : enumValues) {
            if (enumValue.equals(value)) {
                return true;
            }
        }
        throw new IllegalArgumentException(messageIfIllegalArgument);
    }

    /**
     * Validates if collection is empty or not.
     *
     * @param collection               collection to check
     * @param messageIfCollectionEmpty message if collection is empty
     * @throws IllegalArgumentException if collection is empty
     */
    public static void validateEmpty(Collection collection, String
            messageIfCollectionEmpty) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException(messageIfCollectionEmpty);
        }
    }

    /**
     * Validates if class is legal.
     *
     * @param toCheck               class to check
     * @param toCompare             class to compare with
     * @param messageIfIllegalClass message if class is illegal
     * @throws IllegalArgumentException is class <code>toCheck</code> is illegal
     */
    public static void validateClass(Object toCheck, Object toCompare, String
            messageIfIllegalClass) {
        if (!toCheck.getClass().equals(toCompare.getClass())) {
            throw new IllegalArgumentException(
                    messageIfIllegalClass + toCompare.getClass().getName());
        }
    }

    /**
     * Validates if classes is legal.
     *
     * @param toCheckFirst          first class to check
     * @param toCheckSecond         second class to check
     * @param toCompare             class to compare with
     * @param messageIfIllegalClass message if class is illegal
     * @throws IllegalArgumentException at least one of checked classed is
     *                                  illegal <code>toCheck</code> is illegal
     */
    public static void validateClass(Object toCheckFirst, Object toCheckSecond,
                                     Object toCompare, String
                                             messageIfIllegalClass) {
        validateClass(toCheckFirst, toCompare, messageIfIllegalClass);
        validateClass(toCheckSecond, toCompare, messageIfIllegalClass);
    }

    /**
     * Validates IPv4 address.
     *
     * @param toCheck                      IPv4 address to check
     * @param messageIfViolatesLowerBorder message if violates lower border
     * @param messageIfViolatesUpperBorder message if violates upper border
     * @param messageIfIllegalAddress      message if the address is illegal
     * @throws IllegalArgumentException if address <code>toCheck</code> is
     *                                  illegal
     */
    public static void validateInetAddress(String toCheck, String
            messageIfViolatesLowerBorder, String messageIfViolatesUpperBorder,
                                           String messageIfIllegalAddress) {
        Pattern pattern = Pattern.compile("(\\d{1,3})(\\.)(\\d{1,3})(\\.)"
                + "(\\d{1,3})(\\.)(\\d{1,3})");
        Matcher matcher = pattern.matcher(toCheck);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("IPv4 Address not in correct");
        } else {
            for (int i = 1; i < 8; i += 2) {
                if (!Validator.validateValueRange(Integer.parseInt(matcher
                                .group(i)), 0, 255,
                        messageIfViolatesLowerBorder,
                        messageIfViolatesUpperBorder)) {
                    throw new IllegalArgumentException(messageIfIllegalAddress);
                }
            }
        }
    }

    public static boolean validateStringEmpty(String stringToCheck, String
            messageIfEmpty) {
        if (stringToCheck==null || stringToCheck.isEmpty() ||
                stringToCheck.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}