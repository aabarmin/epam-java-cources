package com.epam.university.java.core.task003;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        return new String[0];
    }

    @Override
    public String[] join(String[] first, String[] second) {
        return new String[0];
    }

    @Override
    public int findMax(int[] source) {
        return 0;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        return new String[0];
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        return new String[0];
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        return new String[0];
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) throws IllegalArgumentException {
        checkForNullBothArguments( source, operation );
        return new String[0];
    }


    // (null, null)
    private void checkForNullBothArguments(Object firstNumber, Object secondNumber) throws IllegalArgumentException {
        if( null == firstNumber && null == secondNumber )
            throw new IllegalArgumentException();
    }

    // (" ", " ")
    private void checkForEmptyBothArguments(String firstNumber, String secondNumber) throws IllegalArgumentException {
        if( firstNumber.equals(" ") && secondNumber.equals(" ") )
            throw new IllegalArgumentException();
    }

}
