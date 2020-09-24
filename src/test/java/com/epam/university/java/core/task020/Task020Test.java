package com.epam.university.java.core.task020;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task020Test {
    private Task020 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task020.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullList() throws Exception {
        instance.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyList() throws Exception {
        instance.calculate(Collections.emptyList());
    }

    @Test
    public void noCommonParts() throws Exception {
        final List<String> parts = Arrays.asList(
                "abc",
                "cde",
                "efg"
        );
        assertEquals("There are no common parts",
                0,
                instance.calculate(parts)
        );
    }

    @Test
    public void onlyOneCommonPart() throws Exception {
        final List<String> parts = Arrays.asList(
                "abc",
                "bcd",
                "cde"
        );
        assertEquals("There is only one common part",
                1,
                instance.calculate(parts)
        );
    }

    @Test
    public void twoCommonParts() throws Exception {
        final List<String> parts = Arrays.asList(
                "abcd",
                "bcde",
                "cdef"
        );
        assertEquals("There are two common parts",
                2,
                instance.calculate(parts)
        );
    }

    @Test
    public void threeCommonParts() throws Exception {
        final List<String> parts = Arrays.asList(
                "aabcd",
                "bcdea",
                "cdefa"
        );
        assertEquals("There are three common parts",
                3,
                instance.calculate(parts)
        );
    }
}