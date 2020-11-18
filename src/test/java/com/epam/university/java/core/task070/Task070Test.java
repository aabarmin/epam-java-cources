package com.epam.university.java.core.task070;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task070Test {
    private Task070 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isFromIntegerNull() {
        instance.getSmithNumbers(null, 1200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isToIntegerNull() {
        instance.getSmithNumbers(1200, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void areBothIntegersNull() {
        instance.getSmithNumbers(null, null);
    }

    @Test
    public void checkSmithNumbers() {
        Collection<Integer> expectation
                = Arrays.asList(4, 22, 27, 58, 85, 94, 121, 166, 202, 265, 274, 319,
                346, 355, 378, 382, 391, 438, 454, 483, 517, 526, 535, 562, 576, 588,
                627, 634, 636, 645, 648, 654, 663, 666, 690, 706, 728, 729, 762, 778,
                825, 852, 861, 895, 913, 915, 922, 958, 985, 1086, 1111, 1165);
        Collection<Integer> result = instance.getSmithNumbers(2, 1200);
        assertTrue("Incorrect Smith numbers",
                expectation.containsAll(
                        result
                ));
        assertEquals("Incorrect Smith numbers",
                expectation.size(),
                result.size()
        );
    }
}
