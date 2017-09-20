package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation class for Task015.
 *
 * @author Sergei Titov
 */
public class Task015Impl implements Task015 {
    /**
     * Get area of intersection of two squares by Gauss-formula
     *
     * @param first first square definition
     * @param second second square definition
     *
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {

        // get intersection area of 1st and 2nd squares
        List<Point<Double>> vertexes =
                getIntersectionPoints(getSquareSides(first), getSquareSides(second));

        double area = 0.0d;
        int n = vertexes.size();

        for (int i = 0; i < n - 1; i++) {
            area += vertexes.get(i).getX() * vertexes.get(i + 1).getY()
                    - vertexes.get(i + 1).getX() * vertexes.get(i).getY();
        }

        if (n > 0) {
            area += vertexes.get(n - 1).getX() * vertexes.get(0).getY()
                    - vertexes.get(0).getX() * vertexes.get(n - 1).getY();
        }

        return area / -2.0d;
    }

    /**
     * Gets coordinates of all the squire's vertexes.
     *
     * @param line - coordinates of diagonal
     *
     * @returns - list with coordinates squire's vertexes
     */
    private List<Square> getSquareSides(Square line) {
        int aX = line.getFirst().getX();
        int aY = line.getFirst().getY();
        int cX = line.getSecond().getX();
        int cY = line.getSecond().getY();

        int dx = cX - aX;
        int dy = aY - cY;
        int d = (dx - dy) / 2;

        int dX = aX + d;
        int dY = cY - d;
        int bX = cX - d;
        int bY = aY + d;

        List<Square> retList = new ArrayList<>();
        PointFactoryImpl<Integer> pointFactory = new PointFactoryImpl();
        SquareFactoryImpl squareFactory = new SquareFactoryImpl();
        Point vertexB = pointFactory.newInstance(bX, bY);
        Point VertexD = pointFactory.newInstance(dX, dY);

        // AB side
        retList.add(squareFactory.newInstance(line.getFirst(), vertexB));
        // BC side
        retList.add(squareFactory.newInstance(vertexB, line.getSecond()));
        // CD side
        retList.add(squareFactory.newInstance(line.getSecond(), VertexD));
        // DA side
        retList.add(squareFactory.newInstance(VertexD, line.getFirst()));

        return retList;
    }

    /**
     * Gets squares' intersection point collection.
     *
     * @param first square corners
     * @param second square corners
     *
     * @returns list of intersection points
     */
    List<Point<Double>> getIntersectionPoints(List<Square> first, List<Square> second) {

        List<Point<Double>> retList = new ArrayList<>();
        List<Point<Double>> setFilter = new ArrayList<>(); // to filter for already added vertexes
        PointFactoryImpl<Double> pointFactory = new PointFactoryImpl();

        for (Square segment1 : first) {
            for (Square segment2 : second) {

                ///////////////////////////////////////////////////////////////////////////////////
                // look for intersecting segments of squares
                // (х1, у1) and (х2, у2) - first segment coordinates
                // (х3, у3) and (х4, у4) - second segment coordinates
                ///////////////////////////////////////////////////////////////////////////////////

                int x1 = segment1.getFirst().getX();
                int y1 = segment1.getFirst().getY();

                int x2 = segment1.getSecond().getX();
                int y2 = segment1.getSecond().getY();

                int x3 = segment2.getFirst().getX();
                int y3 = segment2.getFirst().getY();

                int x4 = segment2.getSecond().getX();
                int y4 = segment2.getSecond().getY();

                //////////////////////////////////////////////////////////////
                // find Collision point
                double s1_x, s1_y, s2_x, s2_y;
                s1_x = x2 - x1;
                s1_y = y2 - y1;
                s2_x = x4 - x3;
                s2_y = y4 - y3;

                double s = (-s1_y * (x1 - x3) + s1_x * (y1 - y3)) / (-s2_x * s1_y + s1_x * s2_y);
                double t = ( s2_x * (y1 - y3) - s2_y * (x1 - x3)) / (-s2_x * s1_y + s1_x * s2_y);

                double x;
                double y;
                if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
                {
                    // Collision detected at the following coordinates
                    x = x1 + (t * s1_x);
                    y = y1 + (t * s1_y);

                    // check if endpoint of segment 1 is inside the second polygon
                    Point<Integer> point = segment1.getFirst();
                    if (point.suspectAsInner() && !setFilter.contains(point)) {
                        PointImpl<Double> pointToAdd = new PointImpl<>(point.getX().doubleValue(),
                                point.getY().doubleValue());
                        setFilter.add( pointToAdd );
                        retList.add( pointToAdd );
                    }
                    point = segment1.getSecond();
                    if (point.suspectAsInner() && !setFilter.contains(point)) {
                        PointImpl<Double> pointToAdd = new PointImpl<>(point.getX().doubleValue(),
                                point.getY().doubleValue());
                        setFilter.add(pointToAdd);
                        retList.add(pointToAdd);
                    }
                } else {
                    continue;
                }

                // add intersection point
                setFilter.add(pointFactory.newInstance(x, y));
                retList.add(pointFactory.newInstance(x, y));

                // check if endpoint of segment 2 is inside the first polygon
                Point<Integer> point = segment2.getFirst();
                if (point.suspectAsInner() && !setFilter.contains(point)) {
                    PointImpl<Double> pointToAdd = new PointImpl<>(point.getX().doubleValue(),
                            point.getY().doubleValue());
                    setFilter.add(pointToAdd);
                    retList.add(pointToAdd);
                }
                point = segment2.getSecond();
                if (point.suspectAsInner() && !setFilter.contains(point)) {
                    PointImpl<Double> pointToAdd = new PointImpl<>(point.getX().doubleValue(),
                            point.getY().doubleValue());
                    setFilter.add(pointToAdd);
                    retList.add(pointToAdd);
                }
            }
        }

        return retList;
    }
}
