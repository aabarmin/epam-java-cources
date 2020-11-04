package com.epam.university.java.core.task021;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task021Test {
    private Task021 instance;
    private PointFactory pointFactory;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task021.class);
        pointFactory = TestHelper.getInstance(PointFactory.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithNullList() throws Exception {
        instance.calculate(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithEmptyList() throws Exception {
        instance.calculate(Collections.emptyList());
    }

    @Test
    public void test1() throws Exception {
        final List<Point> points = Arrays.asList(
                pointFactory.newInstance(1, 1),
                pointFactory.newInstance(2, 2),
                pointFactory.newInstance(1, 2)
        );
        final Point target = pointFactory.newInstance(1.2113248654051871, 1.788675134594813);
        final Point result = instance.calculate(points);
        assertEquals("Incorrect result in test 1",
                target,
                result
        );
    }

    @Test
    public void test2() throws Exception {
        final List<Point> points = Arrays.asList(
                pointFactory.newInstance(-1, -1),
                pointFactory.newInstance(-2, -1),
                pointFactory.newInstance(0, 0)
        );
        final Point target = pointFactory.newInstance(-1, -1);
        final Point result = instance.calculate(points);
        assertEquals("Incorrect result in test 2",
                target,
                result
        );
    }

    @Test
    public void test3() throws Exception {
        final List<Point> points = Arrays.asList(
                pointFactory.newInstance(-1, -1),
                pointFactory.newInstance(1, -1),
                pointFactory.newInstance(0, 1)
        );
        final Point target = pointFactory.newInstance(0, -0.422649730810374);
        final Point result = instance.calculate(points);
        assertEquals("Incorrect result in test 3",
                target,
                result
        );
    }

    @Test
    public void test4() throws Exception {
        final List<Point> points = Arrays.asList(
                pointFactory.newInstance(0, 0),
                pointFactory.newInstance(0.5, 0.8660254037844386),
                pointFactory.newInstance(-5, 0)
        );
        final Point target = pointFactory.newInstance(0, 0);
        final Point result = instance.calculate(points);
        assertEquals("Incorrect result in test 4",
                target,
                result
        );
    }

    @Test
    public void test5() throws Exception {
        final List<Point> points = Arrays.asList(
                pointFactory.newInstance(0, 0),
                pointFactory.newInstance(0, -5),
                pointFactory.newInstance(-0.8660254037844386, 0.5)
        );
        final Point target = pointFactory.newInstance(0, 0);
        final Point result = instance.calculate(points);
        assertEquals("Incorrect result in test 5",
                target,
                result
        );
    }
}