package com.epam.university.java.core.task017;

import com.epam.university.java.core.Validator;

import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        Validator validator = new Validator();
        validator.vaildate(args);
        return String.format("You know %s, %s!", args);
    }

    @Override
    public String formatNumbers(Object... args) {
        Validator validator = new Validator();
        validator.vaildate(args);
        Locale locale = Locale.ENGLISH;
        Formatter formatter = new Formatter(locale);

        formatter.format("%.1f, %<.2f, %<+.2f, %<#a", args);
        return formatter.toString();
    }

    @Override
    public String formatDates(Object... args) {
        Validator validator = new Validator();
        validator.vaildate(args);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
