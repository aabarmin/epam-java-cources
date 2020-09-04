package com.epam.university.java.core.task007;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Aleksandr_Barmin on 9/6/2017.
 */
public class Task007Test {
    private Task007 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task007.class);
    }

    @Test
    public void testFirst() throws Exception {
        final Collection<Integer> first = Arrays.asList(2, 1);
        final Collection<Integer> second = Arrays.asList(2, 1);
        final Collection<Integer> result = Arrays.asList(4, 4, 1);
        assertEquals("Error in first multiplication",
                result,
                instance.multiplyPolynomial(first, second)
        );
    }

    @Test
    public void testSecond() throws Exception {
        final Collection<Integer> first = Arrays.asList(2, 0, 0, 3);
        final Collection<Integer> second = Arrays.asList(4, 0, 1);
        final Collection<Integer> result = Arrays.asList(8, 0, 2, 12, 0, 3);
        assertEquals("Error in second multiplication",
                result,
                instance.multiplyPolynomial(first, second)
        );
    }

    @Test
    public void testThird() throws Exception {
        final Collection<Integer> first = Arrays.asList(6, 10, 0, 5);
        final Collection<Integer> second = Arrays.asList(4, 2, 1);
        final Collection<Integer> result = Arrays.asList(24, 52, 26, 30, 10, 5);
        assertEquals("Error in third multiplication",
                result, instance.multiplyPolynomial(first, second));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectArgs() throws Exception {
        assertNull("Error in args", instance.multiplyPolynomial(null, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSecondArgIncorrect() throws Exception {
        final Collection<Integer> first = Arrays.asList(6, 10, 0, 5);
        assertNull("Error in second arg", instance.multiplyPolynomial(first, null));
    }
}