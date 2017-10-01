package com.epam.university.java.core.task016;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task016Test {
    private Task016 instance;
    private CoordinateFactory factory;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task016.class);
        factory = TestHelper.getInstance(CoordinateFactory.class);
    }

    @Test
    public void testWithRadius1() throws Exception {
        final Collection<Coordinate> targetCoordinates = generate(-1, 1);
        final Collection<Coordinate> resultCoordinates =
            instance.getSquaresInsideCircle(1);
        assertEquals("Incorrect collection size with radius 1",
            targetCoordinates.size(),
            resultCoordinates.size()
        );
        assertTrue("Incorrect collection with radius 1",
            targetCoordinates.containsAll(resultCoordinates)
                && resultCoordinates.containsAll(targetCoordinates)
        );
    }

    @Test
    public void testWithRadius2() throws Exception {
        final Collection<Coordinate> targetCoordinates = Stream.of(
            generate(-2, 3).stream(),
            generate(-3, 2).stream(),
            generate(-3, 1).stream())
            .flatMap(Function.identity())
            .collect(Collectors.toList());
        final Collection<Coordinate> resultCoordinates =
            instance.getSquaresInsideCircle(2);
        assertEquals("Incorrect collection size with radius 2",
            targetCoordinates.size(),
            resultCoordinates.size()
        );
        assertTrue("Incorrect collection with radius 2",
                targetCoordinates.containsAll(resultCoordinates)
                        && resultCoordinates.containsAll(targetCoordinates)
        );
    }

    @Test
    public void testWithRadius3() throws Exception {
        final Collection<Coordinate> targetCoordinates = Stream.of(
            generate(-3, 5).stream(),
            generate(-4, 4).stream(),
            generate(-5, 3).stream(),
            generate(-5, 2).stream(),
            generate(-5, 1).stream())
            .flatMap(Function.identity())
            .collect(Collectors.toList());
        final Collection<Coordinate> resultCoordinates =
            instance.getSquaresInsideCircle(3);
        assertEquals("Incorrect collection size with radius 3",
            targetCoordinates.size(),
            resultCoordinates.size()
        );
        assertTrue("Incorrect collection with radius 3",
                targetCoordinates.containsAll(resultCoordinates)
                        && resultCoordinates.containsAll(targetCoordinates)
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithWrongRadius() throws Exception {
        instance.getSquaresInsideCircle(-2);
    }

    private Collection<Coordinate> generate(int x, int y) {
        final List<Coordinate> part = new ArrayList<>();
        part.addAll(
            IntStream.rangeClosed(x, -x)
                .filter(i -> i != 0)
                .mapToObj(i -> factory.newInstance(i, y))
                .collect(Collectors.toList())
        );
        part.addAll(
            IntStream.rangeClosed(x, -x)
                .filter(i -> i != 0)
                .mapToObj(i -> factory.newInstance(i, -y))
                .collect(Collectors.toList())
        );
        return part;
    }
}
