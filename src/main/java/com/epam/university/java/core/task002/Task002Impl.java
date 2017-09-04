package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) throws IllegalArgumentException {

        checkForNullBothArguments( firstString,  secondString);
        checkForEmptyBothArguments( firstString,  secondString);
        return firstString.equals( secondString );
    }

    @Override
    public String left(String sourceString, int number) throws IllegalArgumentException {
        if( number < 0 )
            throw new IllegalArgumentException();

        if( null == sourceString )
            throw new IllegalArgumentException();

        int count = number >= sourceString.length() ?
                sourceString.length() :
                number;

        return sourceString.substring( 0, count );
    }

    @Override
    public String right(String sourceString, int number) throws IllegalArgumentException {
        if( number < 0 )
            throw new IllegalArgumentException();

        if( null == sourceString )
            throw new IllegalArgumentException();

        if( number <= sourceString.length() )
            return sourceString.substring( sourceString.length() - number );

        return sourceString;
    }

    @Override
    public String left(String sourceString, String separator) throws IllegalArgumentException {

        checkForNullBothArguments(sourceString, separator);
        String[] foundStrings = sourceString.split( separator );

        if( foundStrings.length > 0 )
            return foundStrings[0];

        return null;
    }

    @Override
    public String right(String sourceString, String separator) throws IllegalArgumentException {

        checkForNullBothArguments(sourceString, separator);

        String[] foundStrings = sourceString.split( separator );
        if( foundStrings.length > 0 )
            return foundStrings[ foundStrings.length-1 ];

        return null;
    }

    @Override
    public String[] split(String sourceString, String split) throws IllegalArgumentException {

        checkForNullBothArguments( sourceString, split );
        return sourceString.split( split );
    }

    @Override
    public String join(String[] sourceCollection, String glue) throws IllegalArgumentException {

        checkForNullBothArguments( sourceCollection, glue );

        if( 0 ==sourceCollection.length  )
            return "";

        String value = sourceCollection[0];

        for (int i = 1; i < sourceCollection.length; i++) {
            value += ( glue + sourceCollection[i] );
        }

        return value;
    }

    // (null, null)
    private void checkForNullBothArguments(Object firstNumber, String secondNumber) throws IllegalArgumentException {
        if( null == firstNumber && null == secondNumber )
            throw new IllegalArgumentException();
    }

    // (" ", " ")
    private void checkForEmptyBothArguments(String firstNumber, String secondNumber) throws IllegalArgumentException {
        if( firstNumber.equals(" ") && secondNumber.equals(" ") )
            throw new IllegalArgumentException();
    }

}
