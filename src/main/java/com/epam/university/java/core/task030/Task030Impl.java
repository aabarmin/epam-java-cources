package com.epam.university.java.core.task030;

import java.time.Period;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Duration;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Implementation class for Task030.
 *
 * @author Sergei Titov
 */
public class Task030Impl implements Task030 {

    /**
     * {@inheritDoc}
     */
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {

        return Period.between(
                dateStart,
                dateEnd).getDays();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {

        return dateStart.plusDays(daysToAdd);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {

        return Duration.between(instantStart, instantEnd).getSeconds();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {

        return localDate.getDayOfWeek();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {

        return localDate.with(
                TemporalAdjusters.next(DayOfWeek.SATURDAY));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalTime getLocalTime(String timeString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        return LocalTime.parse(timeString, formatter);
    }
}
