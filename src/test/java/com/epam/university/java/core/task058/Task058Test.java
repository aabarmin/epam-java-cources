package com.epam.university.java.core.task058;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task058Test {
    private Task058 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task058.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void numberIsZero() throws Exception {
        instance.fillSpiral(0);
    }

    @Test
    public void numberIsOne() throws Exception {
        final int[][] target = {{1}};
        final int[][] actual = instance.fillSpiral(1);
        assertEquals("Orders are different", target.length, actual.length);
        assertEquals("Orders are different", target[0].length, actual[0].length);
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                assertEquals("Incorrect result in element (" + i + ", " + j + ")!",
                        target[i][j], actual[i][j]);
            }
        }
    }

    @Test
    public void numberIsTwo() throws Exception {
        final int[][] target = {{1, 2}, {4, 3}};
        final int[][] actual = instance.fillSpiral(2);
        assertEquals("Orders are different", target.length, actual.length);
        assertEquals("Orders are different", target[0].length, actual[0].length);
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                assertEquals("Incorrect result in element (" + i + ", " + j + ")!",
                        target[i][j], actual[i][j]);
            }
        }
    }

    @Test
    public void numberIsThree() throws Exception {
        final int[][] target = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};
        final int[][] actual = instance.fillSpiral(3);
        assertEquals("Orders are different", target.length, actual.length);
        assertEquals("Orders are different", target[0].length, actual[0].length);
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                assertEquals("Incorrect result in element (" + i + ", " + j + ")!",
                        target[i][j], actual[i][j]);
            }
        }
    }

    @Test
    public void numberIsFive() throws Exception {
        final int[][] target = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        final int[][] actual = instance.fillSpiral(5);
        assertEquals("Orders are different", target.length, actual.length);
        assertEquals("Orders are different", target[0].length, actual[0].length);
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                assertEquals("Incorrect result in element (" + i + ", " + j + ")!",
                        target[i][j], actual[i][j]);
            }
        }
    }
}
