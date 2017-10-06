package com.epam.university.java.core.task015;

import java.awt.Rectangle;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        Point upperLeftPointCoordFirst = upperLeftFinding(first);
        Point upperLeftPointCoordSecond = upperLeftFinding(second);

        Rectangle rect1 = new Rectangle((int)upperLeftPointCoordFirst.getX(),
                                       (int)upperLeftPointCoordFirst.getY(),2,2);

        Rectangle rect2 = new Rectangle((int)upperLeftPointCoordSecond.getX(),
                                       (int)upperLeftPointCoordSecond.getY(),2,2);
        if (rect1.intersects(rect2)) {
            Rectangle rect3 = rect1.intersection(rect2);
            return rect3.height * rect3.width;
        } else {
            return 0.0;
        }
    }

    private Point upperLeftFinding(Square square) {
        if ((square.getFirst().getX() < square.getSecond().getX())
                && (square.getFirst().getY() < square.getSecond().getY())) {
            square.getFirst().setY(square.getFirst().getY() + 2);
            return square.getFirst();
        } else {
            return square.getFirst();
        }
    }
}
