package com.epam.university.java.core.task032;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task032Test {
    private Task032 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task032.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullWrapper() throws Exception {
        instance.createExecutorWithProxy(null);
    }

    @Test
    public void countOfMethodInvocations() throws Exception {
        final CountingProxy wrapper = instance.createProxyWrapper();
        final SomeActionExecutor executor = instance.createExecutorWithProxy(wrapper);
        // methods invocation
        for (int i = 0; i < 5; i++) {
            executor.doAction();
        }
        for (int i = 0; i < 10; i++) {
            executor.doAnotherAction();
        }
        // checkups
        assertEquals("Incorrect count",
                5,
                wrapper.getInvocationsCount("doAction")
        );
        assertEquals("Incorrect count",
                10,
                wrapper.getInvocationsCount("doAnotherAction")
        );
    }
}