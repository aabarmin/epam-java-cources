package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;
import com.epam.university.java.core.utils.geometricprimitives.Line2D;
import com.epam.university.java.core.utils.geometricprimitives.Polygon2D;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        //find intersection points
        Point2D[] pointsFirstSquare = ((SquareImpl) first).getPoints()
                .toArray(new Point2D[0]);
        Line2D[] sidesFirstSquare = verticesToLines(pointsFirstSquare);
        Point2D[] pointsSecondSquare = ((SquareImpl) second).getPoints()
                .toArray(new Point2D[0]);
        Line2D[] sidesSecondSquare = verticesToLines(pointsSecondSquare);
        Point2D[] intersections = findIntersections(sidesFirstSquare,
                sidesSecondSquare, true);

        //get internal vertices
        Set<Point2D> internalVertices = findInternalAll(first, second);

        if (internalVertices.size() == 0 && intersections.length == 0) {
            return 0;
        }

        //calculating area
        Polygon2D tempIntersectionPolygon2D = new Polygon2D();
        tempIntersectionPolygon2D.addAll(intersections);
        tempIntersectionPolygon2D.addAll((internalVertices).toArray(
                new Point2D[0]));
        Point2D[] intersectionPointsOrdered = (new GrahamScan(
                tempIntersectionPolygon2D.getPoints2D())).getHull2D();
        tempIntersectionPolygon2D = new Polygon2D();
        tempIntersectionPolygon2D.addAll(intersectionPointsOrdered);
        return tempIntersectionPolygon2D.area();
    }

    /**
     * Create lines from vertices of two-dimensional polygon.
     *
     * @param vertices array of a polygon's vertices ordered in clock-wise or
     *                 counter clock-wise order
     * @return <code>Line2D[]</code> array of polygon sides ordered in
     * clock-wise or counter clock-wise order
     * @throws IllegalArgumentException if parameter is null
     */
    public Line2D[] verticesToLines(Point2D[] vertices) {
        Validator.validateNotNull(vertices, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        if (vertices.length < 3) {
            throw new IllegalArgumentException("number of points should be "
                    + "more than 2");
        }
        Line2D[] sides = new Line2D[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            if (!(i == vertices.length - 1)) {
                sides[i] = new Line2D(vertices[i], vertices[i + 1]);
                continue;
            }
            sides[i] = new Line2D(vertices[i], vertices[0]);
        }
        return sides;
    }

    /**
     * Find intersections of lines or segments of lines.
     *
     * @param linesFirst  sides of first square
     * @param linesSecond sides of second square
     * @param isSegment   <code>true</code> if searching intersections of the
     *                    segments of line
     * @return <code>Point2D[]</code> array of all intersection points
     * @throws IllegalArgumentException if at least one of lines array is null
     */
    public Point2D[] findIntersections(Line2D[] linesFirst, Line2D[]
            linesSecond, boolean isSegment) {
        Validator.validateNotNull(linesFirst, linesSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        Set<Point2D> intersections = new LinkedHashSet<>();
        Point2D tempPoint = null;
        for (int i = 0; i < linesFirst.length; i++) {
            for (int j = 0; j < linesSecond.length; j++) {
                tempPoint = linesFirst[i].intersectionPoint(linesSecond[j],
                        true);
                if (!(tempPoint == null)) {
                    intersections.add(tempPoint);
                }
            }
        }
        return intersections.toArray(new Point2D[0]);
    }

    /**
     * Find all internal vertices after intersection for one of squares.
     *
     * @param squareFirst  first square
     * @param squareSecond second square
     * @return <code>Point2D[]</code> array of all internal points for
     * <code>squareFirst</code>
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    public Point2D[] findInternal(Square squareFirst, Square squareSecond) {
        Validator.validateNotNull(squareFirst, squareSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        ArrayList<Point2D> tempInternalPoints = new ArrayList<>();
        Polygon2D polygonFirstSquare = new Polygon2D();
        Point2D[] pointsFirstSquareTemp = ((SquareImpl) squareFirst)
                .getPoints2D();
        polygonFirstSquare.addAll(pointsFirstSquareTemp);
        Point2D[] pointsSecondSquare = ((SquareImpl) squareSecond)
                .getPoints2D();
        for (int i = 0; i < pointsSecondSquare.length; i++) {
            if (polygonFirstSquare.contains(pointsSecondSquare[i])) {
                tempInternalPoints.add(pointsSecondSquare[i]);
            }
        }
        return tempInternalPoints.toArray(new Point2D[0]);
    }

    /**
     * Find all internal vertices after intersection for both of squares.
     *
     * @param first  first square
     * @param second second square
     * @return <code>Set</code> of all internal points
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    public Set<Point2D> findInternalAll(Square first, Square second) {
        Validator.validateNotNull(first, second,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        Set<Point2D> internalVertices = new LinkedHashSet<>();

        for (int i = 0; i < findInternal(first, second).length; i++) {
            internalVertices.add(findInternal(first, second)[i]);
        }
        for (int i = 0; i < findInternal(second, first).length; i++) {
            internalVertices.add(findInternal(second, first)[i]);
        }
        return internalVertices;
    }
}