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
     * Get area of intersection of two squares by Gauss-formula.
     *
     * @param first first square definition
     * @param second second square definition
     *
     * @return value of area
     */
    @Override
    public double getArea(Square first, Square second) {

        // get intersection area of 1st and 2nd squares
        List<Point> vertexes =
                getIntersectionPoints(getSquareSides(first), getSquareSides(second));

        double area = 0.0d;
        int n = vertexes.size();

        for (int i = 0; i < n - 1; i++) {
            area += ((Double)vertexes.get(i).getX()) * ((Double)vertexes.get(i + 1).getY())
                    - ((Double)vertexes.get(i + 1).getX()) * ((Double)vertexes.get(i).getY());
        }

        if (n > 0) {
            area += ((Double)vertexes.get(n - 1).getX()) * ((Double)vertexes.get(0).getY())
                    - ((Double)vertexes.get(0).getX()) * ((Double)vertexes.get(n - 1).getY());
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
        int vertAx = (Integer)line.getFirst().getX();
        int vertAy = (Integer)line.getFirst().getY();
        int vertCx = (Integer)line.getSecond().getX();
        int vertCy = (Integer)line.getSecond().getY();

        int dx = vertCx - vertAx;
        int dy = vertAy - vertCy;
        int d = (dx - dy) / 2;

        int vertDx = vertAx + d;
        int vertDy = vertCy - d;
        int vertBx = vertCx - d;
        int vertBy = vertAy + d;

        List<Square> retList = new ArrayList<>();
        PointFactoryImpl pointFactory = new PointFactoryImpl();
        SquareFactoryImpl squareFactory = new SquareFactoryImpl();
        Point vertB = pointFactory.newInstance(vertBx, vertBy);
        Point vertD = pointFactory.newInstance(vertDx, vertDy);

        // AB side
        retList.add(squareFactory.newInstance(line.getFirst(), vertB));
        // BC side
        retList.add(squareFactory.newInstance(vertB, line.getSecond()));
        // CD side
        retList.add(squareFactory.newInstance(line.getSecond(), vertD));
        // DA side
        retList.add(squareFactory.newInstance(vertD, line.getFirst()));

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
    private List<Point> getIntersectionPoints(List<Square> first, List<Square> second) {

        List<Point> retList = new ArrayList<>();
        List<Point> setFilter = new ArrayList<>(); // to filter for already added vertexes

        for (Square segment1 : first) {
            for (Square segment2 : second) {

                ///////////////////////////////////////////////////////////////////////////////////
                // look for intersecting segments of squares
                // (х1, у1) and (х2, у2) - first segment coordinates
                // (х3, у3) and (х4, у4) - second segment coordinates
                ///////////////////////////////////////////////////////////////////////////////////

                int x1 = (Integer)segment1.getFirst().getX();
                int y1 = (Integer)segment1.getFirst().getY();

                int x2 = (Integer)segment1.getSecond().getX();
                int y2 = (Integer)segment1.getSecond().getY();

                int x3 = (Integer)segment2.getFirst().getX();
                int y3 = (Integer)segment2.getFirst().getY();

                int x4 = (Integer)segment2.getSecond().getX();
                int y4 = (Integer)segment2.getSecond().getY();

                double sy2 = (y4 - y3);

                //////////////////////////////////////////////////////////////
                // find Collision point
                double s = ((y1 - y2) * (x1 - x3) + (x2 - x1) * (y1 - y3))
                        / ((x3 - x4) * (y2 - y1) + (x2 - x1) * sy2);
                double t = ((x4 - x3) * (y1 - y3) - sy2 * (x1 - x3))
                        / ((x3 - x4) * (y2 - y1) + (x2 - x1) * sy2);

                double x; // x-coordinate of a collision point
                double y; // y-coordinate of a collision point

                PointImpl<Integer> segmentVertex; // end-point of a segment with a collision

                if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
                    // Collision detected at the following coordinates
                    x = x1 + (t * (x2 - x1));
                    y = y1 + (t * (y2 - y1));

                    // check if endpoints of segment 1 is inside the second polygon
                    if (segment1.getFirst() instanceof PointImpl) {
                        segmentVertex = (PointImpl) segment1.getFirst();

                        if (segmentVertex.suspectAsInner()) {
                            setFilter.add(new PointImpl(segmentVertex.getX(),
                                    segmentVertex.getY()));
                            retList.add(new PointImpl(segmentVertex.getX().doubleValue(),
                                    segmentVertex.getY().doubleValue()));
                        }
                    }
                    if (segment1.getSecond() instanceof PointImpl) {
                        segmentVertex = (PointImpl)segment1.getSecond();

                        if (segmentVertex.suspectAsInner()) {
                            setFilter.add(new PointImpl(segmentVertex.getX(),
                                    segmentVertex.getY()));
                            retList.add(new PointImpl(segmentVertex.getX().doubleValue(),
                                    segmentVertex.getY().doubleValue()));
                        }
                    }
                } else {
                    continue;
                }

                // add intersection point
                retList.add(new PointImpl(x, y));

                // check if endpoints of segment 1 is inside the second polygon
                if (segment2.getFirst() instanceof PointImpl) {
                    segmentVertex = (PointImpl) segment2.getFirst();

                    if (segmentVertex.suspectAsInner() && !setFilter.contains(segmentVertex)) {
                        setFilter.add(new PointImpl(segmentVertex.getX(), segmentVertex.getY()));
                        retList.add(new PointImpl(segmentVertex.getX().doubleValue(),
                                segmentVertex.getY().doubleValue()));
                    }
                }
                if (segment2.getSecond() instanceof PointImpl) {
                    segmentVertex = (PointImpl)segment2.getSecond();

                    if (segmentVertex.suspectAsInner() /*&& !setFilter.contains(segmentVertex)*/) {
                        setFilter.add(new PointImpl(segmentVertex.getX(), segmentVertex.getY()));
                        retList.add(new PointImpl(segmentVertex.getX().doubleValue(),
                                segmentVertex.getY().doubleValue()));
                    }
                }
            }
        }

        return retList;
    }
}