package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return dateEnd.getDayOfYear() - dateStart.getDayOfYear();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plus(daysToAdd, ChronoUnit.DAYS);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return instantEnd.getLong(ChronoField.INSTANT_SECONDS) - instantStart.getLong(ChronoField.INSTANT_SECONDS);
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        int daysToWeekend = 6 - localDate.getDayOfWeek().get(ChronoField.DAY_OF_WEEK);
        return localDate.plus(daysToWeekend, ChronoUnit.DAYS);
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("h:mma"));
    }
}
