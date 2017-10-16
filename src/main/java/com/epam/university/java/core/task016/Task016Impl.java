package com.epam.university.java.core.task016;

import com.epam.university.java.core.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task016Impl implements Task016 {
    private Validator validator = Validator.getInstance();

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        validator.validatePos(radius);

        final CoordinateFactory factory = new CoordinateFactoryImpl();
        final List<Coordinate> squares = new ArrayList<>();
        final int radius2 = 2 * radius;

        IntStream.rangeClosed(-radius2, radius2)
                .forEach(x -> IntStream.rangeClosed(-radius2, radius2)
                        .filter(y -> isInside(x, y, radius2))
                        .forEach(y -> squares.add(rotateSquare(x, y))));

        return squares;
    }

    /*
    * Checking if square is in circle.
    * @param x x coordinate of top left dot
    * @param y y coordinate of top left dot
    */
    private boolean isInside(int x, int y, int r) {
        final double r2 = Math.pow(r, 2);
        return Math.pow(x, 2) + Math.pow(y, 2) <= r2
                && Math.pow(x + 1, 2) + Math.pow(y, 2) <= r2
                && Math.pow(x + 1, 2) + Math.pow(y - 1, 2) <= r2
                && Math.pow(x, 2) + Math.pow(y - 1, 2) <= r2;
    }

    /*
   * Calculating farthest from (0;0) square dot and creating CoordinateImpl obj.
   * @param x x coordinate of top left dot
   * @param y y coordinate of top left dot
   * @return coordinate instance
   */
    private Coordinate rotateSquare(int x, int y) {
        return new CoordinateImpl(
                x < 0 ? x : x + 1,
                y > 0 ? y : y - 1
        );
    }

}
