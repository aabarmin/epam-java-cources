package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Created by Александр on 08.10.2017.
 * Date time API.
 */
public class Task030Impl implements Task030 {
    /**
     * Get amount of days between two dates.
     *
     * @param dateStart first date
     * @param dateEnd   second date
     * @return amount of days
     */
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return (int)Duration.between(dateStart.atStartOfDay(), dateEnd.atStartOfDay()).toDays();
    }

    /**
     * Add designated amount of days to <code>dateStart</code>.
     *
     * @param dateStart date to adjust
     * @param daysToAdd amount of days to add
     * @return adjusted date
     */
    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
    }

    /**
     * Get amount of seconds between two instants.
     *
     * @param instantStart first instant
     * @param instantEnd   second instant
     * @return amount of seconds
     */
    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return Duration.between(instantStart, instantEnd).getSeconds();
    }

    /**
     * Get day of week of the given date.
     *
     * @param localDate date to check
     * @return day of week
     */
    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    /**
     * Calculate date of the nearest weekend start.
     *
     * @param localDate date to start
     * @return weekend start date
     */
    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        if ((localDate.getDayOfWeek() == DayOfWeek.SATURDAY)
                || (localDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
            return localDate;
        } else {
            return localDate.plusDays(DayOfWeek.SATURDAY.getValue()
                    - localDate.getDayOfWeek().getValue());
        }
    }

    /**
     * Get local time from given string.
     *
     * @param timeString string with time
     * @return local time
     */
    @Override
    public LocalTime getLocalTime(String timeString) {

        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("hh:mma"));
    }
}
