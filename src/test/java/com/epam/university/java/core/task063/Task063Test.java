package com.epam.university.java.core.task063;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task063Test {
    private Task063 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFromIntegerNull() {
        instance.calcDigitalRoot(null);
    }

    @Test
    public void calDigitalRootWithSimpleNumber() throws Exception {
        final Integer number = Integer.valueOf(3);
        final Integer digitalRoot = instance.calcDigitalRoot(number);
        assertEquals("Incorrect digital root", Integer.valueOf(3), digitalRoot);
    }

    @Test
    public void calDigitalRootWithRandomNumber() throws Exception {
        final Integer number = Integer.valueOf(98452);
        final Integer digitalRoot = instance.calcDigitalRoot(number);
        assertEquals("Incorrect digital root", Integer.valueOf(1), digitalRoot);
    }

    @Test
    public void calDigitalRootWithZero() throws Exception {
        final Integer number = Integer.valueOf(0);
        final Integer digitalRoot = instance.calcDigitalRoot(number);
        assertEquals("Incorrect digital root", Integer.valueOf(0), digitalRoot);
    }

    @Test
    public void calDigitalRootWithMaxValue() throws Exception {
        final Integer number = Integer.MAX_VALUE;
        final Integer digitalRoot = instance.calcDigitalRoot(number);
        assertEquals("Incorrect digital root", Integer.valueOf(1), digitalRoot);
    }

}
