package com.epam.university.java.core.task015;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * {@inheritDoc}
 */
public class Task015Impl implements Task015 {
    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea(Square first, Square second) {
        Point2D.Double aOfFirst = new Point2D.Double(first.getFirst().getX(),
                first.getFirst().getY());
        Point2D.Double bOfFirst = new Point2D.Double(first.getSecond().getX(),
                first.getSecond().getY());

        Point2D.Double aOfSecond = new Point2D.Double(second.getFirst().getX(),
                second.getFirst().getY());
        Point2D.Double bOfSecond = new Point2D.Double(second.getSecond().getX(),
                second.getSecond().getY());

        Rectangle2D.Double firstRect = new Rectangle2D.Double();
        firstRect.add(aOfFirst);
        firstRect.add(bOfFirst);

        Rectangle2D.Double secondRect = new Rectangle2D.Double();
        secondRect.add(aOfSecond);
        secondRect.add(bOfSecond);

        Rectangle2D intersection = firstRect.createIntersection(secondRect);

        return intersection.getHeight() * intersection.getWidth();
    }
}
