package com.epam.university.java.core.task002;

import com.epam.university.java.core.task001.*;

/**
 * Created by ilya on 02.09.17.
 */
public class StringNotNullChecker implements Checker {
    @Override
    public void check(String... strings) {
        if (strings == null) {
                throw new IllegalArgumentException("some string is null");
        }
        for (String checkingString :
                strings) {
            if (checkingString == null) {
                throw new IllegalArgumentException("some string is null");
            }
        }
    }
}
