package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        return String.format("You know %s, %s!", args[0], args[1]);
    }

    @Override
    public String formatNumbers(Object... args) {

        return String.format(Locale.ENGLISH, "%.1f, %<.2f, %<+.2f, %<#a", args[0]);
    }

    @Override
    public String formatDates(Object... args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
