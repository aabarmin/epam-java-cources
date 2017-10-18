package com.epam.university.java.core.task030;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        Period period = Period.between(dateStart, dateEnd);
        long days = period.get(ChronoUnit.DAYS);
        return (int) days;

    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plus(daysToAdd, ChronoUnit.DAYS);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return Duration.between(instantStart, instantEnd).get(ChronoUnit.SECONDS);
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();

    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));


    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("K:ma");
        LocalTime localTime = LocalTime.parse(timeString, formatter);

        return localTime;
    }
}
