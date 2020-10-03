package com.epam.university.java.core.task005;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task005Test {
    private Task005 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFinderWithoutArguments() throws Exception {
        instance.findPi(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFinderWithElevenDigit() throws Exception {
        instance.findPi(11);
    }

    @Test(timeout = 500L)
    public void testFinderWithOneDigit() throws Exception {
        final PiHolder holder = instance.findPi(1);
        assertEquals("First number incorrect", 3, holder.getFirst());
        assertEquals("Second number incorrect", 1, holder.getSecond());
    }

    @Test(timeout = 1000L)
    public void testFinderWithTwoDigit() throws Exception {
        final PiHolder holder = instance.findPi(2);
        assertEquals("First number incorrect", 44, holder.getFirst());
        assertEquals("Second number incorrect", 14, holder.getSecond());
    }

    @Test(timeout = 5000L)
    public void testFinderWithThreeDigit() throws Exception {
        final PiHolder holder = instance.findPi(3);
        assertEquals("First number incorrect", 355, holder.getFirst());
        assertEquals("Second number incorrect", 113, holder.getSecond());
    }

    @Test(timeout = 10000L)
    public void testFinderWithFourDigit() throws Exception {
        final PiHolder holder = instance.findPi(4);
        assertEquals("First number incorrect", 3195, holder.getFirst());
        assertEquals("Second number incorrect", 1017, holder.getSecond());
    }

    @Test(timeout = 15000L)
    public void testFinderWithFiveDigit() throws Exception {
        final PiHolder holder = instance.findPi(5);
        assertEquals("First number incorrect", 99733, holder.getFirst());
        assertEquals("Second number incorrect", 31746, holder.getSecond());
    }
}