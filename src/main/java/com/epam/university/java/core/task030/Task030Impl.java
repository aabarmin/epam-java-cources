package com.epam.university.java.core.task030;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.Instant;
import java.time.DayOfWeek;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task030Impl implements Task030 {

    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        if (dateStart == null || dateEnd == null) {
            throw new IllegalArgumentException();
        }
        Period period = Period.between(dateStart, dateEnd);
        return period.getDays();
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        Duration duration = Duration.between(instantStart, instantEnd);
        return duration.toSeconds();
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        DayOfWeek day;

        do {
            localDate = localDate.plusDays(1);
            day = localDate.getDayOfWeek();
        } while (!day.equals(DayOfWeek.SATURDAY) && !day.equals(DayOfWeek.SUNDAY));
        return localDate;
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        Pattern pattern = Pattern.compile("\\d{2}");
        Matcher matcher = pattern.matcher(timeString);
        String[] timeNums = new String[2];
        int index = 0;
        while (matcher.find()) {
            timeNums[index] = timeString.substring(matcher.start(), matcher.end());
            index++;
        }
        LocalTime time;
        if (timeString.endsWith("AM")) {
            time = LocalTime.of(Integer.parseInt(timeNums[0]), Integer.parseInt(timeNums[1]));
        } else {
            time = LocalTime.of(Integer.parseInt(timeNums[0]) + 12, Integer.parseInt(timeNums[1]));
        }
        return time;
    }
}
