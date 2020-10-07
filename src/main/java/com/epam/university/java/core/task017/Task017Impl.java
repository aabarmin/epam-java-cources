package com.epam.university.java.core.task017;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Task017Impl implements Task017 {
    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatString(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        return "You know " + args[0] + ", " + args[1] + "!";
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatNumbers(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String first;
        String second;
        String third;
        String fourth;
        for (int i = 0; i < args.length; i++) {
            first = String.format(Locale.US, "%.1f", args[i]);
            second = String.format(Locale.US, "%.2f", args[i]);
            third = String.format(Locale.US, "+%.2f", args[i]);
            fourth = Double.toHexString((double) args[i]);
            stringBuilder.append(first + ", " + second + ", " + third + ", " + fourth);
        }

        return stringBuilder.toString();
    }

    /**
     * Output objects as formatted string.
     *
     * @param args objects to output
     * @return formatted string
     */
    @Override
    public String formatDates(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            String pattern = "yyyy.dd.MM";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            stringBuilder.append(date);
        }
        return stringBuilder.toString();
    }
}
