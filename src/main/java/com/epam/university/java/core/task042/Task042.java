package com.epam.university.java.core.task042;

import java.util.List;

/**
 * Time and schedule.
 */
public interface Task042 {
    /**
     * Alexander is a businessman. He wants to implement a system that will send
     * an automatic message informing that's he's currently unavailable and the time
     * when he's going to get back to the office. Alexandr works from 09:00 to 18:00.
     *
     * Given a list with a schedule for a given day. List's elements consist start and
     * finish time of a given appointment in "hh:mm-hh:mm" 24-h format. And given a current
     * time in "hh:mm" 24-h format. If no appointments are scheduled for current time,
     * the function should return "available". If Alexander is in the middle of an appointment
     * at current time, the function should return a string with the time he's going to be
     * available. If Alexandr has no free time today, the function should return "not available
     * today".
     *
     * <p>
     *     Example: schedule ["09:30-10:15", "12:20-15:50"], currentTime "11:00",
     *     result is "available"
     *     Example: schedule ["09:30-10:15", "12:20-15:50"], currentTime "10:00",
     *     result is "10:15"
     *     Example: schedule ["09:30-10:15", "12:20-19:00"], currentTime "13:00",
     *     result is "not available today"
     * </p>
     *
     * @param schedule list with a schedule for a given day
     * @param currentTime current time
     * @return availability string
     */
    String checkAvailability(List<String> schedule, String currentTime);
}
