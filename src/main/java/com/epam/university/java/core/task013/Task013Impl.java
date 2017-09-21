package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Work with polygons.
 */
public class Task013Impl implements Task013 {

    /**
     * Invoke actions with <code>figure</code> instance.
     *
     * @param figure source figure
     * @param actions collection of actions
     * @return modified figure
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        actions.forEach(a -> a.run(figure));
        return figure;
    }

    /**
     * Check if figure is convex polygon. Convex polygon is a simple polygon in which
     * no line segment between two points on the boundary goes outside the polygon.
     * Compute the convex hull @see <a href="https://stackoverflow.com/a/1881201">
     *     StackOverflow explanation</a>
     * @param figure figure go check
     * @return is figure convex polygon
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) figure.getVertexes();
        VertexImpl centroid = computeCentroid(vertices);
        vertices.sort(
            (p1, p2) -> {
                int dx1 = p2.getX() - p1.getX();
                int dy1 = p2.getY() - p1.getY();
                double dx2 = centroid.getDoubleX() - p1.getX();
                double dy2 = centroid.getDoubleY() - p1.getY();
                return Double.compare(dx1 * dy2, dy1 * dx2);
            }
        );
        boolean gotNegative = false;
        boolean gotPositive = false;
        int numPoints = vertices.size();
        for (int a = 0; a < numPoints; a++) {
            int b = (a + 1) % numPoints;
            int c = (b + 1) % numPoints;
            double crossProduct = crossProductLength(
                vertices.get(a).getX(),
                vertices.get(a).getY(),
                vertices.get(b).getX(),
                vertices.get(b).getY(),
                vertices.get(c).getX(),
                vertices.get(c).getY()
            );
            if (crossProduct < 0) {
                gotNegative = true;
            } else if (crossProduct > 0) {
                gotPositive = true;
            }
            if (gotNegative && gotPositive) {
                return false; // convex if all z coordinates are positive or all are negative
            }
        }
        return true;
    }

    /**
     * Compute z coordinate of the cross product of vertices.
     *
     * @see <a href="https://stackoverflow.com/a/1881201">StackOverflow explanation</a>
     * @param ax x coord of the first vertex
     * @param ay y coord of the first vertex
     * @param bx x coord of the second vertex
     * @param by y coord of the second vertex
     * @param cx x coord of the third vertex
     * @param cy y coord of the third vertex
     * @return z coord of the cross product
     */
    private double crossProductLength(double ax, double ay,
                                      double bx, double by,
                                      double cx, double cy) {
        double abx = ax - bx;
        double aby = ay - by;
        double cbx = cx - bx;
        double cby = cy - by;
        return (abx * cby - aby * cbx); // z coordinate of the cross product
    }

    /**
     * Compute centroid point of the polygon.
     * @see <a href="https://en.wikipedia.org/wiki/Centroid#Centroid_of_a_polygon">
     *     Wikipedia Centroid of a polygon</a>
     *
     * @param vertices list of vertices
     * @return centroid point
     */
    private VertexImpl computeCentroid(List<Vertex> vertices) {
        int vertexCount = vertices.size();
        VertexImpl centroid = new VertexImpl(0.0D, 0.0D);
        double signedArea = 0.0D;

        for (int i = 0; i < vertexCount - 1; ++i) {
            double x0 = vertices.get(i).getX(); // current vertex x
            double y0 = vertices.get(i).getY(); // current vertex y
            double x1 = vertices.get(i + 1).getX(); // next vertex x
            double y1 = vertices.get(i + 1).getY(); // next vertex y
            double a = x0 * y1 - x1 * y0; // partial signed area
            signedArea += a;
            centroid.setX(centroid.getDoubleX() + (x0 + x1) * a);
            centroid.setY(centroid.getDoubleY() + (y0 + y1) * a);
        }
        if (signedArea != 0) { // avoid Infinity in the result
            signedArea *= 0.5;
            centroid.setX(centroid.getDoubleX() / (6.0 * signedArea));
            centroid.setY(centroid.getDoubleY() / (6.0 * signedArea));
        }
        return centroid;
    }

}
