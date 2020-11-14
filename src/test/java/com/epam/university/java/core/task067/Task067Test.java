package com.epam.university.java.core.task067;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task067Test {

    private com.epam.university.java.core.task067.Task067 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(com.epam.university.java.core.task067.Task067.class);
    }

    @Test
    public void test1() {
        assertEquals(6, instance.knightMovements(1, 1, 8, 8));
    }

    @Test
    public void test2() {
        assertEquals(1, instance.knightMovements(1, 1, 3, 2));
    }

    @Test
    public void test3() {
        assertEquals(4, instance.knightMovements(8, 8, 3, 3));
    }

    @Test
    public void test4() {
        assertEquals(2, instance.knightMovements(5, 5, 7, 1));
    }

    @Test
    public void test5() {
        assertEquals(4, instance.knightMovements(4, 8, 1, 1));
    }

    @Test
    public void test6() {
        assertEquals(3, instance.knightMovements(1, 1, 1, 2));
    }
}
