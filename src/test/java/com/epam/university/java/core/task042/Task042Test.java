package com.epam.university.java.core.task042;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task042Test {
    private Task042 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAvailabilityWithNullList() throws Exception {
        final List<String> schedule = null;
        final String currentTime = "11:00";
        instance.checkAvailability(schedule, currentTime);
    }

    @Test
    public void checkAvailabilityWithEmptyListFirst() throws Exception {
        final List<String> schedule = new ArrayList<>();
        final String currentTime = "11:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof AvailableResponse
        );
    }

    @Test
    public void checkAvailabilityWithEmptyListSecond() throws Exception {
        final List<String> schedule = new ArrayList<>();
        final String currentTime = "06:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof TimeProposalResponse
        );
        assertEquals("Error in test checkAvailabilityWithEmptyListSecond",
                "09:00",
                ((TimeProposalResponse) availability).getProposedTime()
        );
    }

    @Test
    public void checkAvailabilityWithEmptyListThird() throws Exception {
        final List<String> schedule = new ArrayList<>();
        final String currentTime = "18:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof BusyResponse
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkAvailabilityWithNullString() throws Exception {
        final List<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "12:20-15:50"
        ));
        final String currentTime = null;
        instance.checkAvailability(schedule, currentTime);
    }

    @Test
    public void checkAvailabilityFirst() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "12:20-15:50"
        ));
        final String currentTime = "11:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof AvailableResponse
        );
    }

    @Test
    public void checkAvailabilitySecond() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "12:20-15:50"
        ));
        final String currentTime = "10:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof TimeProposalResponse
        );
        assertEquals("Error in test checkAvailabilitySecond",
                "10:15",
                ((TimeProposalResponse) availability).getProposedTime()
        );
    }

    @Test
    public void checkAvailabilityThird() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "12:20-19:00"
        ));
        final String currentTime = "13:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof BusyResponse
        );
    }

    @Test
    public void checkAvailabilityForth() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "12:20-15:50"
        ));
        final String currentTime = "06:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof TimeProposalResponse
        );
        assertEquals("Error in test checkAvailabilityForth",
                "09:00",
                ((TimeProposalResponse) availability).getProposedTime()
        );
    }

    @Test
    public void checkAvailabilityFifth() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:30-10:15",
                "10:15-15:15",
                "15:15-16:15",
                "16:15-17:00"
        ));
        final String currentTime = "10:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof TimeProposalResponse
        );
        assertEquals("Error in test checkAvailabilityFifth",
                "17:00",
                ((TimeProposalResponse) availability).getProposedTime()
        );
    }

    @Test
    public void checkAvailabilitySixth() throws Exception {
        final ArrayList<String> schedule = new ArrayList<>(Arrays.asList(
                "09:00-10:15",
                "10:15-15:15",
                "15:15-16:15",
                "16:15-18:00"
        ));
        final String currentTime = "09:00";
        final BookingResponse availability = instance.checkAvailability(schedule, currentTime);
        assertTrue(
                "Incorrect type of exception",
                availability instanceof BusyResponse
        );
    }
}
