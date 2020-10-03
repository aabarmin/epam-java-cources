package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        if (dateEnd == null || dateStart == null) {
            throw new IllegalArgumentException();
        }
        return dateEnd.getDayOfYear() - dateStart.getDayOfYear();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        if (dateStart == null) {
            throw new IllegalArgumentException();
        }
        LocalDate plusDays = dateStart.plusDays(daysToAdd);
        return plusDays;
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        if (instantEnd == null || instantStart == null) {
            throw new IllegalArgumentException();
        }
        Duration between = Duration.between(instantStart, instantEnd);
        long seconds = between.getSeconds();
        return seconds;
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException();
        }
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        if (localDate == null) {
            throw new IllegalArgumentException();
        }
        TemporalAdjuster nextSat = TemporalAdjusters.next(DayOfWeek.SATURDAY);
        return localDate.with(nextSat);
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mma");
        return LocalTime.parse(timeString, dtf);
    }
}
