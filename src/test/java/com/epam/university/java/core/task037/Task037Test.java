package com.epam.university.java.core.task037;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertArrayEquals;

public class Task037Test {
    private Task037 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task037.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullParams() throws Exception {
        instance.switcher(null, null);
    }

    @Test
    public void switcher() throws Exception {
        final Callable<String> ticker = () -> "Tick";
        final Callable<String> tacker = () -> "Tack";
        final Collection<String> target = Arrays.asList(
                "Tick",
                "Tack",
                "Tick",
                "Tack",
                "Tick",
                "Tack",
                "Tick",
                "Tack",
                "Tick",
                "Tack"
        );
        final Collection<String> value = instance.switcher(ticker, tacker);
        assertArrayEquals(
                "Incorrect ticker",
                target.toArray(new String[0]),
                value.toArray(new String[0])
        );
    }

}