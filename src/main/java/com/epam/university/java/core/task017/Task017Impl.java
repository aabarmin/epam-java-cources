package com.epam.university.java.core.task017;

import com.epam.university.java.core.task003.NullChecker;
import com.epam.university.java.core.task003.SimpleNullChecker;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by ilya on 21.09.17.
 */
public class Task017Impl implements Task017 {

    @Override
    public String formatString(Object... args) {
        NullChecker checker = new SimpleNullChecker();
        checker.check(args);

        if (args.length != 2) {
            throw new IllegalArgumentException();
        }

        Formatter formatter = new Formatter();
        formatter.format("You know %s, %s!", args[0], args[1]);
        return formatter.toString();
    }

    @Override
    public String formatNumbers(Object... args) {
        NullChecker checker = new SimpleNullChecker();
        checker.check(args);

        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        Locale locale = Locale.ENGLISH;
        Formatter formatter = new Formatter(locale);

        formatter.format("%.1f, %<.2f, %<+.2f, %<#a", args[0]);

        return formatter.toString();
    }

    @Override
    public String formatDates(Object... args) {
        NullChecker checker = new SimpleNullChecker();
        checker.check(args);

        if (args.length != 1) {
            throw new IllegalArgumentException();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");

        return dateFormat.format(args[0]);
    }
}
