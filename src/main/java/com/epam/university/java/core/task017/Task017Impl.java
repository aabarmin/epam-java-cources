package com.epam.university.java.core.task017;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args);
    }

    @Override
    public String formatNumbers(Object... args) {
        //  "20.0, 20.00, +20.00, 0x1.4p4";
        return String.format(Locale.US, "%s, %<.2f, %<+.2f, %<a", args);
    }

    @Override
    public String formatDates(Object... args) {
        return String.format("%tY.%<td.%<tm", args);
    }
}
