package com.epam.university.java.core.task033;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class Task033Test {
    private Task033 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task033.class);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroException() throws Exception {
        instance.doSomething(0, 0);
    }

    @Test
    public void greaterException() throws Exception {
        try {
            instance.doSomething(1, 0);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(
                    "Incorrect type of exception",
                    e instanceof GreaterException
            );
            assertEquals(
                    "Incorrect exception message body",
                    "First > Second",
                    e.getMessage()
            );
            assertNotNull(
                    "There is no basic message",
                    e.getCause()
            );
            assertTrue(
                    "Incorrect basic message type",
                    e.getCause() instanceof BaseException
            );
        }
    }

    @Test
    public void lessException() throws Exception {
        try {
            instance.doSomething(0, 1);
            assertTrue(false);
        } catch (Exception e) {
            assertTrue(
                    "Incorrect type of exception",
                    e instanceof LessException
            );
            assertEquals(
                    "Incorrect exception message body",
                    "Second > First",
                    e.getMessage()
            );
            assertNotNull(
                    "There is no basic message",
                    e.getCause()
            );
            assertTrue(
                    "Incorrect basic message type",
                    e.getCause() instanceof BaseException
            );
        }
    }
}