package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plus(2, ChronoUnit.DAYS);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return instantEnd.getEpochSecond() - instantStart.getEpochSecond();
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return DayOfWeek.from(localDate);
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        return localDate.plusDays(localDate.getDayOfMonth() - 1);
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("hh:mma", Locale.US));
    }
}
