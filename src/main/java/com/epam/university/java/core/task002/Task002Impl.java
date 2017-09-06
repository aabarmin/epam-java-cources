package com.epam.university.java.core.task002;

import com.epam.university.java.core.utils.Validator;

public class Task002Impl implements Task002 {
    public static final String errorMessageForFirstParameterIfNull = "first string can't be null";
    public static final String errorMessageForSecondParameterIfNull = "second string can't be null";
    public static final String errorMessageForSourceIfNull = "source can't be null";
    public static final String errorMessageForSourceIfLengthNull = "source's length can't be null";
    public static final String errorMessageIfNegative = "number should be positive";
    public static final String errorMessageForSeparatorIfNull = "separator can't be null";
    public static final String errorMessageForSeparatorIfLengthNull = "separator can't be null";
    public static final String errorMessageForGlueIfNull = "glue string can't be null";

    @Override
    public boolean isEquals(String firstString, String secondString) {
        Validator.validateNotNull(firstString, secondString,
                errorMessageForFirstParameterIfNull, errorMessageForSecondParameterIfNull);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        Validator.validateValueAndLengthNotNull(sourceString, errorMessageForSourceIfNull,
                errorMessageForSourceIfLengthNull);
        Validator.validateNotNegative(number, errorMessageIfNegative);
        if (sourceString.length() < number) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        Validator.validateValueAndLengthNotNull(sourceString, errorMessageForSourceIfNull,
                errorMessageForSourceIfLengthNull);
        Validator.validateNotNegative(number, errorMessageIfNegative);
        if (sourceString.length() < number) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number, sourceString.length());
    }

    @Override
    public String left(String sourceString, String stringSeparator) {
        return split(sourceString, stringSeparator)[0];
    }

    @Override
    public String right(String sourceString, String stringSeparator) {
        return split(sourceString, stringSeparator)[1];
    }

    @Override
    public String[] split(String sourceString, String stringSeparator) {
        Validator.validateValueAndLengthNotNull(sourceString, stringSeparator,
                errorMessageForSourceIfNull, errorMessageForSeparatorIfNull,
                errorMessageForSourceIfLengthNull, errorMessageForSeparatorIfLengthNull);
        return sourceString.split(stringSeparator);
    }

    @Override
    public String join(String[] sourceArray, String glueString) {
        Validator.validateNotNull(sourceArray, glueString,
                errorMessageForSourceIfNull, errorMessageForGlueIfNull);
        return String.join(glueString, sourceArray);
    }
}