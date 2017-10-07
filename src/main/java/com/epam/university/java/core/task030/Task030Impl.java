package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.Locale;

/**
 * {@inheritDic}
 */
public class Task030Impl implements Task030 {

    /**
     * {@inheritDic}
     */
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {

        Period between = Period.between(dateStart, dateEnd);
        return (int) between.get(ChronoUnit.DAYS);
    }

    /**
     * {@inheritDic}
     */
    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        LocalDate plus = dateStart.plus(Period.of(0, 0, daysToAdd));
        return plus;
    }

    /**
     * {@inheritDic}
     */
    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {

        return instantEnd.getEpochSecond() - instantStart.getEpochSecond();
    }

    /**
     * {@inheritDic}
     */
    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek;
    }

    /**
     * {@inheritDic}
     */
    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        LocalDate weekEnd = localDate;
        while (true) {
            weekEnd = weekEnd.plus(1, ChronoUnit.DAYS);
            if (weekEnd.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                break;
            }
        }
        return weekEnd;
    }

    /**
     * {@inheritDic}
     */
    @Override
    public LocalTime getLocalTime(String timeString) {
        LocalTime localTime = LocalTime.parse(timeString,
                DateTimeFormatter.ofPattern("hh:mma"));
        return localTime;
    }
}
