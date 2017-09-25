package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;
import com.epam.university.java.core.utils.geometricprimitives.Line2D;
import com.epam.university.java.core.utils.geometricprimitives.Polygon;

import java.util.*;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        //searching intersection points
        System.out.println("first: " + first);
        System.out.println("second: " + second);

        Stack<Point2D> pointsFirstSquare = ((SquareImpl) first).getPoints();
        Stack<Point2D> pointsSecondSquare = ((SquareImpl) second).getPoints();
        Polygon tempIntersectionPolygon;
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
                        (tempSideSecond);
                if (tempIntersectionPoint != null) {
                    tempIntersectionSet.add(tempIntersectionPoint);
                }
            }
        }

        System.out.println("Intersections dots: " + tempIntersectionSet
                + System.lineSeparator());
        //check internal figures
        for (int i = 0; i < getInternal(first, second).length; i++) {
            tempIntersectionSet.add(getInternal(first, second)[i]);
        }
        for (int i = 0; i < getInternal(second, first).length; i++) {
            tempIntersectionSet.add(getInternal(second, first)[i]);
        }

        if (tempIntersectionSet.size() == 0) {
            return 0;
        }
        tempIntersectionPolygon = new Polygon();
        tempIntersectionPolygon.addAll((tempIntersectionSet).toArray(new
                Point2D[0]));
        Point2D[] intersectionPointsOrdered = (new GrahamScan
                (tempIntersectionPolygon.getPoints2D())).getHull2D();
        tempIntersectionPolygon = new Polygon();
        tempIntersectionPolygon.addAll(intersectionPointsOrdered);
        System.out.println("polygon: " + tempIntersectionPolygon);
        //calculating area
        return tempIntersectionPolygon.area();
    }

    public Point2D[] getInternal(Square squareFirst, Square squareSecond) {
        ArrayList<Point2D> tempInternalPoints = new ArrayList<>();
        Polygon polygonFirstSquare = new Polygon();
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
