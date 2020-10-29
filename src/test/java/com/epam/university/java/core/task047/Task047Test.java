package com.epam.university.java.core.task047;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task047Test {
    private Task047 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task047.class);
    }

    @Test
    public void firstTest() throws Exception {
        final long result = 2;
        final int[] a = new int[] {2, 3, 9, 2, 9};
        final int n = 5;
        assertEquals(
                "Invalid number of inversions",
                result,
                instance.calculateInversions(n, a)
        );
    }

    @Test
    public void secondTest() throws Exception {
        final long result = 21;
        final int[] a = new int[] {7, 6, 5, 4, 3, 2, 1};
        final int n = 7;
        assertEquals(
                "Invalid number of inversions",
                result,
                instance.calculateInversions(n, a)
        );
    }

    @Test
    public void thirdTest() throws Exception {
        final long result = 1;
        final int[] a = new int[] {1, 2, 3, 5, 4};
        final int n = 5;
        assertEquals(
                "Invalid number of inversions",
                result,
                instance.calculateInversions(n, a)
        );
    }

    @Test
    public void fourthTest() throws Exception {
        final long result = 15;
        final int[] a = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 3, 4, 3};
        final int n = 11;
        assertEquals(
                "Invalid number of inversions",
                result,
                instance.calculateInversions(n, a)
        );
    }

}
