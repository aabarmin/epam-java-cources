package com.epam.university.java.core.task015;

import java.awt.*;
import java.awt.geom.Area;

/**
 * Author Dmitry Novikov 27-Sep-20.
 */
public class Task015Impl implements Task015{
    SquareFactory squareFactory = new SquareFactoryImpl();
    PointFactory pointFactory = new PointFactoryImpl();

    @Override
    public double getArea(Square first, Square second) {
        first = normalize(first);
        second = normalize(second);

//        if (first.getFirst().getX() == first.getSecond().getX()
//                || first.getFirst().getY() == first.getSecond().getY()
//
//
//        )


        double left = Math.max(first.getFirst().getX(), second.getFirst().getX());
        double top = Math.min(first.getSecond().getY(), second.getSecond().getY());
        double right = Math.min(first.getSecond().getX(), second.getSecond().getX());
        double bottom = Math.max(first.getFirst().getY(), second.getFirst().getY());

        double width = right - left;
        double height = top - bottom;

        if (width < 0 || height < 0) {
            return 0;
        }

        return width * height;
    }

    private Square normalize(Square input) {
        double minX = Math.min(input.getFirst().getX(), input.getSecond().getX());
        double maxX = Math.max(input.getFirst().getX(), input.getSecond().getX());
        double minY = Math.min(input.getFirst().getY(), input.getSecond().getY());
        double maxY = Math.max(input.getFirst().getY(), input.getSecond().getY());

        return squareFactory.newInstance(pointFactory.newInstance(minX,minY),
                pointFactory.newInstance(maxX,maxY));
    }
}
