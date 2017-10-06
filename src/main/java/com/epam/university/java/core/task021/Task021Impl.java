package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactory;
import com.epam.university.java.core.task015.PointFactoryImpl;
import com.epam.university.java.core.task015.PointImpl;

import java.util.ArrayList;
import java.util.Collection;

public class Task021Impl implements  Task021 {

    public double cos(Point point1, Point point2, Point point3) {
        Point vector1= new PointImpl(point2.getX()-point1.getX(), point2.getY()-point1.getY());
        Point vector2= new PointImpl(point3.getX()-point1.getX(), point3.getY()-point1.getY());
        double mult = vector1.getX()*vector2.getX() + vector1.getY()*vector2.getY();

        double mod1 = Math.sqrt(Math.pow(vector1.getX(),2)+Math.pow(vector1.getY(),2));
        double mod2 = Math.sqrt(Math.pow(vector2.getX(),2)+Math.pow(vector2.getY(),2));
        return mult/(mod1*mod2);

    }

    public double angle(Point point1, Point point2, Point point3){
        return   Math.acos(cos( point1,  point2,  point3) * 180 / Math.PI);
    }



    public double VectorLength(Point point1, Point point2){
        Point vector1= new PointImpl(point2.getX()-point1.getX(), point2.getY()-point1.getY());
        double mod1 = Math.sqrt(Math.pow(vector1.getX(),2)+Math.pow(vector1.getY(),2));
        return mod1;
    }



    private Point[] thirdPointsOfEquilateralTriangle(Point first, Point second) {
        double x1 = (first.getX() + second.getX()
                + Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double x2 = (first.getX() + second.getX()
                - Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double y1 = (first.getY() + second.getY()
                - Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        double y2 = (first.getY() + second.getY()
                + Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        PointFactory factory = new PointFactoryImpl();
        return new Point[]{
                factory.newInstance(x1, y1),
                factory.newInstance(x2, y2)
        };
    }
    /**
     * Determines the relative position of a point
     * <code>b</code> andvector [<code>a1</code>,<code>a2</code>.
     * if metric < 0 point is to the left side of vector
     * if metric > 0 point is to the right side of vector
     * if metric =0  point lies on the vector of it's forming line
     *
     * @param a1 vector's starting point
     * @param a2 vector's ending point
     * @param b  point b
     * @return value of metric
     */
    private double metric(Point a1, Point a2, Point b) {
        return (b.getX() - a1.getX()) * (a2.getY() - a1.getY())
                - (b.getY() - a1.getY()) * (a2.getX() - a1.getX());
    }

    /**
     * Select lefthand point for vector from first to second points
     * @param first first point of vector
     * @param second second point of vector
     * @param candidatePoints calculated points of eq triangle
     * @return lefthand point of eq triangle
     */
    private Point correctThirdPointOfEqTriangle(Point first, Point second, Point[] candidatePoints){
        for (Point candidate:candidatePoints) {
            if (metric(first,second,candidate)>0){
                return candidate;
            }
        }
        return null;
    }






    /**
     * Finds the intersection coordinate x of lines (line1Point1, line1Point2)
     * and (line2Point1, line2Point2).
     *
     * @param line1Point1 first point of line 1
     * @param line1Point2 second point of line 1
     * @param line2Point1 first point of line 2
     * @param line2Point2 second point of line 2
     * @return x coordinate of intersection
     */
    private double intersectionX(Point line1Point1, Point line1Point2,
                                 Point line2Point1, Point line2Point2) {

        return ((line1Point1.getX() * line1Point2.getY()
                - line1Point1.getY() * line1Point2.getX())
                * (line2Point1.getX() - line2Point2.getX())
                - (line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getX() * line2Point2.getY()
                - line2Point1.getY() * line2Point2.getX()))
                / ((line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() - line2Point2.getX()));
    }

    /**
     * Finds the intersection coordinate y of lines (line1Point1, line1Point2)
     * and (line2Point1, line2Point2).
     *
     * @param line1Point1 first point of line 1
     * @param line1Point2 second point of line 1
     * @param line2Point1 first point of line 2
     * @param line2Point2 second point of line 2
     * @return y coordinate of intersection
     */
    private double intersectionY(Point line1Point1, Point line1Point2,
                                 Point line2Point1, Point line2Point2) {

        return ((line1Point1.getX() * line1Point2.getY()
                - line1Point1.getY() * line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() * line2Point2.getY()
                - line2Point1.getY() * line2Point2.getX()))
                / ((line1Point1.getX() - line1Point2.getX())
                * (line2Point1.getY() - line2Point2.getY())
                - (line1Point1.getY() - line1Point2.getY())
                * (line2Point1.getX() - line2Point2.getX()));
    }
    @Override
    public Point calculate(Collection<Point> minePositions) {
       ArrayList<Point> list = new ArrayList<>(minePositions);
        Point aPoint = list.get(0);
        Point bPoint = list.get(1);
        Point cPoint = list.get(2);


        if( angle(aPoint,bPoint,cPoint) > 120) {
            return bPoint;
        }
        if( angle(bPoint,cPoint,aPoint) > 120) {
            return cPoint;
        }
        if( angle(cPoint,aPoint,bPoint) > 120) {
            return cPoint;
        }

        Point[] candidatePoints = thirdPointsOfEquilateralTriangle(aPoint,bPoint);


        Point ccPoint = correctThirdPointOfEqTriangle(aPoint,
                                                      bPoint,
                                                      candidatePoints);
        candidatePoints = thirdPointsOfEquilateralTriangle(bPoint,cPoint);
        Point aaPoint = correctThirdPointOfEqTriangle(bPoint,
                cPoint,
                candidatePoints);
        double x = intersectionX(aaPoint,aPoint, ccPoint,cPoint);
        double y = intersectionY(aaPoint,aPoint,ccPoint ,cPoint);
        return new PointImpl(x,y);

    }
}
