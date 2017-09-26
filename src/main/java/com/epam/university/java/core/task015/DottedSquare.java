package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр on 24.09.2017.
 * My square with chess and tea.
 */
public class DottedSquare {
    private ArrayList<Point> vertices;

    DottedSquare(Point first, Point second) {
        verticesInit(first, second);
    }

    DottedSquare(Square square) {
        verticesInit(square.getFirst(), square.getSecond());
    }

    /**
     * Get square vertices.
     *
     * @return square vertices
     */
    public ArrayList<Point> getVertices() {
        return vertices;
    }

    /**
     * Set square vertices.
     *
     * @param vertices of square
     */
    public void setVertices(ArrayList<Point> vertices) {
        this.vertices = vertices;
    }


    /**
     * Init ArrayList of square vertices.
     *
     * @param first point of diagonal
     * @param second point of diagonal
     */
    private void verticesInit(Point first, Point second) {
        Point center = new PointImpl((first.getX() + second.getX()) / 2,
                (first.getY() + second.getY()) / 2);

        vertices = new ArrayList<>(4);
        vertices.add(0, first);
        vertices.add(1, getPoints(center, second, Math.PI / 2));
        vertices.add(2, second);
        vertices.add(3, getPoints(center, second,Math.PI * 3 / 2));
    }

    /**
     * Rotste point around axis for angle.
     *
     * @param axis point
     * @param currPoint point to rotate
     * @param angle num from -PI to PI
     * @return new point after rotating
     */
    private Point getPoints(Point axis, Point currPoint, double angle) {

        //shift the origin of coordinates to axis
        double tempX = currPoint.getX() - axis.getX();
        double tempY = currPoint.getY() - axis.getY();

        //rotate
        double resultX = tempX * Math.cos(angle) - tempY * Math.sin(angle);
        double resultY = tempX * Math.sin(angle) + tempY * Math.cos(angle);

        //shift the origin of coordinates to 0, 0
        resultX += axis.getX();
        resultY += axis.getY();

        return new PointImpl(resultX, resultY);
    }

    /**
     * Get square edges.
     * @return collection of LineSegment
     */
    public List<LineSegment> getEdges() {
        List<LineSegment> result = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            result.add(new LineSegment(vertices.get(i), vertices.get((i + 1) % 4)));
        }

        return result;
    }

    /**
     * Method returns true, when Point inside squere.
     * @param point to check
     * @return true when inside
     */
    public boolean isInside(Point point) {
        boolean count = false;
        ArrayList<Point> vertices = this.getVertices();

        for (int i = 0, j = 4 - 1; i < 4; j = i++) {
            if ((((vertices.get(i).getY() <= point.getY())
                    && (point.getY() < vertices.get(j).getY()))
                    || ((vertices.get(j).getY() <= point.getY())
                    && (point.getY() < vertices.get(i).getY())))

                    && (point.getX() > (vertices.get(j).getX() - vertices.get(i).getX())
                    * (point.getY() - vertices.get(i).getY())
                    / (vertices.get(j).getY() - vertices.get(i).getY())
                    + vertices.get(i).getX())) {
                count = !count;
            }
        }

        return count;
    }
}
