package com.epam.university.java.core.task046;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task050.Task050;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Task050Test {
    private Task050 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task046.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithZeroSize() throws Exception {
        instance.calculate(0, new HashMap<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateWithNull() throws Exception {
        instance.calculate(1, null);
    }

    @Test
    public void calculate1() {
        final Double expected = 180.000;
        final Double result = instance.calculate(50,
                Map.of(
                        60.0, 20.0,
                        100.0, 50.0,
                        120.0, 30.0
                ));
        assertEquals("Incorrect encoding", expected, result);
    }

    @Test
    public void calculate2() {
        final Double expected = 500.0;
        final Double result = instance.calculate(1000,
                Map.of(
                        500.0, 30.0
                ));
        assertEquals("Incorrect encoding", expected, result);
    }

    @Test
    public void calculate3() {
        final Double expected = 7777.731;
        final Double result = instance.calculate(9022,
                Map.of(
                        3316.0, 1601.0,
                        5375.0, 8940.0,
                        2852.0, 6912.0,
                        3336.0, 9926.0,
                        1717.0, 8427.0
                ));
        assertEquals("Incorrect encoding", expected, result);
    }
}