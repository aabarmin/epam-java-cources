package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!",args);
    }

    @Override
    public String formatNumbers(Object... args) {
        return String.format(new Locale("en","CA"),"%1.1f, %<1.2f, +%<1.2f, %<a",args);
    }

    @Override
    public String formatDates(Object... args) {
        return String.format("%tY.%<td.%<tm",args);
    }
}
