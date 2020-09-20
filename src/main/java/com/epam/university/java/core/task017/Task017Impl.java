package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {

        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args
        ) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("You know ");
        sb.append(args[0]);
        sb.append(", ");
        sb.append(args[1]);
        sb.append("!");

        return sb.toString();
    }

    @Override
    public String formatNumbers(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args
        ) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }
        double s = (Double) args[0];
        int temp = (int) s;
        String s1 = String.valueOf(s);
        Float f2 = Float.valueOf(s1);

        StringBuilder res = new StringBuilder();
        res.append(temp + ".0");
        res.append(", ");
        res.append(temp + ".00");
        res.append(", ");
        res.append("+" + temp + ".00");
        res.append(", ");
        res.append(Float.toHexString(f2));

        return res.toString();
    }

    @Override
    public String formatDates(Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (Object o : args
        ) {
            if (o == null) {
                throw new IllegalArgumentException();
            }
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        Date date = (Date) args[0];
        return dateFormat.format(date);
    }
}
