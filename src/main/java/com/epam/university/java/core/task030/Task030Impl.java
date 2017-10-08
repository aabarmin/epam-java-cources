package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;


public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int) Duration.between(dateStart.atStartOfDay(), dateEnd.atStartOfDay()).toDays();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
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
        return localDate.with(DayOfWeek.SATURDAY);
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mma");
        TemporalAccessor temporalAccessor = timeFormatter.parse(timeString);
        return LocalTime.from(temporalAccessor);
    }
}
