package com.epam.university.java.core.task017;

import java.util.Formatter;
import java.util.Locale;

/**
 * Created by Вера on 24.09.2017.
 */
public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        String s = String.format("You know " + "%s" + ", " + "%s" + "!",
                args[0], args[1]);
        //System.out.println(s);
        return s;
    }

    @Override
    public String formatNumbers(Object... args) {

        Formatter formatter = new Formatter();
        formatter.format(Locale.ROOT, "%.1f, %<.2f, %<+.2f, %<a", args[0]);
        //System.out.println(formatter.toString());

        return formatter.toString();
    }

    @Override
    public String formatDates(Object... args) {
        Formatter formatter = new Formatter();
        formatter.format(("%tY.%<td.%<tm"), args[0]);
        //System.out.println(formatter);
        return formatter.toString();
    }
}
