package com.epam.university.java.core.task002;

import com.epam.university.java.core.utils.Validator;

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) {
        Validator.validateNotNull(firstString, secondString,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        Validator.validateValueAndLengthNotNull(sourceString, Validator.MESSAGE_FOR_SOURCE_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL);
        Validator.validateNotNegative(number, Validator.MESSAGE_IF_NEGATIVE);
        if (sourceString.length() < number) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String right(String sourceString, int number) {
        Validator.validateValueAndLengthNotNull(sourceString, Validator.MESSAGE_FOR_SOURCE_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL);
        Validator.validateNotNegative(number, Validator.MESSAGE_IF_NEGATIVE);
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
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_LENGTH_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_LENGTH_NULL);
        return sourceString.split(stringSeparator);
    }

    @Override
    public String join(String[] sourceArray, String glueString) {
        Validator.validateNotNull(sourceArray, glueString,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        return String.join(glueString, sourceArray);
    }
}