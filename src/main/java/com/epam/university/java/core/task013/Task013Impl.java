package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Vertex> vertices = sortVertices(figure);
        return isConvex(vertices);
    }

    /**
     * Sort vertexes in the order, where one "is left" from another.
     * It's a part of Graham scan algorithm.
     *
     * @param figure source figure
     * @return sorted list of vertices
     */
    public ArrayList<Vertex> sortVertices(Figure figure) {
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) figure.getVertexes();
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(0).getX() > vertices.get(i).getX()) {
                Vertex tmp = vertices.get(0);
                vertices.set(0, vertices.get(i));
                vertices.set(i, tmp);
            }
        }
        for (int i = 1; i < vertices.size(); i++) {
            int j = i;
            while (j > 1 && (metric(vertices.get(0), vertices.get(j - 1), vertices.get(j)) < 0)) {
                Vertex tmp = vertices.get(j);
                vertices.set(j, vertices.get(j - 1));
                vertices.set(j - 1, tmp);
                j--;
            }
        }

        return vertices;

    }

    /**
     * determines if set of vertices forms a convex polygon, using graham scan algorithm.
     * @param vertices set of vertices
     * @return   if set of vertices forms convex polygon
     */
    public boolean isConvex(ArrayList<Vertex> vertices) {
        for (int i = 0; i < vertices.size(); i++) {
            Vertex a1 = vertices.get(i);
            Vertex a2;

            if (i == vertices.size() - 1) {
                a2 = vertices.get(0);
            } else {
                a2 = vertices.get(i + 1);
            }

            Vertex b;
            int flag = 0;
            for (int j = 0; j < vertices.size(); j++) {
                b = vertices.get(j);
                double metricValue = metric(a1, a2, b);
                if (flag == 0) {
                    if (metricValue > 0) {
                        flag = 1;
                    }
                    if (metricValue < 0) {
                        flag = -1;
                    }
                }
                if (metricValue > 0 && flag == -1) {
                    return false;
                }
                if (metricValue < 0 && flag == 1) {
                    return false;
                }
            }
        }
        return true;

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
    public double metric(Vertex a1, Vertex a2, Vertex b) {
        double d = (b.getX() - a1.getX()) * (a2.getY() - a1.getY())
                 - (b.getY() - a1.getY()) * (a2.getX() - a1.getX());
        return d;

    }
}
