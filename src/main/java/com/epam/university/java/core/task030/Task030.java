package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Date time API.
 */
public interface Task030 {
    /**
     * Get amount of days between two dates.
     * @param dateStart first date
     * @param dateEnd second date
     * @return amount of days
     */
    int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd);

    /**
     * Add designated amount of days to <code>dateStart</code>.
     * @param dateStart date to adjust
     * @param daysToAdd amount of days to add
     * @return adjusted date
     */
    LocalDate adjustDays(LocalDate dateStart, int daysToAdd);

    /**
     * Get amount of seconds between two instants.
     * @param instantStart first instant
     * @param instantEnd second instant
     * @return amount of seconds
     */
    long distanceBetween(Instant instantStart, Instant instantEnd);

    /**
     * Get day of week of the given date.
     * @param localDate date to check
     * @return day of week
     */
    DayOfWeek getDayOfWeek(LocalDate localDate);

    /**
     * Calculate date of the nearest weekend start.
     * @param localDate date to start
     * @return weekend start date
     */
    LocalDate getNextWeekend(LocalDate localDate);

    /**
     * Get local time from given string.
     * @param timeString string with time
     * @return local time
     */
    LocalTime getLocalTime(String timeString);
}
