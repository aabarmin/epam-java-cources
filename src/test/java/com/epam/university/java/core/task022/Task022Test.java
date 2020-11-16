package com.epam.university.java.core.task022;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task022Test {
    private Task022 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task022.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullList() throws Exception {
        instance.maxSum(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyList() throws Exception {
        instance.maxSum(Collections.emptyList());
    }

    @Test
    public void test1() throws Exception {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(
                "Maximum value is incorrect",
                14,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                10,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test2() throws Exception {
        final List<Integer> numbers = Arrays.asList(0, 0, 0, 0, 1);
        assertEquals(
                "Maximum value is incorrect",
                1,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                0,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test003() throws Exception {
        final List<Integer> numbers = Arrays.asList(10, 8, 6, 4, 2);
        assertEquals(
                "Maximum value is incorrect",
                28,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                20,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test004() throws Exception {
        final List<Integer> numbers = Arrays.asList(10, 8, 6, 4, 2, -10);
        assertEquals(
                "Maximum value is incorrect",
                30,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                10,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test005() throws Exception {
        final List<Integer> numbers = Arrays.asList(0, 0, 0, -10);
        assertEquals(
                "Maximum value is incorrect",
                0,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                -10,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test006() throws Exception {
        final List<Integer> numbers = Arrays.asList(-1, -3, -7, -10);
        assertEquals(
                "Maximum value is incorrect",
                -11,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                -20,
                instance.minSum(numbers)
        );
    }

    @Test
    public void test007() throws Exception {
        final List<Integer> numbers = Arrays.asList(-1, -1, 1, -1, 1, 1);
        assertEquals(
                "Maximum value is incorrect",
                1,
                instance.maxSum(numbers)
        );
        assertEquals(
                "Minimum value in incorrect",
                -1,
                instance.minSum(numbers)
        );
    }
}