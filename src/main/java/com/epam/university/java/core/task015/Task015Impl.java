package com.epam.university.java.core.task015;

import static com.epam.university.java.core.task015.SquareImpl.getIntersectionPoints;

public class Task015Impl implements Task015 {

    @Override
    public double getArea(Square first, Square second) {
        Polygon polygon = new Polygon(getIntersectionPoints(first,second));
        return polygon.area();
    }
}
