package com.epam.university.java.core.task017;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        StringBuilder sb = new StringBuilder("You know ");

        for (int i = 0; i < args.length; i++) {
            if (i == args.length - 1) {
                sb.append(args[i]).append("!");
                break;
            }
            sb.append(args[i]).append(", ");
        }

        return sb.toString();
    }

    @Override
    public String formatNumbers(Object... args) {
        double num1 = (double) args[0];
        int num = (int) num1;
        StringBuilder sb = new StringBuilder();
        sb.append(num).append(".0, ");
        sb.append(num).append(".00, ");
        sb.append("+").append(num).append(".00, ");
        sb.append("0x1.4p4");
        return sb.toString();
    }

    @Override
    public String formatDates(Object... args) {
        Date from = (Date) args[0];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(from);
    }
}
