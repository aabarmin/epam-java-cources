package com.epam.university.java.core.task013;

import com.epam.university.java.core.task012.GraphAction;

import java.sql.ClientInfoStatus;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task013Impl implements Task013 {

    /**
     * Invoke actions with <code>figure</code> instance.
     *
     * @param figure  source figure
     * @param actions collection of actions
     * @return modified figure
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }

        actions.forEach((FigureAction f) -> f.run(figure));

        return figure;
    }

    /**
     * Check if figure is convex polygon. Convex polygon is a simple polygon in which
     * no line segment between two points on the boundary goes outside the polygon.
     *
     * <p>The polygon is convex if the vertexesMultiply method returning value are
     * either all positive or all negative for each consecutive pair of edges of the polygon
     * (each triplet of points) . Otherwise the polygon is non-convex.
     *
     * @param figure figure go check
     * @return is figure convex polygon
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }

        List<Vertex> vertexes = (List<Vertex>) figure.getVertexes();

        if (vertexes.size() == 3) {
            return true;
        }

        List<Vertex> sortedVertexes = vertSort(vertexes);
        int a;
        int b;
        int c;

        int currentValueOfVectorMultiply = 0;
        int newValueOfVectorMultiply = 0;
        for (a = 0; a < sortedVertexes.size(); a++) {
            b = (a + 1) % sortedVertexes.size();
            c = (b + 1) % sortedVertexes.size();

            int crossProduct =
                    vertexesMultiply(
                            sortedVertexes.get(a)
                                    .getX(), sortedVertexes.get(a)
                                    .getY(),
                            sortedVertexes.get(b)
                                    .getX(), sortedVertexes.get(b)
                                    .getY(),
                            sortedVertexes.get(c)
                                    .getX(), sortedVertexes.get(c)
                                    .getY());
            if (crossProduct < 0) {
                currentValueOfVectorMultiply = -1;
            } else if (crossProduct > 0) {
                newValueOfVectorMultiply = 1;
            }
            if (currentValueOfVectorMultiply + newValueOfVectorMultiply == 0) {
                return false;
            }
        }
        return true;
    }


    /**
     * Find center vertex.
     *
     * @param vertexes list of vertexes
     * @return center vertex
     */
    public VertexImpl getCenter(List<Vertex> vertexes) {
        int x = 0;
        int y = 0;
        for (Vertex vert : vertexes) {
            x += vert.getX();
            y += vert.getY();
        }
        VertexImpl center = new VertexImpl();
        center.setX(x / vertexes.size());
        center.setY(y / vertexes.size());
        return center;
    }

    /**
     * Sort vertices clockwise.
     *
     * @param vertexes list of vertexes
     * @return sorted list of vertexes
     */
    public List<Vertex> vertSort(List<Vertex> vertexes) {
        VertexImpl center = getCenter(vertexes);
        vertexes.sort((a, b) -> {
            double a1 =
                    (Math.toDegrees(Math.atan2(a.getX() - center.getX(), a.getY() - center.getY()))
                            + 360) % 360;
            double a2 =
                    (Math.toDegrees(Math.atan2(b.getX() - center.getX(), b.getY() - center.getY()))
                            + 360) % 360;
            return (int) (a1 - a2);
        });
        return vertexes;
    }

    /**
     * Giving three vertexes (A, B, C).
     * Multiply vectors between vertexes.
     *
     * @param ax X-coordinate of the vertex A.
     * @param ay Y-coordinate of the vertex A.
     * @param bx X-coordinate of the vertex B.
     * @param by Y-coordinate of the vertex B.
     * @param cx X-coordinate of the vertex C.
     * @param cy Y-coordinate of the vertex C.
     * @return multiplication of vectors (AB, BC).
     */
    public int vertexesMultiply(int ax, int ay, int bx, int by, int cx, int cy) {
        // getting the vectors coordinates
        int dx1 = bx - ax;
        int dy1 = by - ay;
        int dx2 = cx - bx;
        int dy2 = cy - by;

        return (dx1 * dy2 - dy1 * dx2);
    }
}
