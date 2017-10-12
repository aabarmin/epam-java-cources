package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.Line2D;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;
import com.epam.university.java.core.utils.geometricprimitives.Polygon2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class implements <code>Task021</code>.
 */
public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        Validator.validateNotNull(minePositions,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEmpty(minePositions,
                Validator.MESSAGE_IF_COLLECTION_EMPTY);
        Polygon2D triangle = new Polygon2D();
        List<Point2D> vertices = minePositions.parallelStream()
                .map((point) -> ((PointImpl) point).getPoint2D())
                .collect(Collectors.toList());
        triangle.addAll(vertices.toArray(new Point2D[0]));
        List<Line2D> sides = triangle.getSides();
        Collections.sort(sides, Comparator.comparingDouble(Line2D::getLength));
        Line2D biggestSide = sides.get(sides.size() - 1);
        Line2D firstAdjacentSide = sides.get(sides.size() - 2);
        Line2D secondAdjacentSide = sides.get(sides.size() - 3);

        /*check if biggest angle is more than 120 degrees, so the adjacent
         vertex will be the solution*/
        if (Line2D.getAngle(firstAdjacentSide, secondAdjacentSide,
                biggestSide) >= 2.0 * Math.PI / 3.0) {
            if (firstAdjacentSide.getPointFirst().equals(secondAdjacentSide
                    .getPointFirst()) || firstAdjacentSide.getPointFirst()
                    .equals(secondAdjacentSide.getPointSecond())) {
                return new PointImpl(firstAdjacentSide.getPointFirst());
            } else {
                return new PointImpl(firstAdjacentSide.getPointSecond());
            }
        }

        //find pairs of vertex and opposing line
        List<Line2D> sidesToCheck = triangle.getSides();
        Map<Point2D, Line2D> pointAndOpposingSide = new HashMap<>();
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < sidesToCheck.size(); j++) {
                if (!vertices.get(i).equals(sidesToCheck.get(j).getPointFirst())
                        && !vertices.get(i).equals(sidesToCheck.get(j)
                        .getPointSecond())) {
                    pointAndOpposingSide.put(vertices.get(i),
                            sidesToCheck.get(j));
                }
            }
        }

        //create the lines to intersection point
        List<Line2D> linesFermat = new ArrayList<>();
        pointAndOpposingSide.forEach((point, side) -> linesFermat.add(new
                Line2D(point, getEquilateralVertex(side, triangle,
                999999999))));
        List<Point2D> pointsFermat = new ArrayList<>();
        pointsFermat.add(linesFermat.get(0).intersectionPoint(linesFermat.get
                (1), true));
        pointsFermat.add(linesFermat.get(0).intersectionPoint(linesFermat.get
                (2), true));
        pointsFermat.add(linesFermat.get(1).intersectionPoint(linesFermat.get
                (2), true));

        Collections.sort(pointsFermat, Comparator.comparingDouble(
                Point2D::getCoordinateX));
        double coordinateX = pointsFermat.get(1).getCoordinateX();
        Collections.sort(pointsFermat, Comparator.comparingDouble(
                Point2D::getCoordinateY));
        double coordinateY = pointsFermat.get(pointsFermat.size() - 1)
                .getCoordinateY();
        return new PointImpl(coordinateX, coordinateY);
    }

    /**
     * Get the total distance from <code>pointFermat</code> to vertices.
     *
     * @param vertices    the triangle's vertices
     * @param pointFermat Fermat point
     * @return <code>double</code> the total distance
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    public double getDistanceSum(Point2D[] vertices, Point2D pointFermat) {
        Validator.validateNotNull(vertices, pointFermat,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        double distanceSum = 0;
        for (int i = 0; i < vertices.length; i++) {
            distanceSum += new Line2D(vertices[i], pointFermat).getLength();
        }
        return distanceSum;
    }

    /**
     * Get the third vertex of equilateral triangle from the given side.
     *
     * @param side     the triangle's given side
     * @param triangle the triangle
     * @param checker  to check the right vertex
     * @return <code>Point2D</code> the third vertex
     * @throws IllegalArgumentException if at least one of first two parameters
     *                                  is null or checker not in the range from
     *                                  <code>999999999</code> to <code>
     *                                  Double.MAX_VALUE</code>
     */
    private Point2D getEquilateralVertex(Line2D side, Polygon2D triangle,
                                         double checker) {
        Validator.validateNotNull(side, triangle,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        Validator.validateValueRange(checker, 999999999,
                Double.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Point2D thirdPoint = null;
        Point2D pointFirst = side.getPointFirst();
        Point2D pointSecond = side.getPointSecond();
        double parameterA = side.getCanonicalParameters().get("parameterA");
        double parameterB = side.getCanonicalParameters().get("parameterB");

        if (parameterA == 0 || parameterB == 0 | parameterA / (-parameterB)
                > 0) {
            double firstCoordinateX = (pointFirst.getCoordinateX() + pointSecond
                    .getCoordinateX() + Math.sqrt(3.0) * Math.abs(pointFirst
                    .getCoordinateY() - pointSecond.getCoordinateY())
                    / checker) / 2.0;
            double firstCoordinateY = (pointFirst.getCoordinateY() + pointSecond
                    .getCoordinateY() - Math.sqrt(3.0) * Math.abs(pointFirst
                    .getCoordinateX() - pointSecond.getCoordinateX())
                    / checker) / 2.0;
            thirdPoint = new Point2D(firstCoordinateX, firstCoordinateY);
            if (!triangle.contains(thirdPoint)) {
                firstCoordinateX = (pointFirst.getCoordinateX() + pointSecond
                        .getCoordinateX() + Math.sqrt(3.0) * Math.abs(pointFirst
                        .getCoordinateY() - pointSecond.getCoordinateY())) /
                        2.0;
                firstCoordinateY = (pointFirst.getCoordinateY() + pointSecond
                        .getCoordinateY() - Math.sqrt(3.0) * Math.abs(pointFirst
                        .getCoordinateX() - pointSecond.getCoordinateX())) /
                        2.0;
                thirdPoint = new Point2D(firstCoordinateX, firstCoordinateY);
                return thirdPoint;
            }
            double secondCoordinateX = (pointFirst.getCoordinateX()
                    + pointSecond.getCoordinateX() - Math.sqrt(3.0) * Math.abs(
                    pointFirst.getCoordinateY() - pointSecond.getCoordinateY())
                    / checker) / 2.0;
            double secondCoordinateY = (pointFirst.getCoordinateY()
                    + pointSecond.getCoordinateY() + Math.sqrt(3.0) * Math.abs(
                    pointFirst.getCoordinateX() - pointSecond.getCoordinateX())
                    / checker) / 2.0;
            thirdPoint = new Point2D(secondCoordinateX, secondCoordinateY);
            if (!triangle.contains(thirdPoint)) {
                secondCoordinateX = (pointFirst.getCoordinateX()
                        + pointSecond.getCoordinateX() - Math.sqrt(3.0)
                        * Math.abs(pointFirst.getCoordinateY() - pointSecond
                        .getCoordinateY())) / 2.0;
                secondCoordinateY = (pointFirst.getCoordinateY()
                        + pointSecond.getCoordinateY() + Math.sqrt(3.0)
                        * Math.abs(pointFirst.getCoordinateX() - pointSecond
                        .getCoordinateX())) / 2.0;
                thirdPoint = new Point2D(secondCoordinateX, secondCoordinateY);
                return thirdPoint;
            }
        }
        if (parameterA / (-parameterB) < 0) {
            double firstCoordinateX = (pointFirst.getCoordinateX() + pointSecond
                    .getCoordinateX() + Math.sqrt(3.0) * Math.abs(pointFirst
                    .getCoordinateY() - pointSecond.getCoordinateY()) /
                    checker) / 2.0;
            double firstCoordinateY = (pointFirst.getCoordinateY() + pointSecond
                    .getCoordinateY() + Math.sqrt(3.0) * Math.abs(pointFirst
                    .getCoordinateX() - pointSecond.getCoordinateX()) /
                    checker) / 2.0;

            thirdPoint = new Point2D(firstCoordinateX, firstCoordinateY);
            if (!triangle.contains(thirdPoint)) {
                firstCoordinateX = (pointFirst.getCoordinateX() + pointSecond
                        .getCoordinateX() + Math.sqrt(3.0) * Math.abs(pointFirst
                        .getCoordinateY() - pointSecond.getCoordinateY()))
                        / 2.0;
                firstCoordinateY = (pointFirst.getCoordinateY() + pointSecond
                        .getCoordinateY() + Math.sqrt(3.0) * Math.abs(pointFirst
                        .getCoordinateX() - pointSecond.getCoordinateX()))
                        / 2.0;
                thirdPoint = new Point2D(firstCoordinateX, firstCoordinateY);
                return thirdPoint;
            }
            double secondCoordinateX = (pointFirst.getCoordinateX()
                    + pointSecond.getCoordinateX() - Math.sqrt(3.0) * Math.abs(
                    pointFirst.getCoordinateY() - pointSecond.getCoordinateY())
                    / checker) / 2.0;
            double secondCoordinateY = (pointFirst.getCoordinateY()
                    + pointSecond.getCoordinateY() - Math.sqrt(3.0) * Math.abs(
                    pointFirst.getCoordinateX() - pointSecond.getCoordinateX())
                    / checker) / 2.0;
            thirdPoint = new Point2D(secondCoordinateX, secondCoordinateY);
            if (triangle.contains(thirdPoint)) {
                return null;
            }
        }
        return thirdPoint;
    }

    /**
     * Get the position of the biggest triangle's side from the given array of
     * sides.
     *
     * @param sides triangle's sides
     * @return <code>int</code> the position of the biggest side
     * @throws IllegalArgumentException if parameter is null of is empty
     *                                  collection
     */
    public int getMaxSide(List<Line2D> sides) {
        Validator.validateNotNull(sides, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEmpty(sides, Validator.MESSAGE_IF_COLLECTION_EMPTY);
        int maxPosition = 0;
        double tempLinesLength = 0.0;
        double tempMaxLength = -Double.MAX_VALUE;
        for (int i = 0; i < sides.size(); i++) {
            tempLinesLength = sides.get(i).getLength();
            if (tempMaxLength < tempLinesLength) {
                tempMaxLength = tempLinesLength;
                maxPosition = i;
            }
        }
        return maxPosition;
    }
}