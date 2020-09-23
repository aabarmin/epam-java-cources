package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions == null || minePositions.isEmpty()) {
            throw new IllegalArgumentException();
        }


        ArrayList<Point> poins = new ArrayList<>(minePositions);

        double x = 0;
        double y = 0;

        Point a = poins.get(0);
        Point b = poins.get(1);
        Point c = poins.get(2);

        double abLength = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
        double bcLength = Math.sqrt(Math.pow(c.getX() - b.getX(), 2) + Math.pow(c.getY() - b.getY(), 2));
        double acLength = Math.sqrt(Math.pow(c.getX() - a.getX(), 2) + Math.pow(c.getY() - a.getY(), 2));

        double perimeter = abLength + bcLength + acLength;
        double S = Math.sqrt(perimeter / 2 * (perimeter / 2 + abLength)
                * (perimeter / 2 * bcLength)
                * (perimeter / 2 * acLength));

        return new PointImpl(x, y);
    }
}
