package com.epam.university.java.core.task013;

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction current: actions) {
            current.run(figure);
        }
        return figure;
    }

    /* The solution is based on this property:
    *A polygon will be convex if for the vectors that making up it's perimeter
    *the following condition is satisfied:
    *the vector product of neighboring vectors must have the same sign
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        List<Vertex> vertexes = new ArrayList<>(figure.getVertexes());
        int numberOfVertex = vertexes.size();

        // Create array that contains coordinates of vectors
        int[] x = new int[numberOfVertex];
        int[] y = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex - 1; i++) {
            x[i] = vertexes.get(i + 1).getX() - vertexes.get(i).getX();
            y[i] = vertexes.get(i + 1).getY() - vertexes.get(i).getY();
        }
        x[numberOfVertex - 1] = vertexes.get(0).getX() - vertexes.get(numberOfVertex - 1).getX();
        y[numberOfVertex - 1] = vertexes.get(0).getY() - vertexes.get(numberOfVertex - 1).getY();

        // The vector product for first and last vectors
        int t = x[numberOfVertex - 1] * y[0] - x[0] * y[numberOfVertex - 1];
        float z = Math.signum(t);
        float p = 1;
        // Calculating vector products for other vectors
        // If its have different signs the polygon is not convex
        for (int i = 0; i < vertexes.size() - 1; i++) {
            int r = x[i] * y[i + 1] - x[i + 1] * y[i];
            p = p * z * Math.signum(r);
            if (p < 0.0) {
                return false;
            }
        }
        return true;
    }
}
