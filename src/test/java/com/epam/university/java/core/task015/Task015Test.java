package com.epam.university.java.core.task015;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Task015Test {
    private static final double DELTA = 0.00001;

    private Task015 instance;
    private PointFactory pointFactory;
    private SquareFactory squareFactory;

    /**
     * {@inheritDoc}
     */
    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task015.class);
        pointFactory = TestHelper.getInstance(PointFactory.class);
        squareFactory = TestHelper.getInstance(SquareFactory.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullPoints() throws Exception {
        squareFactory.newInstance(null, null);
    }

    @Test
    public void testIntersection1() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(2, 2),
                pointFactory.newInstance(4, 4)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 5),
                pointFactory.newInstance(5, 3)
        );
        assertEquals("Error in intersection 1",
                1,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection2() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 2),
                pointFactory.newInstance(3, 4)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(4, 2),
                pointFactory.newInstance(6, 4)
        );
        assertEquals("Error in intersection 2",
                0,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection3() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 2),
                pointFactory.newInstance(3, 4)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 2),
                pointFactory.newInstance(5, 4)
        );
        assertEquals("Error in intersection 3",
                0,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection4() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 3),
                pointFactory.newInstance(5, 3)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(5, 1),
                pointFactory.newInstance(5, 5)
        );
        assertEquals("Error in intersection 4",
                2,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection5() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(3, 3)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(4, 1),
                pointFactory.newInstance(4, 5)
        );
        assertEquals("Error in intersection 5",
                0.5,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection6() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 4),
                pointFactory.newInstance(4, 1)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 3),
                pointFactory.newInstance(7, 3)
        );
        assertEquals("Error in intersection 6",
                1,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection7() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(5, 5)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 2),
                pointFactory.newInstance(9, 2)
        );
        assertEquals("Error in intersection 7",
                3.5,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection8() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(5, 5)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 0),
                pointFactory.newInstance(3, 6)
        );
        assertEquals("Error in intersection 8",
                14,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection9() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 4),
                pointFactory.newInstance(7, 4)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(3, 3),
                pointFactory.newInstance(5, 5)
        );
        assertEquals("Error in intersection 9",
                4,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }

    @Test
    public void testIntersection10() throws Exception {
        final Square firstSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(2, 2)
        );
        final Square secondSquare = squareFactory.newInstance(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(2, 2)
        );
        assertEquals("Error in intersection 10",
                1,
                instance.getArea(firstSquare, secondSquare),
                DELTA
        );
    }
}