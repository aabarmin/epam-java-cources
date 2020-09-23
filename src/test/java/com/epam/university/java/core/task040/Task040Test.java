package com.epam.university.java.core.task040;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task040Test {

    private Task040 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void countWithNullArgument() throws Exception {
        instance.countScore(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void countWithEmptyStringArgument() throws Exception {
        instance.countScore("");
    }

    @Test
    public void countTest1() throws Exception {
        assertEquals("Incorrect counted score",
                instance.countScore("11 11 11 11 11 11 11 11 11 11"),
                20);
    }

    @Test
    public void countTest2() throws Exception {
        assertEquals("Incorrect counted score",
                instance.countScore("X X X X X X X X X XXX"),
                300);
    }

    @Test
    public void countTest3() throws Exception {
        assertEquals("Incorrect counted score",
                instance.countScore("X 81 X X 7/ 53 06 X 7/ X81"),
                163);
    }
}