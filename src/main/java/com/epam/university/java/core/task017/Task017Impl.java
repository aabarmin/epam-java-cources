package com.epam.university.java.core.task017;

import java.util.Locale;

public class Task017Impl implements Task017 {
    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args[0], args[1]);
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatNumbers(Object... args) {
        return String.format(Locale.ROOT,
                "%.1f, %<.2f, %<+.2f, %s",
                args[0],
                Double.toHexString(Double.parseDouble(args[0].toString())));
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatDates(Object... args) {
        return String.format("%tY.%<td.%<tm", args[0]);
    }
}
