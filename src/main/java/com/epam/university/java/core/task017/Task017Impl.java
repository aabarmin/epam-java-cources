package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
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
        /*
          final String resultString = instance.formatNumbers(20d);
        assertEquals("Numbers formatted incorrectly",
                "20.0, 20.00, +20.00, 0x1.4p4",
         */
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        Date date = (Date) args[0];
        return dateFormat.format(date);
    }
}
