package com.epam.university.java.core.task030;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by Вера on 10.10.2017.
 */
public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {

        return dateEnd.getDayOfMonth() - dateStart.getDayOfMonth();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        LocalDate nextDate = dateStart.plusDays(daysToAdd);

        return nextDate;
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {

        return instantEnd.getEpochSecond() - instantStart.getEpochSecond();
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {

        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        int dayOfWeek = localDate.getDayOfWeek().getValue();
        if (dayOfWeek == 7) {
            return localDate.plusDays(6);
        } else if (dayOfWeek == 6) {
            return localDate.plusDays(7);
        } else {
            return localDate.plusDays(6 - dayOfWeek);
        }
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:ma");
        LocalTime localTime = LocalTime.parse(timeString, formatter);

        return localTime;
    }
}
