package com.epam.university.java.core.task059;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task056.Task056;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task059Test {
    private Task059 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task059.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void arrayIsNull() throws Exception {
        instance.countSort(null);
    }

    @Test
    public void first() throws Exception {
        final int[] input = {1, 3, 2, 7, 2, 2, 2, 3};
        final int[] target = {1, 2, 2, 2, 3, 3, 7};
        final int[] actual = instance.countSort(input);
        for (int i = 0; i < target.length; i++) {
            assertEquals("Wrong result", target[i], actual[i]);
        }
    }

    @Test
    public void second() throws Exception {
        final int[] input = {2, 1, 1, 1, 3, 2, 2, 2, 3, 2, 3, 2, 2, 1, 1};
        final int[] target = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3};
        final int[] actual = instance.countSort(input);
        for (int i = 0; i < target.length; i++) {
            assertEquals("Wrong result", target[i], actual[i]);
        }
    }
}
