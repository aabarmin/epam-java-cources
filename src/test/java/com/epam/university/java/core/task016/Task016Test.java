package com.epam.university.java.core.task016;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Incorrect collection with radius 1",
                targetCoordinates,
                instance.getSquaresInsideCircle(1)
        );
    }

    @Test
    public void testWithRadius2() throws Exception {
        final List<Collection<Coordinate>> targetCoordinates = Stream.of(
                generate(-2, 3),
                generate(-3, 2),
                generate(-3, 1)
        ).collect(Collectors.toList());
        assertEquals("Incorrect collection with radius 2",
                targetCoordinates,
                instance.getSquaresInsideCircle(2)
        );
    }

    @Test
    public void testWithRadius3() throws Exception {
        final List<Collection<Coordinate>> targetCoordinates = Stream.of(
                generate(-3, 5),
                generate(-4, 4),
                generate(-5, 3),
                generate(-5, 2),
                generate(-5, 1)
        ).collect(Collectors.toList());
        assertEquals("Incorrect collection with radius 3",
                targetCoordinates,
                instance.getSquaresInsideCircle(3)
        );
    }

    private Collection<Coordinate> generate(int x, int y) {
        final List<Coordinate> part = new ArrayList<>();
        part.addAll(
                IntStream.rangeClosed(-x, x)
                .mapToObj(i -> factory.newInstance(i, y))
                .collect(Collectors.toList())
        );
        part.addAll(
                IntStream.rangeClosed(-x, x)
                .mapToObj(i -> factory.newInstance(i, -y))
                .collect(Collectors.toList())
        );
        return part;
    }
}