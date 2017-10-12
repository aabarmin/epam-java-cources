package com.epam.university.java.core.utils.geometricprimitives;

import com.epam.university.java.core.utils.common.Validator;

import java.util.HashMap;
import java.util.Map;

/**
 * Class implements line in two-dimensional plane.
 */
public class Line2D {
    private Point2D pointFirst;
    private Point2D pointSecond;
    private boolean isSegment;

    /**
     * Initialisation of line.
     *
     * @param pointFirst  one of points of the line
     * @param pointSecond one of points of the line
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public Line2D(Point2D pointFirst, Point2D pointSecond) {
        Validator.validateNotNull(pointFirst, pointSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        this.pointFirst = pointFirst;
        this.pointSecond = pointSecond;
    }

    /**
     * Get <code>pointFirst</code>.
     *
     * @return <code>Point2D</code> first point
     */
    public Point2D getPointFirst() {
        return pointFirst;
    }

    /**
     * Set <code>pointFirst</code>.
     *
     * @param pointFirst first point
     * @throws IllegalArgumentException if argument is null
     */
    public void setPointFirst(Point2D pointFirst) {
        Validator.validateNotNull(pointFirst, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        this.pointFirst = pointFirst;
    }

    /**
     * Get <code>pointSecond</code>.
     *
     * @return <code>Point2D</code> - second point
     */
    public Point2D getPointSecond() {
        return pointSecond;
    }

    /**
     * Set <code>pointSecond</code>.
     *
     * @param pointSecond first point
     * @throws IllegalArgumentException if argument is null
     */
    public void setPointSecond(Point2D pointSecond) {
        Validator.validateNotNull(pointSecond, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        this.pointSecond = pointSecond;
    }

    /**
     * Find intersection point of <code>this</code> line and
     * <code>lineSecond</code>.
     *
     * @param lineSecond second line
     * @return <code>Point2D</code> intersection point
     * @throws IllegalArgumentException if argument is null
     */
    public Point2D intersectionPoint(Line2D lineSecond, boolean isSegment) {
        Validator.validateNotNull(lineSecond, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);

        // first line represented as a1x + b1y = c1
        double firstA = getCanonicalParameters().get("parameterA");
        double firstB = getCanonicalParameters().get("parameterB");
        double firstC = getCanonicalParameters().get("parameterC");

        // second line represented as a2x + b2y = c2
        double secondA = lineSecond.getCanonicalParameters().get(
                "parameterA");
        double secondB = lineSecond.getCanonicalParameters().get(
                "parameterB");
        double secondC = lineSecond.getCanonicalParameters().get(
                "parameterC");
        double determinant = firstA * secondB - secondA * firstB;

        if (determinant == 0) {
            // The lines are parallel. This is simplified by returning null
            return null;
        } else {
            double intersectionX = (secondB * firstC - firstB * secondC)
                    / determinant;
            double intersectionY = (firstA * secondC - secondA * firstC)
                    / determinant;
            //check that intersection point belongs to the segments
            if (isSegment) {
                Point2D tempIntersectionPoint = new Point2D(intersectionX,
                        intersectionY);
                if (this.isInSegmentRange(tempIntersectionPoint)
                        && lineSecond.isInSegmentRange(tempIntersectionPoint)) {
                    return tempIntersectionPoint;
                }
                return null;
            } else {
                return new Point2D(intersectionX, intersectionY);
            }
        }
    }

    /**
     * Check if point belongs to range of line segment.
     *
     * @param pointToCheck point to check
     * @return <code>boolean</code> true if point belongs to the range
     * @throws IllegalArgumentException if <code>pointToCheck</code> is null
     */
    public boolean isInSegmentRange(Point2D pointToCheck) {
        Validator.validateNotNull(pointToCheck, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        if (((Math.min(this.pointFirst.getCoordinateX(), this.pointSecond
                .getCoordinateX()) <= pointToCheck.getCoordinateX())
                && (pointToCheck.getCoordinateX() <= Math.max(this.pointFirst
                .getCoordinateX(), this.pointSecond.getCoordinateX())))
                && ((Math.min(this.pointFirst.getCoordinateY(), this.pointSecond
                .getCoordinateY()) <= pointToCheck.getCoordinateY())
                && (pointToCheck.getCoordinateY() <= Math.max(this.pointFirst
                .getCoordinateY(), this.pointSecond.getCoordinateY())))) {
            return true;
        }
        return false;
    }

    /**
     * Get canonical parameters for <code>this</code> line.
     *
     * @return <code>Map</code> with parameters
     */
    public Map<String, Double> getCanonicalParameters() {
        Map<String, Double> canonicalParameters = new HashMap<>();
        // first line represented as a1x + b1y = c1
        canonicalParameters.put("parameterA", this.pointSecond.getCoordinateY()
                - this.pointFirst.getCoordinateY());
        canonicalParameters.put("parameterB", this.pointFirst.getCoordinateX()
                - this.pointSecond.getCoordinateX());
        canonicalParameters.put("parameterC", canonicalParameters.get(
                "parameterA") * (this.pointFirst.getCoordinateX())
                + canonicalParameters.get("parameterB") * (this.pointFirst
                .getCoordinateY()));
        return canonicalParameters;
    }

    /**
     * Get angle with given three sides.
     *
     * @param adjacentLineFirst  first side that is adjacent with the wanted
     *                           angle
     * @param adjacentLineSecond second side that is adjacent with the wanted
     *                           angle
     * @param opposingLine       side that is opposing to wanted angle
     * @return <code>double</code> that is the wanted angle
     * @throws IllegalArgumentException is at least one of arguments is null
     */
    public static double getAngle(Line2D adjacentLineFirst, Line2D
            adjacentLineSecond, Line2D opposingLine) {
        Validator.validateNotNull(adjacentLineFirst, adjacentLineSecond,
                opposingLine, Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_THIRD_PARAMETER_IF_NULL);
        double adjacentLineFirstLength = adjacentLineFirst.getLength();
        double adjacentLineSecondLength = adjacentLineSecond.getLength();
        double opposingLineLength = opposingLine.getLength();
        return Math.acos((Math.pow(adjacentLineFirstLength, 2.0) + Math.pow(
                adjacentLineSecondLength, 2) - Math.pow(opposingLineLength,
                2.0)) / (2.0 * adjacentLineFirstLength
                * adjacentLineSecondLength));
    }

    /**
     * Get length of the line segment.
     *
     * @return <code>double</code> that is the wanted length
     */
    public double getLength() {
        return Math.pow(Math.pow(this.pointFirst.getCoordinateX() - this
                .pointSecond.getCoordinateX(), 2) + Math.pow(this
                .pointFirst.getCoordinateY() - this.pointSecond
                .getCoordinateY(), 2), 0.5);
    }

    @Override
    public String toString() {
        return "Line2D{" + "pointFirst=" + pointFirst + System.lineSeparator()
                + ", pointSecond=" + pointSecond + '}';
    }
}