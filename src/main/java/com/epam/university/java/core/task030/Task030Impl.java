package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Author Dmitry Novikov 09-Sep-20.
 */
public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        return dateEnd.getDayOfYear() - dateStart.getDayOfYear();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
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
        LocalDate res = localDate;
        while (!res.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
            res = res.plusDays(1);
        }
        return res;
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        String[] isDayOrNight = timeString.split("\\d.\\W..");
        String[] myStringArray = timeString.split("\\D");
        int hours = 0;
        if (isDayOrNight[1].equals("PM")) {
            hours = Integer.parseInt(myStringArray[0]) + 12;
        } else {
            hours = Integer.parseInt(myStringArray[0]);
        }

        int minutes = Integer.parseInt(myStringArray[1]);
        LocalTime lt = LocalTime.of(hours, minutes);
        return lt;
    }
}
