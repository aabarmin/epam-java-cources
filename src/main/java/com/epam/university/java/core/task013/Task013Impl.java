package com.epam.university.java.core.task013;

import com.epam.university.java.core.task012.GraphAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.isEmpty()) {
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
        List<Vertex> vertexes = new ArrayList<>(sortVertices((List<Vertex>) figure.getVertexes()));
        int checkSign = 0;
        for (int i = 0; i < vertexes.size(); i++) {
            Vertex currentVert = vertexes.get(i);
            Vertex nextVert;
            if (i == vertexes.size() - 1) {
                nextVert = vertexes.get(0); ;
            } else {
                nextVert = vertexes.get(i + 1);
            }
            Vertex previousVert;
            if (i == 0) {
                previousVert = vertexes.get(vertexes.size() - 1); ;
            } else {
                previousVert = vertexes.get(i - 1);
            }

            int[] point1 = new int[2];
            int[] point2 = new int[2];

            point1[0] = currentVert.getX() - previousVert.getX();
            point1[1] = currentVert.getY() - previousVert.getY();

            point2[0] = nextVert.getX() - currentVert.getX();
            point2[1] = nextVert.getY() - currentVert.getY();

            int value = point1[0] * point2[1] - point1[1] * point2[0];
            if (i == 0) {
                checkSign = Integer.compare(value, 0);
            } else if (value == 0) {
                continue;
            } else if (checkSign != Integer.compare(value, 0)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sorting vertices in right order.
     * @param vertices list of vertices
     * @return sorted list of vertices
     */
    public List<Vertex> sortVertices(List<Vertex> vertices) {
        Vertex leftMin = vertices.get(0);
        for (Vertex vert : vertices) {
            if (leftMin.getX() > vert.getX()) {
                leftMin = vert;
            } else if (leftMin.getX() == vert.getX()) {
                if (leftMin.getY() > vert.getY()) {
                    leftMin = vert;
                }
            }
        }
        List<Vertex> sortedVertices = new ArrayList<>();
        sortedVertices.add(leftMin);

        for (Vertex vertex : vertices) {
            if (vertex.getY() != leftMin.getY() || vertex.getX() != leftMin.getX()) {
                sortedVertices.add(vertex);
            }
        }

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < sortedVertices.size() - 1; i++) {
                Vertex currentVertex = sortedVertices.get(i);
                Vertex nextVertex = sortedVertices.get(i + 1);

                double currentAngle = Math.atan2(currentVertex.getY(), currentVertex.getX());
                double nextAngle = Math.atan2(nextVertex.getY(), nextVertex.getX());

                if (nextAngle > currentAngle) {
                    Vertex temp = sortedVertices.get(i);
                    sortedVertices.set(i, sortedVertices.get(i + 1));
                    sortedVertices.set(i + 1, temp);
                    isSorted = false;
                }

                if (nextAngle == 0 && currentAngle == 0) {
                    if (currentVertex.getX() < nextVertex.getX()) {
                        Vertex temp = sortedVertices.get(i);
                        sortedVertices.set(i, sortedVertices.get(i + 1));
                        sortedVertices.set(i + 1, temp);
                        isSorted = false;
                    }
                }
            }
        }
        return sortedVertices;
    }
}
