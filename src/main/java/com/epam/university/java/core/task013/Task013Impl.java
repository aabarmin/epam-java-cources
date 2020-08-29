package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) figure.getVertexes();
        ArrayList<Vertex> sortedVerticies = sortVerticies(vertices);
        boolean gotNegative = false;
        boolean gotPositive = false;
        int numPoints = sortedVerticies.size();
        int b;
        int c;
        for (int a = 0; a < numPoints; a++) {
            b = (a + 1) % numPoints;
            c = (b + 1) % numPoints;

            int crossProduct =
                    crossProductLength(
                            sortedVerticies.get(a)
                                           .getX(), sortedVerticies.get(a)
                                                                   .getY(),
                            sortedVerticies.get(b)
                                           .getX(), sortedVerticies.get(b)
                                                                   .getY(),
                            sortedVerticies.get(c)
                                           .getX(), sortedVerticies.get(c)
                                                                   .getY());
            if (crossProduct < 0) {
                gotNegative = true;
            } else if (crossProduct > 0) {
                gotPositive = true;
            }
            if (gotNegative && gotPositive) {
                return false;
            }
        }
        return true;
    }

    private int crossProductLength(int ax, int ay, int bx, int by, int cx, int cy) {
        int aBx = bx - ax;
        int aBy = by - ay;
        int aCx = cx - ax;
        int aCy = cy - ay;
        return aBx * aCy - aBy * aCx;
    }

    /**
     * Find center vertex.
     * @param vertices list of vertexes
     * @return center vertex
     */
    public VertexImpl findCentroid(ArrayList<Vertex> vertices) {
        int x = 0;
        int y = 0;
        for (Vertex p : vertices) {
            x += p.getX();
            y += p.getY();
        }
        VertexImpl center = new VertexImpl(0, 0);
        center.setX(x / vertices.size());
        center.setX(y / vertices.size());
        return center;
    }

    /**
     * Sort vertices clockwise.
     * @param vertices list of vertices
     * @return sorted list of vertices
     */
    public ArrayList<Vertex> sortVerticies(ArrayList<Vertex> vertices) {
        VertexImpl center = findCentroid(vertices);
        vertices.sort((a, b) -> {
            double a1 =
                    (Math.toDegrees(Math.atan2(a.getX() - center.getX(), a.getY() - center.getY()))
                            + 360) % 360;
            double a2 =
                    (Math.toDegrees(Math.atan2(b.getX() - center.getX(), b.getY() - center.getY()))
                            + 360) % 360;
            return (int) (a1 - a2);
        });
        return vertices;
    }
}
