package com.epam.university.java.core.task016;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task016Impl implements Task016 {
    public static void main(String[] args) {
        new Task016Impl().getSquaresInsideCircle(33);
    }

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        for (Locale locale : Locale.getAvailableLocales()) {
            System.out.println(locale.getDisplayCountry());
        }
        System.out.println();
        Locale localeTest = new Locale("ru","RU","");
        NumberFormat numberFormat=NumberFormat.getNumberInstance(new Locale("RU"));
        System.out.println(numberFormat.format(10000000));
        Matcher matcher = Pattern.compile("\\D").matcher("RU");
        System.out.println(matcher.find());
        System.out.println(Math.PI*Math.pow(10,2)/0.5
        );


        return null;
    }
}