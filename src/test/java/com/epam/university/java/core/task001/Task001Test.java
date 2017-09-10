package com.epam.university.java.core.task001;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Aleksandr_Barmin on 8/31/2017.
 */
public class Task001Test {
    public static final double DELTA = 0.0000001;

    private Task001 instance;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(getClass());
    }

    @Test(expected = IllegalArgumentException.class)
    public void additionNullBothArguments() throws Exception {
        instance.addition(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void additionNullOneArgument() throws Exception {
        instance.addition("5", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void additionEmptyBothArgument() throws Exception {
        instance.addition(" ", " ");
    }

    @Test(expected = NumberFormatException.class)
    public void additionNotANumbers() throws Exception {
        instance.addition("a", "b");
    }

    @Test
    public void addition() throws Exception {
        final double addition = instance.addition(" 2   ", "   2 ");
        assertEquals("Incorrect addition results", 4, addition, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractionNullBothArguments() throws Exception {
        instance.subtraction(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractionNullOneArgument() throws Exception {
        instance.subtraction("5", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractionEmptyBothArguments() throws Exception {
        instance.subtraction(" ", " ");
    }

    @Test(expected = NumberFormatException.class)
    public void subtractionNotANumbers() throws Exception {
        instance.subtraction("aa", "bb");
    }

    @Test
    public void subtraction() throws Exception {
        final double subtraction = instance.subtraction(" 5   ", "   2 ");
        assertEquals("Incorrect subtraction results", 3, subtraction, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplicationNullBothArguments() throws Exception {
        instance.multiplication(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplicationNullOneArgument() throws Exception {
        instance.multiplication("5", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplicationEmptyBothArguments() throws Exception {
        instance.multiplication(" ", " ");
    }

    @Test(expected = NumberFormatException.class)
    public void multiplicationNotANumbers() throws Exception {
        instance.multiplication("6a", "6b");
    }

    @Test
    public void multiplication() throws Exception {
        final double multiplication = instance.multiplication(" 5.5   ", "   6.5 ");
        assertEquals("Incorrect multiplication results", 35.75, multiplication, DELTA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionNullBothArguments() throws Exception {
        instance.division(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionNullOneArgument() throws Exception {
        instance.division("5", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divisionEmptyBothArguments() throws Exception {
        instance.division(" ", " ");
    }

    @Test(expected = NumberFormatException.class)
    public void divisionNotANumbers() throws Exception {
        instance.division("aa", "bb");
    }

    @Test
    public void divisionWithNaN() throws Exception {
        final double division = instance.division("  0  ", "  0  ");
        assertEquals("Incorrect division results", Double.NaN, division, DELTA);
    }

    @Test
    public void divisionWithPositiveInfinity() throws Exception {
        final double division = instance.division("  1  ", "  0  ");
        assertEquals("Incorrect division results", Double.POSITIVE_INFINITY, division, DELTA);
    }

    @Test
    public void divisionWithNegativeInfinity() throws Exception {
        final double division = instance.division("  -1  ", "  0  ");
        assertEquals("Incorrect division results", Double.NEGATIVE_INFINITY, division, DELTA);
    }

    @Test
    public void division() throws Exception {
        final double division = instance.division(" 5 ", " 2 ");
        assertEquals("Incorrect division results", 2.5, division, DELTA);
    }

}