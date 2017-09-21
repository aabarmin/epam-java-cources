package com.epam.university.java.core.task017;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Александр on 19.09.2017.
 */
public class Task017Impl implements Task017 {
    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args);
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatNumbers(Object... args) {
        Formatter formatter = new Formatter();
        Locale enLocale = new Locale("en");

        return String.format(enLocale,"%#,.1f, %<#.2f, %<#+.2f, %<a", args);
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatDates(Object... args) {
        return String.format("%tY.%<td.%<tm", args);
    }
}
