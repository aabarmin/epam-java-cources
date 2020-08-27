package com.epam.university.java.core.task017;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Romin Nuro on 27.08.2020 22:18.
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
        return String
                .format(Locale.US, "%.1f, %.2f, %+.2f, %a", args[0], args[0], args[0], args[0]);
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatDates(Object... args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
