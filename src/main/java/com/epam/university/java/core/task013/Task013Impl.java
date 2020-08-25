package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
        List<Integer> xPoints = new ArrayList<>();
        List<Integer> yPoints = new ArrayList<>();

        Collection<Vertex> vertexes = figure.getVertexes();

        for (Vertex vertex : vertexes) {
            xPoints.add(vertex.getX());
            yPoints.add(vertex.getY());
        }

        int maxX = Collections.max(xPoints);
        int maxY = Collections.max(yPoints);
        int minX = Collections.min(xPoints);
        int minY = Collections.min(yPoints);
        int width = maxX - minX;
        int height = maxY - minY;

        for (Vertex vertex : vertexes) {
            int x = vertex.getX();
            int y = vertex.getY();
            int x0 = minX;
            int y0 = minY;

            if (x > x0 && y > y0 && x < x0 + width && y < y0 + height) {
                return false;
            }
        }

        return true;
    }
}
