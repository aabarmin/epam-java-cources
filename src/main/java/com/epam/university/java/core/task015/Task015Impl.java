package com.epam.university.java.core.task015;

import org.locationtech.jts.awt.PointShapeFactory;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

public class Task015Impl implements Task015 {
    @Override
    public double getArea(Square first, Square second) {
        /*Rectangle rectangle = new Rectangle();
        rectangle
        Shape s;
        Area area = new Area();*/

        Path2D.Double p = new Path2D.Double();
        p.moveTo(1,3);
        p.lineTo(5,3);
        p.lineTo(3,3);
        p.lineTo(3,5);
        p.closePath();
        Rectangle2D req = p.getBounds2D();




        /*GeometryFactory factory;
        Collection geomList;
        Geometry geometry = factory.buildGeometry(geomList);*/
        /*if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        List<Point> firstSquarePoints = Geometry.getAllSquarePoints(first);
        List<Point> secondSquarePoints = Geometry.getAllSquarePoints(second);
        // Could be no intersection points, if one square inside another
        List<Point> intersectionPoints = Geometry.getSquaresIntersectionPoints(firstSquarePoints,
                secondSquarePoints);

        Set<Point> intersectionPolygonPoints = new HashSet<>();
        intersectionPolygonPoints.addAll(intersectionPoints);
        intersectionPolygonPoints.addAll(Geometry.getSquareInternalPoints(firstSquarePoints,
                secondSquarePoints));
        intersectionPolygonPoints.addAll(Geometry.getSquareInternalPoints(secondSquarePoints,
                firstSquarePoints));

        if (intersectionPolygonPoints.size() == 0) {
            return 0;
        }

        List<Point> polygonPoints = new ArrayList<>(intersectionPolygonPoints);
        List<Point> clockwisePoints = Geometry.getClockwiseOrderedPolygonPoints(polygonPoints);

        // Algorithm to find the area of a polygon source:
        // http://www.mathopenref.com/coordpolygonarea2.html
        double area = 0;
        int j = clockwisePoints.size() - 1;

        for (int i = 0; i < clockwisePoints.size(); i++) {
            area = area
                    + (clockwisePoints.get(j).getX() + clockwisePoints.get(i).getX())
                    * (clockwisePoints.get(j).getY() - clockwisePoints.get(i).getY());
            j = i;
        }

        return area / 2;*/

        /*PointImpl firstForFirst = (PointImpl) first.getFirst();
        PointImpl secondForFirst = (PointImpl) first.getSecond();
        PointImpl firstForSecond = (PointImpl) second.getFirst();
        PointImpl secondForSecond = (PointImpl) second.getSecond();

        double x11 = firstForFirst.getX();
        double x12 = secondForFirst.getX();
        double y11 = firstForFirst.getY();
        double y12 = secondForFirst.getY();

        double x21 = firstForSecond.getX();
        double x22 = secondForSecond.getX();
        double y21 = firstForSecond.getY();
        double y22 = secondForSecond.getY();

        *//*if (x12 < x21) {
            return 0;
        }*//*

        double newFirstX1 = (x11 + x12 + y12 - y11) / 2;
        double newFirstY1 = (y11 + y12 + x11 - x12) / 2;

        double newFirstX2 = (x11 + x12 + y11 - y12) / 2;
        double newFirstY2 = (y11 + y12 + x12 - x11) / 2;



        double newSecondX = (x21 + x22 + y22 - y21) / 2;
        double newSecondY = (y21 + y22 + x21 - x22) / 2;

        double firstSide = Math.sqrt(Math.pow(x11 - newFirstX , 2) + Math.pow(y11 - newFirstY, 2));
        double secondSide = Math.sqrt(Math.pow(x21 - newSecondX , 2) + Math.pow(y21 - newSecondY, 2));

        double firstSquare = firstSide * firstSide;
        double secondSquare = secondSide * secondSide;

        if (firstSquare > secondSquare || secondSquare > firstSquare) {
            return Math.abs(firstSquare - secondSquare);
        } */
        return  0;
    }

}
