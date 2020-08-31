package com.epam.university.java.core.task017;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        return "You know " + args[0] + ", " + args[1] + "!";
    }

    @Override
    public String formatNumbers(Object... args) {
        Locale.setDefault(Locale.US);
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        double num = Double.parseDouble(String.valueOf(args[0]));
        BigDecimal bd = new BigDecimal(num);

        String buff = String.format("%.1f", num) +
                ", " +
                String.format("%1$,.2f", num) +
                ", " +
                (bd.signum() > 0 ? "+" : "-") +
                String.format("%1$,.2f", num) +
                ", " +
                Double.toHexString(num);
        return buff;
    }

    @Override
    public String formatDates(Object... args) {
        if (args.length == 0 || args[0] == null) {
            throw new IllegalArgumentException();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
