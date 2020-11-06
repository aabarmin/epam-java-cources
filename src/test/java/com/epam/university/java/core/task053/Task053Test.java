package com.epam.university.java.core.task053;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task053Test {

    private Task053 instance;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task053.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void inputIsNull() throws Exception {
        instance.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLength() throws Exception {
        instance.calculate("1+");
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsSpaces() throws Exception {
        instance.calculate("1+3- 6");
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsNotValidSymbols() throws Exception {
        instance.calculate("1+3-6+#");
    }

    @Test(expected = IllegalArgumentException.class)
    public void first_BracesOrderNotValid() throws Exception {
        instance.calculate("(1+1)*((5-3)");
    }

    @Test(expected = IllegalArgumentException.class)
    public void second_BracesOrderNotValid() throws Exception {
        instance.calculate("(1+1)*(5-3))");
    }

    @Test(expected = IllegalArgumentException.class)
    public void third_BracesOrderNotValid() throws Exception {
        instance.calculate("3-1)");
    }

    @Test
    public void first() {
        String input = "1+2+3";
        double expect = 6.0;

        assertEquals("Invalid result", expect, instance.calculate(input), DELTA);
    }

    @Test
    public void second() {
        String input = "10+(2*3)";
        double expect = 16.0;

        assertEquals("Invalid result", expect, instance.calculate(input), DELTA);
    }

    @Test
    public void third() {
        String input = "4+(8*(13-5)+2)";
        double expect = 70.0;

        assertEquals("Invalid result", expect, instance.calculate(input), DELTA);
    }

    @Test
    public void fourth() {
        String input = "4+(8*(13-5^2)+2^3)";
        double expect = -84.0;

        assertEquals("Invalid result", expect, instance.calculate(input), DELTA);
    }

    @Test
    public void fifth() {
        String input = "(13*5/8)^2+(64*12/4^4)";
        double expect = 69.015625;

        assertEquals("Invalid result", expect, instance.calculate(input), DELTA);
    }
}
