package com.epam.university.java.core.task052;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Task052Test {
    private Task052 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task052.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongAmountOfDigits() {
        instance.validateCard(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negativeNumber() {
        instance.validateCard(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bigNegativeNumber() {
        instance.validateCard(-123456789101215L);
    }

    @Test
    public void numberWithManyZeros() {
        assertTrue("Invalid result",
                instance.validateCard(40000000000002L));
    }

    @Test
    public void trueValidation() {
        assertTrue("Invalid result",
                instance.validateCard(1234567890123452L));
    }

    @Test
    public void falseValidation() {
        assertFalse("Invalid result",
                instance.validateCard(123456789012345L));
    }
}