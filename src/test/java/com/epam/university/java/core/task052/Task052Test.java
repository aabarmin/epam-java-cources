package com.epam.university.java.core.task052;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task052Test {
    private Task052 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task052.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongAmountofDigits() throws Exception {
        instance.validateCard(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumber() throws Exception {
        instance.validateCard(-1);
    }

    @Test
    public void trueValide() throws Exception {

        assertEquals("Invalid result",
                true,
                instance.validateCard(1234567890123452L));
    }

    @Test
    public void falseValide() throws Exception {
        long numbers = 123456789012345L;

        assertEquals("Invalid result",
                false,
                instance.validateCard(123456789012345L));
    }
}