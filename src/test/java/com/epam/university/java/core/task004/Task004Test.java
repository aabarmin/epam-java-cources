package com.epam.university.java.core.task004;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Task004Test {
    private Task004 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIntersectionWithoutArguments() throws Exception {
        instance.intersection(null, null);
    }

    @Test
    public void testIntersectionFirst() throws Exception {
        final String[] first = {
                "One",
                "Two",
                "Three"
        };
        final String[] second = {
                "Two",
                "Three",
                "Four"
        };
        final String[] target = {
                "Two",
                "Three"
        };
        assertArrayEquals("Error in intersection operation",
                target,
                instance.intersection(first, second)
        );
    }

    @Test
    public void testIntersectionSecond() throws Exception {
        final String[] first = {
                "One",
                "Two",
                "Three"
        };
        final String[] second = {
                "Four",
                "Six",
                "Seven"
        };
        final String[] target = {};
        assertArrayEquals("Error in intersection operation",
                target,
                instance.intersection(first, second)
        );
    }

    @Test
    public void testIntersectionThird() throws Exception {
        final String[] first = {};
        final String[] second = {};
        final String[] target = {};
        assertArrayEquals("Error in intersection operation",
                target,
                instance.intersection(first, second)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnionWithoutArguments() throws Exception {
        instance.union(null, null);
    }

    @Test
    public void testUnionFirst() throws Exception {
        final String[] first = {
                "One",
                "Two",
                "Three"
        };
        final String[] second = {
                "Two",
                "Three",
                "Four"
        };
        final String[] target = {
                "One",
                "Two",
                "Three",
                "Four"
        };
        assertArrayEquals("Error in union operation",
                target,
                instance.union(first, second)
        );
    }

    @Test
    public void testUnionSecond() throws Exception {
        final String[] first = {};
        final String[] second = {};
        final String[] target = {};
        assertArrayEquals("Error in union operation",
                target,
                instance.union(first, second)
        );
    }

    @Test
    public void testUnionThird() throws Exception {
        final String[] first = {
                ""
        };
        final String[] second = {};
        final String[] target = {
                ""
        };
        assertArrayEquals("Error in union operation",
                target,
                instance.union(first, second)
        );
    }
}