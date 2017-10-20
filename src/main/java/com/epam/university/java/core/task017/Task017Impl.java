package com.epam.university.java.core.task017;

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

public class Task017Impl implements Task017 {

    @Override
    public String formatString(Object... args) {
        Formatter formatter = new Formatter().format("You know %s, %s!", args[0], args[1]);
        return formatter.toString();
    }

    @Override
    public String formatNumbers(Object... args) {
        Formatter formatter = new Formatter().format(Locale.CANADA,
                "%.1f, %<.2f, %<+.2f, %<.1a", args[0]);
        return formatter.toString();
    }

    @Override
    public String formatDates(Object... args) {
        Formatter formatter = new Formatter().format("%tY.%td.%tm", args[0], args[0], args[0]);
        return formatter.toString();
    }
}
