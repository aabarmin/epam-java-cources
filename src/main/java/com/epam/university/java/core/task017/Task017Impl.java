package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        correctArgumentChecking(args);

        String s = "You know ";
        return (s + args[0] + ", " + args[1] + "!");
    }

    @Override
    public String formatNumbers(Object... args) {
        correctArgumentChecking(args);
        double d = (double) args[0];
        String s = ", ";
        String notFormatted = Double.toString(d);
        String toSecondSign = String.format(Locale.ENGLISH, "%.2f", d);
        String toSecondSignPos = String.format(Locale.ENGLISH, "%+.2f", d);
        String toHex = Double.toHexString(20d);

        return (notFormatted + s
                + toSecondSign + s
                + toSecondSignPos + s
                + toHex);
    }

    @Override
    public String formatDates(Object... args) {
        correctArgumentChecking(args);
        final Date currentDate = new Date();
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(currentDate);
    }

    /**
     * Checking for input param.
     * @param args input param.
     */
    public void correctArgumentChecking(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object arg : args) {
            if (arg == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
