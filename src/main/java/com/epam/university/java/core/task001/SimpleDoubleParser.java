package com.epam.university.java.core.task001;

/**
 * Created by ilya on 02.09.17.
 */
public class SimpleDoubleParser implements Parser {
    @Override
    public double parse(String number) {
        return Double.parseDouble(number);
    }
}
