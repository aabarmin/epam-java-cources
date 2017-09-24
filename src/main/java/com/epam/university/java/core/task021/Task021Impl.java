package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;
import java.util.Collection;
import com.epam.university.java.core.task015.Geometry;



public class Task021Impl implements Task021 {
    /**
     * <p>
     * There are three mines, position of each is in <code>minePositions</code> collection.
     * You should determine coordinates of the city which will have a factory. It's better
     * to have the shortest distance between mines and city.
     * </p>
     * <p>
     * Example:
     * </p>
     *
     * @param minePositions mines positions
     * @return city city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {

        if (minePositions == null || minePositions.size() != 3) {
            throw new IllegalArgumentException();
        }

        Point[] minePositionsArray = minePositions.toArray(new Point[3]);

        double angle120 = 2*Math.PI / 3;

        if (Geometry.getAngle(minePositionsArray[1], minePositionsArray[2], minePositionsArray[0]) >= angle120) {
            return minePositionsArray[0];
        }

        if (Geometry.getAngle(minePositionsArray[0], minePositionsArray[2], minePositionsArray[1]) >= angle120) {
            return minePositionsArray[1];
        }

        if (Geometry.getAngle(minePositionsArray[0], minePositionsArray[1], minePositionsArray[2]) >= angle120) {
            return minePositionsArray[2];
        }

        Point vertexOppositePoint2 = getEQTriangleVertex(
                minePositionsArray[0],
                minePositionsArray[1],
                minePositionsArray[2]);

        Point vertexOppositePoint1 = getEQTriangleVertex(
                minePositionsArray[0],
                minePositionsArray[2],
                minePositionsArray[1]);


        return Geometry.getLinesIntersectionPoint(vertexOppositePoint2, minePositionsArray[2], vertexOppositePoint1, minePositionsArray[1]);

    }


    private static Point getEQTriangleVertex(
            Point a, Point b, Point o) {

        double dx = b.getX() - a.getX();
        double dy = b.getY() - a.getY();
        double length = Math.sqrt(dx*dx+dy*dy);
        double dirX = dx / length;
        double dirY = dy / length;
        double height = Math.sqrt(3) / 2 * length;
        double cx = a.getX() + dx * 0.5;
        double cy = a.getY() + dy * 0.5;
        double pDirX = -dirY;
        double pDirY = dirX;

       Point point1 = new PointImpl(cx + height * pDirX, cy + height * pDirY);
       Point point2 = new PointImpl(cx - height * pDirX, cy - height * pDirY);

       if ((Math.pow(point1.getX() - o.getX(), 2) +
               Math.pow(point1.getY() - o.getY(), 2)) >
               (Math.pow(point2.getX() - o.getX(), 2) +
                       Math.pow(point2.getY() - o.getY(), 2))) {
            return point1;
        } else {
            return point2;
        }

    }
}
