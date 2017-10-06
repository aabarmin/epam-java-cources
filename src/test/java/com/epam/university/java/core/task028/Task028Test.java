package com.epam.university.java.core.task028;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task028Test {
    private Task028 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task028.class);
    }

    @Test
    public void test10() throws Exception {
        assertEquals("Incorrect value",
                1,
                instance.getWays(10, 2)
        );
    }

    @Test
    public void test100() throws Exception {
        assertEquals("Incorrect value",
                3,
                instance.getWays(100, 2)
        );
    }

    @Test
    public void test100withCubes() throws Exception {
        assertEquals("Incorrect value",
                1,
                instance.getWays(100, 3)
        );
    }
}