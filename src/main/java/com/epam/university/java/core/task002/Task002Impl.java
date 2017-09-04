package com.epam.university.java.core.task002;

import com.epam.university.java.core.validations.CheckArgument;

/**
 * Created by Dremina on 03.09.2017.
 */
public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        CheckArgument.validateNullValue(firstString);
        CheckArgument.validateNullValue(secondString);

        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        CheckArgument.notNegative(number);
        CheckArgument.validateNullValue(sourceString);
        if (sourceString.length() <= number){
            return  sourceString;
        }
        return sourceString.substring(0,number);
    }

    @Override
    public String right(String sourceString, int number) {
        CheckArgument.notNegative(number);
        CheckArgument.validateNullValue(sourceString);
        if (sourceString.length() <= number){
            return  sourceString;
        }
        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String left(String sourceString, String separator) {
        CheckArgument.validateNullValue(sourceString);
        CheckArgument.validateNullValue(separator);

        return sourceString.substring(0, sourceString.indexOf(separator));
    }

    @Override
    public String right(String sourceString, String separator) {
        CheckArgument.validateNullValue(sourceString);
        CheckArgument.validateNullValue(separator);
        int delimiter = sourceString.indexOf(separator);
        if (delimiter == sourceString.length() - 1 ){
            return "";
        }

        return sourceString.substring(delimiter + separator.length());
    }

    @Override
    public String[] split(String sourceString, String split) {
        CheckArgument.validateNullValue(sourceString);
        CheckArgument.validateNullValue(split);

        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        CheckArgument.validateNullValue(glue);

        String resultString = "";
        for (int i = 0; i < sourceCollection.length - 1; i ++){
            resultString = resultString + sourceCollection[i] + glue;
        }

        return resultString + sourceCollection[sourceCollection.length - 1];
    }
}
