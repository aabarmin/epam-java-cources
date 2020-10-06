package com.epam.university.java.core.task017;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Task017Impl implements Task017 {

    @Override
    public String formatString(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }
        String s = new String("You know " + args[0] + ", " + args[1] + "!");
        return s;
    }

    @Override
    public String formatNumbers(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(Locale.getDefault());
        symbol.setDecimalSeparator('.');
        DecimalFormat format1 = new DecimalFormat("#.0", symbol);
        DecimalFormat format2 = new DecimalFormat("#.00", symbol);
        DecimalFormat format3 = new DecimalFormat("+#.00", symbol);
        StringBuilder sb = new StringBuilder();
        sb.append(format1.format(args[0])).append(", ").append(format2.format(args[0])).append(", ")
                .append(format3.format(args[0])).append(", ")
                .append(Double.toHexString((Double) args[0]));
        return sb.toString();
    }

    @Override
    public String formatDates(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }
}
