package com.epam.university.java.core.task017;

import java.util.Locale;

public class Task017Impl implements Task017 {

    @Override
    public String formatString(Object... args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Expected at least two arguments");
        }
        final String format = "You know %s, %s!";
        return String.format(format, args);
    }

    @Override
    public String formatNumbers(Object... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Expected at least one argument");
        }
        final String format = "%1$.1f, %1$.2f, %1$+.2f, %1$a";
        return String.format(Locale.KOREA, format, args);
    }

    @Override
    public String formatDates(Object... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Expected at least one argument");
        }
        final String format = "%1$tY.%1$td.%1$tm";
        return String.format(format, args);
    }
}