package com.epam.university.java.core.task068;

//import com.epam.university.java.core.helper.TestHelper;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task068Test {
    Task068 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task068.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputIsNull() throws Exception {
        instance.countOfRatios(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputContainsNulls() throws Exception {
        instance.countOfRatios(new ArrayList<>(Arrays.asList(1, null, 4)));
    }

    @Test
    public void first() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 1, 0, -1, -1));
        List<Double> expect = new ArrayList<>(Arrays.asList(0.4, 0.4, 0.2));

        assertEquals("Invalid result", expect, instance.countOfRatios(input));
    }

    @Test
    public void second() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, -2, -7, 9, 1, -8, -5));
        List<Double> expect = new ArrayList<>(Arrays.asList(0.42857142857142855, 0.5714285714285714, 0.0));

        assertEquals("Invalid result", expect, instance.countOfRatios(input));
    }

    @Test
    public void third() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        List<Double> expect = new ArrayList<>(Arrays.asList(0.0, 0.0, 1.0));

        assertEquals("Invalid result", expect, instance.countOfRatios(input));
    }

}