package com.epam.university.java.core.task030;

import com.epam.university.java.core.utils.common.Validator;

import java.time.Duration;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.temporal.TemporalAdjusters.next;


/**
 * Class implements Task030.
 */
public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int) dateStart.until(dateEnd, ChronoUnit.DAYS);
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
        return localDate.with(next(SATURDAY));
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        Validator.validateNotNull(timeString,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(
                "hh:mma");
        return LocalTime.parse(timeString, dateTimeFormatter);
    }
}