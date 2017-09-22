package com.epam.university.java.core.task015;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ilya on 16.09.17.
 */
public class Task015Impl implements Task015 {

    @Override
    public double getArea(Square first, Square second) {
        Figure firstSquare = squareToFigure(first, true);
        Figure secondSquare = squareToFigure(second, false);

        WeilerAthertonAlgorithm algorithm = new WeilerAthertonAlgorithm(firstSquare, secondSquare);
        Figure intersection = null;
        intersection = algorithm.getIntersection();
        if (intersection == null) {
            return 0;
        }

        return intersection.getArea();
    }

    private Figure squareToFigure(Square square, boolean clockWice) {
        PointFactory factory = new PointFactoryImpl();

        Point first = new PointImpl(square.getFirst().getX(), square.getFirst().getY());
        Point third = new PointImpl(square.getSecond().getX(), square.getSecond().getY());
        Point second = new PointImpl(
            (first.getX() + third.getX()) / 2 - (third.getY() - first.getY()) / 2,
            (first.getY() + third.getY()) / 2 + (third.getX() - first.getX()) / 2);
        Point forth = new PointImpl(
            (first.getX() + third.getX()) / 2 + (third.getY() - first.getY()) / 2,
            (first.getY() + third.getY()) / 2 - (third.getX() - first.getX()) / 2);

        List<Point> points = new LinkedList<>();
        if (clockWice == true) {
            Collections.addAll(points, first, second, third, forth);
        } else {
            Collections.addAll(points, forth, third, second, first);
        }

        return new Figure(points);
    }


}
