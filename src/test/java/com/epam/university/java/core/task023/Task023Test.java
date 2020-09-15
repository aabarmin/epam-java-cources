package com.epam.university.java.core.task023;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task023Test {
    private Task023 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task023.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullString() throws Exception {
        instance.extract(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectFormat() throws Exception {
        instance.extract("+712345");
    }

    @Test
    public void testDefault() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("+7(912)345-67-89")
        );
    }

    @Test
    public void testWithoutDashes() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("+7(912)3456789")
        );
    }

    @Test
    public void testWithSpaces() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("+7 (912) 345 67 89")
        );
    }

    @Test
    public void testWithoutBraces() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("+7 912 345 67 89")
        );
    }

    @Test
    public void testWithoutBracesAndSpaces() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("+79123456789")
        );
    }

    @Test
    public void testWithoutCountryCode() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("8(912)345-67-89")
        );
    }

    @Test
    public void testWithoutBracesAndCountryCode() throws Exception {
        assertEquals(
                "Incorrect operator code",
                "912",
                instance.extract("89123456789")
        );
    }
}