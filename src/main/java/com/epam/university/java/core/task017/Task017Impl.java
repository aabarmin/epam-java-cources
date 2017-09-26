package com.epam.university.java.core.task017;


import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 * Implementation class for Task017.
 *
 * @author Sergei Titov
 */
public class Task017Impl implements Task017 {

    final Formatter formatter;

    /**
     * Default constructor.
     */
    public Task017Impl() {
        formatter = new Formatter(new Locale("us-US"));
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public String formatString(Object... args) {
        return formatter.format(
                "You know %s, %s!",
                args[0],
                args[1]).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatNumbers(Object... args) {
        return formatter.format(
                "%1$.1f, %1$.2f, +%1$.2f, %1$a",
                args[0]).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatDates(Object... args) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
