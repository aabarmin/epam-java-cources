package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import java.util.ArrayList;
import java.util.Collection;

public class Task021Impl implements Task021 {

    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions == null || minePositions.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Point> list = new ArrayList<>(minePositions);
        PointImpl point1 = (PointImpl) list.get(0);
        PointImpl point2 = (PointImpl) list.get(1);
        PointImpl point3 = (PointImpl) list.get(2);

        double a = Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
        double b = Math.sqrt(Math.pow((point2.getX() - point3.getX()), 2) + Math.pow((point2.getY() - point3.getY()), 2));
        double c = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));

        return null;
    }
}
