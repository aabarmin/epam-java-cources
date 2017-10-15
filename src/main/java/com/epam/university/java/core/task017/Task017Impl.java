package com.epam.university.java.core.task017;

import com.epam.university.java.core.Validator;

import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

public class Task017Impl implements Task017 {
    private Validator validator = Validator.getInstance();

    @Override
    public String formatString(Object... args) {
        validator.validate(args);
        return String.format("You know %s, %s!", args);
    }

    @Override
    public String formatNumbers(Object... args) {
        validator.validate(args);
        final Locale locale = Locale.ENGLISH;
        final Formatter formatter = new Formatter(locale);

        formatter.format("%.1f, %<.2f, %<+.2f, %<#a", args);
        return formatter.toString();
    }

    @Override
    public String formatDates(Object... args) {
        validator.validate(args);
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
