package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plus(daysToAdd, ChronoUnit.DAYS);
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
        LocalTime time = LocalTime.parse(timeString.substring(0,5));
        if (timeString.contains("PM")) {
            return time.withHour(time.getHour() + 12);
        }
        return time;
    }
}
