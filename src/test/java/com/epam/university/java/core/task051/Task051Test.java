package com.epam.university.java.core.task051;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task051Test {
    private Task051 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task051.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isSourseNull() throws Exception {
        instance.replace(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void hasOnlyWhiteSpace() throws Exception {
        instance.replace(" ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void lowerCase() throws Exception {
        instance.replace("THE DOG AND THE ENVELOPE");
    }

    @Test(expected = IllegalArgumentException.class)
    public void justThe() throws Exception {
        instance.replace("the");
    }

    @Test
    public void firstTest() throws Exception {
        final String source = "the dog and the envelope";
        String expect = "a dog and an envelope";

        assertEquals("The articles are not correct", expect, instance.replace(source));
    }

    @Test
    public void secondTest() throws Exception {
        final String source = "the boy ran at the wall";
        String expect = "a boy ran at a wall";

        assertEquals("The articles are not correct", expect, instance.replace(source));
    }

    @Test
    public void thirdTest() throws Exception {
        final String source = "the egg, the spoon and the espionage";
        String expect = "an egg, a spoon and an espionage";

        assertEquals("The articles are not correct", expect, instance.replace(source));
    }

    @Test
    public void noThe() throws Exception {
        final String source = "the dog and the envelope";

        assertFalse("Wrong articles", instance.replace(source).contains("the"));
    }
}