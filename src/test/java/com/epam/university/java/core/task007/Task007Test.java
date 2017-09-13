package com.epam.university.java.core.task007;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

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
        final Collection<Integer> first = Arrays.asList(2, 1); // 2x^2 + 1x
        final Collection<Integer> second = Arrays.asList(2, 1); // 2x^2 + 1x
        final Collection<Integer> result = Arrays.asList(4, 4, 1, 0); // 4x^4 + 4x^3 + 1x^2 + 0x
        assertEquals("Error in first multiplication",
                result,
                instance.multiplyPolynomial(first, second)
        );
    }

    @Test
    public void testSecond() throws Exception {
        final Collection<Integer> first = Arrays.asList(2, 0, 0, 3); // 2x^4 + 0x^3 + 0x^2 + 1x
        final Collection<Integer> second = Arrays.asList(4, 0, 1); // 4x^3 + 0x^2 + 1x
        // 8x^7 + 0x^6 + 2x^5 + 12x^4 + 0x^3 + 3x^2 + 0x
        final Collection<Integer> result = Arrays.asList(8, 0, 2, 12, 0, 3, 0);
        assertEquals("Error in second multiplication",
                result,
                instance.multiplyPolynomial(first, second)
        );
    }
}