package com.epam.university.java.core.task036;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task036Test {
    private Task036 instance;
    private Integrator integrator;
    private static final double delta = 0.0001;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task036.class);
        integrator = TestHelper.getInstance(Integrator.class);
    }

    @Test
    public void integrateSimple1() throws Exception {
        final double value = instance.integrate(x -> (7 / (Math.pow(x, 2) + 1)),
                integrator, 0, 5
        );
        assertEquals("Incorrect integration value",
                9.6138,
                value,
                delta);
    }

    @Test
    public void integrateSimple2() throws Exception {
        final double value = instance.integrate(x -> ((Math.pow(x, 4) / 12) + (x / 3) - (1.0 / 60)),
                integrator,
                1, 2
        );
        assertEquals("Incorrect integration value",
                1.0000,
                value,
                delta);
    }

    @Test
    public void integrateSimple3() throws Exception {
        final double value = instance.integrate(x -> (x * Math.exp(x)),
                integrator,
                0, 2
        );
        assertEquals("Incorrect integration value",
                8.3891,
                value,
                delta);
    }

}
