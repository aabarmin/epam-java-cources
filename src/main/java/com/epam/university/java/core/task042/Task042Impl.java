package com.epam.university.java.core.task042;

import java.time.LocalTime;
import java.util.List;

/**
 * Author Dmitry Novikov 19-Sep-20.
 */
public class Task042Impl implements Task042 {
    private final LocalTime startDay = LocalTime.of(9, 00);
    private final LocalTime endDay = LocalTime.of(18, 00);

    /**
     * <p>
     * Alexander is a businessman. He wants to implement an automatic system informing
     * that he's currently unavailable and the time when he's going to get back to the
     * office. Alexander works from 09:00 to 18:00.
     * </p>
     * <p>
     * There are three implementations of BookingResponse interface that describes
     * Alexander's availability.
     * </p>
     * <p>
     * Given a list with a schedule for a given day. List's elements consist start and
     * finish time of a given appointment in "hh:mm-hh:mm" 24-h format. And given a current
     * time in "hh:mm" 24-h format. If no appointments are scheduled for current time,
     * the function should return AvailableResponse instance. If Alexander is in the middle
     * of an appointment at current time, the function should return TimeProposalResponse
     * instance with the time he's going to be available. If Alexandr has no free time today,
     * the function should return BusyResponse instance.
     * </p>
     * <p>
     * Example: schedule ["09:30-10:15", "12:20-15:50"], currentTime "11:00",
     * result is AvailableResponse instance
     * Example: schedule ["09:30-10:15", "12:20-15:50"], currentTime "10:00",
     * result is TimeProposalResponse instance with proposed time "10:15"
     * Example: schedule ["09:30-10:15", "12:20-19:00"], currentTime "13:00",
     * result is BusyResponse instance
     * </p>
     *
     * @param schedule    list with a schedule for a given day
     * @param currentTime current time
     * @return availability
     */
    @Override
    public BookingResponse checkAvailability(List<String> schedule, String currentTime) {
        if (schedule == null || currentTime == null) {
            throw new IllegalArgumentException();
        }

        LocalTime timeToTest = LocalTime.parse(currentTime.substring(0, 5));

        LocalTime temp = timeToTest.compareTo(startDay) >= 0
                ? timeToTest : startDay;

        if (schedule.size() == 0) {
            return getAnswer(temp, timeToTest);
        }

        for (String each : schedule) {
            LocalTime start = LocalTime.parse(each.substring(0, 5));
            LocalTime end = LocalTime.parse(each.substring(6, 11));

            if (temp.compareTo(end) < 0 && temp.compareTo(start) >= 0) {
                temp = end;
            }
        }

        return getAnswer(temp, timeToTest);
    }

    /**
     * Separate method that help to get answer.
     *
     * @param temp             temp time
     * @param currentLocalTime current time
     * @return answer
     */
    public BookingResponse getAnswer(LocalTime temp, LocalTime currentLocalTime) {
        if (temp.compareTo(endDay) < 0 && temp.compareTo(currentLocalTime) == 0) {
            return new AvailableResponse();
        } else if (temp.compareTo(endDay) < 0) {
            TimeProposalResponse tempClass = new TimeProposalResponse();
            tempClass.setProposedTime(temp.toString());
            return tempClass;
        } else {
            return new BusyResponse();
        }
    }
}