package com.epam.university.java.core.task048;

import com.epam.university.java.core.helper.TestHelper;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task048Test {
    private Task048 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFromIntegerNull() {
        instance.getArmstrongNumbers(null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isToIntegerNull() {
        instance.getArmstrongNumbers(1000, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void areBothIntegersNull() {
        instance.getArmstrongNumbers(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isAnyIntegerPossitive() {
        instance.getArmstrongNumbers(-1, -1);
    }

    @Test
    public void checkForCorrectResult() {
        Collection<Integer> expectation
                = Arrays.asList(2, 3, 4, 5, 6, 7, 8,
                9, 153, 370, 371, 407,
                1634, 8208, 9474, 54748,
                92727, 93084);
        Collection<Integer> result = instance.getArmstrongNumbers(1, 99999);
        assertTrue("Incorrect Armstrong numbers collection",
                expectation.containsAll(
                        result
                ));
        assertEquals("Incorrect Armstrong numbers collection",
                expectation.size(),
                result.size()
        );
    }
}