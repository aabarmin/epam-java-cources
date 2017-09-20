package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Formatting.
 */
public class Task017Impl implements Task017 {

    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatString(Object... args) {
        if (args == null || args.length < 2) {
            throw new IllegalArgumentException("Expected at least two arguments");
        }
        final String pattern = "You know %s, %s!"; // hard coded part, yeah
        return String.format(pattern, args);
    }

    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatNumbers(Object... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Expected at least one argument");
        }
        final String pattern = "%1$.1f, %1$.2f, %1$+.2f, %1$a";
        return String.format(Locale.US, pattern, args);
    }

    /**
     * Output objects as formatted string.
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatDates(Object... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("Expected at least one argument");
        }
        final String pattern = "yyyy.dd.MM";
        return new SimpleDateFormat(pattern).format(args[0]);
    }

}
