package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task015Impl implements Task015 {

    /**
     * Get area of intersection of two squares. Squares are defined as two
     * opposite points in 2-dimensional area.
     * <p>
     * <p>
     * Example:
     * square 1 = (2, 2) and (4, 4)
     * square 2 = (3, 3) and (5, 5)
     * area is 1 = square (3, 3) and (4, 4)
     * </p>
     * <p>
     * Tip: paint it in the notebook.
     * </p>
     *
     * @param first  first square definition
     * @param second second square definition
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        List<Point> firstSquarePoints = Geometry.getAllSquarePoints(first);
        List<Point> secondSquarePoints = Geometry.getAllSquarePoints(second);
        List<Point> intersectionPoints = Geometry.getSquaresIntersectionPoints(firstSquarePoints,
                secondSquarePoints);

        if (intersectionPoints.size() == 0) {
            return 0;
        }

        Set<Point> intersectionPolygonPoints = new HashSet<>();
        intersectionPolygonPoints.addAll(intersectionPoints);
        intersectionPolygonPoints.addAll(Geometry.getSquareInternalPoints(firstSquarePoints,
                secondSquarePoints));
        intersectionPolygonPoints.addAll(Geometry.getSquareInternalPoints(secondSquarePoints,
                firstSquarePoints));

        List<Point> polygonPoints = new ArrayList<>(intersectionPolygonPoints);
        List<Point> clockwisePoints = Geometry.getClockwiseOrderedPolygonPoints(polygonPoints);

        // Algorithm to find the area of a polygon source:
        // http://www.mathopenref.com/coordpolygonarea2.html
        double area = 0;
        int j = clockwisePoints.size() - 1;

        for (int i = 0; i < clockwisePoints.size(); i++) {
            area = area +
                    (clockwisePoints.get(j).getX() + clockwisePoints.get(i).getX()) *
                            (clockwisePoints.get(j).getY() - clockwisePoints.get(i).getY());
            j = i;
        }

        return area / 2;

    }

}
