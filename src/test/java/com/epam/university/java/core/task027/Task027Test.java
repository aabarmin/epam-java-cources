package com.epam.university.java.core.task027;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Task027Test {
    private Task027 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task027.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullString() throws Exception {
        instance.extract(null);
    }

    @Test
    public void extract1() throws Exception {
        assertArrayEquals(
                "Invalid extraction",
                new Integer[]{1, 2, 3, 4},
                instance.extract("1234").toArray(new Integer[4])
        );
    }

    @Test
    public void extract2() throws Exception {
        assertArrayEquals(
                "Invalid extraction",
                new Integer[]{10, 11, 12, 13},
                instance.extract("10111213").toArray(new Integer[4])
        );
    }

    @Test
    public void extract3() throws Exception {
        assertArrayEquals(
                "Invalid extraction",
                new Integer[]{99, 100, 101},
                instance.extract("99100101").toArray(new Integer[3])
        );
    }

    @Test
    public void extract4() throws Exception {
        assertArrayEquals(
                "Invalid extraction",
                new Integer[]{999, 1000, 1001},
                instance.extract("99910001001").toArray(new Integer[3])
        );
    }

    @Test
    public void extract5() throws Exception {
        assertArrayEquals(
            "Invalid extraction",
            new Integer[]{},
            instance.extract("0123").toArray(new Integer[0])
        );
    }

    @Test
    public void extract6() throws Exception {
        assertArrayEquals(
            "Invalid extraction",
            new Integer[]{},
            instance.extract("2122023").toArray(new Integer[0])
        );
    }

    @Test
    public void extract7() throws Exception {
        assertArrayEquals(
            "Invalid extraction",
            new Integer[]{},
            instance.extract("4123").toArray(new Integer[0])
        );
    }

    @Test
    public void extract8() throws Exception {
        assertArrayEquals(
            "Invalid extraction",
            new Integer[]{},
            instance.extract("7").toArray(new Integer[0])
        );
    }

}