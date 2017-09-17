package com.epam.university.java.core.validations;

/**
 * Created by Dremina on 02.09.2017.
 */
public class CheckArgument {

    public static void validateValue(String value){
        validateNullValue(value);
        if (value.trim().equals("")){
            throw  new IllegalArgumentException();
        }
    }

    public static void validateNullValue(Object value){
        if (value == null){
            throw new IllegalArgumentException();
        }
    }

    public static void notNegative(int number){
        if (number < 0 ){
            throw new IllegalArgumentException();
        }
    }

    public static void moreThanTen(int number){
        if (number > 10 ){
            throw new IllegalArgumentException();
        }
    }
    public static void notNull(int number){
        if (number == 0){
            throw new IllegalArgumentException();
        }
    }


}
