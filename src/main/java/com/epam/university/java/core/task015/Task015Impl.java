package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;
import com.epam.university.java.core.utils.geometricprimitives.Line2D;
import com.epam.university.java.core.utils.geometricprimitives.Polygon2D;

import java.util.*;

/**
 * Class implements Task015.
 */
public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square squareFirst, Square squareSecond) {
        Validator.validateNotNull(squareFirst, squareSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);

        //searching intersection points
        Stack<Point2D> pointsFirstSquare = ((SquareImpl) squareFirst)
                .getPoints();
        Stack<Point2D> pointsSecondSquare = ((SquareImpl) squareSecond)
                .getPoints();
        Polygon2D tempIntersectionPolygon;
        Set<Point2D> tempIntersectionSet = new LinkedHashSet<>();
        Line2D tempSideFirst = null;
        Line2D tempSideSecond = null;
        Point2D tempIntersectionPoint = null;
        for (int i = 0; i < pointsFirstSquare.size(); i++) {
            for (int j = 0; j < pointsSecondSquare.size(); j++) {
                if (i == pointsFirstSquare.size() - 1) {
                    if (j == pointsSecondSquare.size() - 1) {
                        tempSideSecond = new Line2D(pointsSecondSquare.get(j),
                                pointsSecondSquare.get(0));
                    } else {
                        tempSideFirst = new Line2D(pointsFirstSquare.get(i),
                                pointsFirstSquare.get(0));
                        tempSideSecond = new Line2D(pointsSecondSquare.get(j),
                                pointsSecondSquare.get(0));
                    }
                } else {
                    if (j == pointsSecondSquare.size() - 1) {
                        tempSideSecond = new Line2D(pointsSecondSquare.get(j),
                                pointsSecondSquare.get(0));
                    } else {
                        tempSideFirst = new Line2D(pointsFirstSquare.get(i),
                                pointsFirstSquare.get(i + 1));
                        tempSideSecond = new Line2D(pointsSecondSquare.get(j),
                                pointsSecondSquare.get(j + 1));
                    }
                }
                tempIntersectionPoint = tempSideFirst.intersectionPoint
                        (tempSideSecond,true);
                if (tempIntersectionPoint != null) {
                    tempIntersectionSet.add(tempIntersectionPoint);
                }
            }
        }

        //check internal figures
        for (int i = 0; i < getInternal(squareFirst, squareSecond).length;
             i++) {
            tempIntersectionSet.add(getInternal(squareFirst, squareSecond)[i]);
        }
        for (int i = 0; i < getInternal(squareSecond, squareFirst).length;
             i++) {
            tempIntersectionSet.add(getInternal(squareSecond, squareFirst)[i]);
        }

        if (tempIntersectionSet.size() == 0) {
            return 0;
        }
        tempIntersectionPolygon = new Polygon2D();
        tempIntersectionPolygon.addAll((tempIntersectionSet).toArray(new
                Point2D[0]));
        Point2D[] intersectionPointsOrdered = (new GrahamScan
                (tempIntersectionPolygon.getPoints2D())).getHull2D();
        tempIntersectionPolygon = new Polygon2D();
        tempIntersectionPolygon.addAll(intersectionPointsOrdered);
        //calculating area
        return tempIntersectionPolygon.area();
    }

    /**
     * Get internal points of each square in another one.
     */
    public Point2D[] getInternal(Square squareFirst, Square squareSecond) {
        Validator.validateNotNull(squareFirst, squareSecond,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        ArrayList<Point2D> tempInternalPoints = new ArrayList<>();
        Polygon2D polygonFirstSquare = new Polygon2D();
        Point2D[] pointsFirstSquareTemp = ((SquareImpl) squareFirst)
                .getPoints2D();
        for (int i = 0; i < pointsFirstSquareTemp.length; i++) {
            polygonFirstSquare.add(pointsFirstSquareTemp[i]);
        }
        Point2D[] pointsSecondSquare = ((SquareImpl) squareSecond)
                .getPoints2D();
        for (int i = 0; i < pointsSecondSquare.length; i++) {
            if (polygonFirstSquare.contains(pointsSecondSquare[i])) {
                tempInternalPoints.add(pointsSecondSquare[i]);
            }
        }
        return tempInternalPoints.toArray(new Point2D[0]);
    }
}