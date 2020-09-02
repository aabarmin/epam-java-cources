package com.epam.university.java.core.task015;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Romin Nuro on 01.09.2020 13:02.
 */
public class PointsComparatorClockwise implements Comparator<Point> {
    private final double startX;
    private final double startY;

    /**
     * Comparator for sorting points clockwise. Important for several methods.
     * @param polygon list of points.
     */
    public PointsComparatorClockwise(List<Point> polygon) {
        if (polygon.size() > 0) {
            Point startPoint = polygon.stream()
                    .min(Comparator.comparing(Point::getX).thenComparing(Point::getY))
                    .orElse(polygon.get(0));
            this.startX = startPoint.getX();
            this.startY = startPoint.getY();
        } else {
            this.startX = 0;
            this.startY = 0;
        }
    }

    @Override
    public int compare(Point o1, Point o2) {
        // comparing angles of vectors from the left bottom point
        // y / x == tg(angle)
        if (o1.getX() - startX == 0 && o1.getY() - startY == 0) {
            return 1;
        }
        if (o2.getX() - startX == 0 && o2.getY() - startY == 0) {
            return -1;
        }
        double tg1 = (o1.getY() - startY) / (o1.getX() - startX);
        double tg2 = (o2.getY() - startY) / (o2.getX() - startX);
        if (tg1 > tg2) {
            return -1;
        } else {
            return 1;
        }
    }
}
