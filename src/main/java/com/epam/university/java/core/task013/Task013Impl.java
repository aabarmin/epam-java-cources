package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task013Impl implements Task013 {
    private static Vertex getCentroid2D(Collection<Vertex> points) {
        double sumX = 0;
        double sumY = 0;
        for (Vertex v : points) {
            sumX += v.getX();
            sumY += v.getY();
        }
        final double x = sumX / points.size();
        final double y = sumY / points.size();
        return (new FigureFactoryImpl()).newInstance((int) x, (int) y);
    }


    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        actions.forEach(a -> a.run(figure));
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        final Collection<Vertex> col = figure.getVertexes();
        final Vertex centroid = getCentroid2D(col);
        if (col.size() < 4) {
            return true;
        }
        boolean sign = false;
        final int n = col.size();
        List<Vertex> vertexList = new ArrayList<>(col);
        vertexList.sort((p1, p2) -> {
            final double dx1 = p2.getX() - p1.getX();
            final double dy1 = p2.getY() - p1.getY();
            final double dx2 = centroid.getX() - p1.getX();
            final double dy2 = centroid.getY() - p1.getY();
            return Double.compare(dx1 * dy2, dy1 * dx2);
        });

        for (int i = 0; i < n; i++) {
            final double dx1 = vertexList.get((i + 2) % n).getX()
                    - vertexList.get((i + 1) % n).getX();
            final double dy1 = vertexList.get((i + 2) % n).getY()
                    - vertexList.get((i + 1) % n).getY();
            final double dx2 = vertexList.get(i).getX() - vertexList.get((i + 1) % n).getX();
            final double dy2 = vertexList.get(i).getY() - vertexList.get((i + 1) % n).getY();
            final double zcrossproduct = dx1 * dy2 - dy1 * dx2;
            if (i == 0) {
                sign = zcrossproduct > 0;
            } else if (sign != (zcrossproduct > 0)) {
                return false;
            }
        }
        return true;
    }
}
