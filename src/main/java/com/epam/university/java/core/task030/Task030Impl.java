package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * Created by ilya on 08.10.17.
 */
public class Task030Impl implements Task030 {

    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        LocalDate date = dateStart.plus(daysToAdd, ChronoUnit.DAYS);
        return date;
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return Duration.between(instantStart, instantEnd).getSeconds();
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        while (localDate.getDayOfWeek() != DayOfWeek.SATURDAY) {
            localDate = localDate.plus(1, ChronoUnit.DAYS);
        }
        return localDate;
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .appendPattern("hh:mma")
            .toFormatter(Locale.ENGLISH);

        LocalTime time = LocalTime.from(formatter.parse(timeString));

        return time;
    }
}
