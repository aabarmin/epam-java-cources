package com.epam.university.java.core.task030;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class Task030Test {
    private Task030 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task030.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullDates() throws Exception {
        instance.daysBetweenDates(null, null);
    }

    @Test
    public void testDistance() throws Exception {
        final LocalDate localDate = LocalDate.now();
        final LocalDate nextDate = localDate.plus(1, ChronoUnit.DAYS);
        assertEquals("Incorrect distance calculation",
                1,
                instance.daysBetweenDates(localDate, nextDate)
        );
    }

    @Test
    public void testAdjustment() throws Exception {
        final LocalDate localDate = LocalDate.now();
        final LocalDate targetDate = localDate.plus(2, ChronoUnit.DAYS);
        assertEquals("Incorrect date adjustment",
                targetDate,
                instance.adjustDays(localDate, 2)
        );
    }

    @Test
    public void testDayOfWeek() throws Exception {
        final LocalDate localDate = LocalDate.of(2017, 10, 4);
        assertEquals("Incorrect day of week calculation",
                DayOfWeek.WEDNESDAY,
                instance.getDayOfWeek(localDate)
        );
    }

    @Test
    public void testGetLocalTime1() throws Exception {
        final LocalTime localTime = LocalTime.of(10, 15);
        assertEquals("Incorrect local time calculation",
                localTime,
                instance.getLocalTime("10:15AM")
        );
    }

    @Test
    public void testGetLocalTime2() throws Exception {
        final LocalTime localTime = LocalTime.of(22, 15);
        assertEquals("Incorrect local time calculation",
                localTime,
                instance.getLocalTime("10:15PM")
        );
    }

    @Test
    public void testTemporalQuery() throws Exception {
        final LocalDate localDate = LocalDate.of(2017, 10, 4);
        final LocalDate nextWeekend = LocalDate.of(2017, 10, 7);
        assertEquals("Incorrect weekend calculation",
                nextWeekend,
                instance.getNextWeekend(localDate)
        );
    }

    @Test
    public void testDuration() throws Exception {
        final Instant now = Instant.now();
        final Instant instantEnd = now.plus(300, ChronoUnit.HOURS);
        assertEquals("Incorrect duration calculation",
                300 * 60 * 60,
                instance.distanceBetween(now, instantEnd)
        );
    }
}