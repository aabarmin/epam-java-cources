package com.epam.university.java.core.Task069;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Task069Test {
    Task069 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task069.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumber() throws Exception {
        instance.nextSameDigitsNumber(-1234);
    }

    @Test
    public void shortNumber() {
        assertEquals("Wrong result", 42, instance.nextSameDigitsNumber(24));
    }

    @Test
    public void notExist() {
        assertEquals("Wrong result", -1, instance.nextSameDigitsNumber(555));
    }

    @Test
    public void longInteger() {
        assertEquals("Wrong result", 389111299, instance.nextSameDigitsNumber(382999111));
    }

    @Test
    public void biggerThanInteger() {
        assertEquals("Wrong result", 59884848483595L, instance.nextSameDigitsNumber(59884848483559L));
    }
}
