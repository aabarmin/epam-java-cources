package com.epam.university.java.core.task017;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        if (args.length != 2 || args == null) {
            throw new IllegalArgumentException("Two arguments are required!");
        }
        return String.format("You know %s, %s!", args);
    }

    @Override
    public String formatNumbers(Object... args) {
        if (args.length != 1 || args == null) {
            throw new IllegalArgumentException("One argument are required!");
        }
        return String.format("%.1f, %<.2f, %+<.2f, %<a", args);
    }

    @Override
    public String formatDates(Object... args) {
        if (args.length != 1 || args == null) {
            throw new IllegalArgumentException("One argument are required!");
        }
        return String.format("%tY.%<td.%<tm", args);
    }
}