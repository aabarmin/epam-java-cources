package com.epam.university.java.core.task017;

/**
 * {@inheritDoc}
 */
public class Task017Impl implements Task017 {
    /**
     * {@inheritDoc}
     */
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args[0], args[1]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatNumbers(Object... args) {
        return String.format("%.1f, %<.2f, %+<.2f, %<a", args[0]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String formatDates(Object... args) {
        return String.format("%tY.%<td.%<tm", args[0]);
    }
}
