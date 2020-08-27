package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction figureAction : actions) {
            figureAction.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        ArrayList<Vertex> vertices = (ArrayList<Vertex>) figure.getVertexes();
        ArrayList<Vertex> sortedVertices = getSortedVertexes(vertices);
        Vertex firstVertex = sortedVertices.get(0);
        for (int i = 1; i < sortedVertices.size(); i++) {
            Vertex nextVertex = sortedVertices.get(i);
            boolean check = checkVertexesOf2Vertex(firstVertex, nextVertex, sortedVertices);
            if (!check) {
                return false;
            }
            firstVertex = nextVertex;
        }
        (figure.getVertexes()).addAll(sortedVertices);
        return true;
    }

    private boolean checkVertexesOf2Vertex(Vertex ver1, Vertex ver2, ArrayList<Vertex> vertices) {
        int[] function = getLineFunctionOf2Vertex(ver1, ver2);
        // Ay + Bx <= -C -> true;

        int a = function[0];
        int b = function[1];
        int c = function[2];

        for (Vertex vertex : vertices) {
            int x = vertex.getX();
            int y = vertex.getY();
            if (!((a * x + b * y) <= -c)) {
                return false;
            }
        }
        return true;
    }

    private int[] getLineFunctionOf2Vertex(Vertex vertex1, Vertex vertex2) {
        // Ay + Bx + C = 0;
        int x1 = vertex1.getX();
        int y1 = vertex1.getY();

        int x2 = vertex2.getX();
        int y2 = vertex2.getY();

        int indexA = y1 - y2;
        int indexB = x2 - x1;

        int indexC = (x1 * y2 - x2 * y1);
        return new int[]{indexA, indexB, indexC};

    }

    private ArrayList<Vertex> getSortedVertexes(ArrayList<Vertex> vertexesOld) {
        ArrayList<Vertex> vertexesList = new ArrayList<>();
        Vertex startPosition = new VertexImpl(0, 0);
        Vertex firstVertex = getMoreCloseVertex(startPosition, vertexesOld);
        vertexesList.add(firstVertex);
        vertexesOld.remove(firstVertex);
        while (vertexesOld.size() > 0) {
            Vertex lastVertex = vertexesList.get(vertexesList.size() - 1);
            Vertex closeVertex = getMoreCloseVertex(lastVertex, vertexesOld);
            vertexesList.add(closeVertex);
            vertexesOld.remove(closeVertex);
        }
        return vertexesList;
    }

    private Vertex getMoreCloseVertex(Vertex vertex, ArrayList<Vertex> vertexes) {
        double distance = 1000000000;
        Vertex closeVertex = null;
        for (Vertex anyVertex : vertexes) {
            if (vertex.equals(anyVertex)) {
                continue;
            }
            double someDistance = getDistance(vertex, anyVertex);
            if (someDistance < distance) {
                distance = someDistance;
                closeVertex = anyVertex;
            }
        }
        return closeVertex;
    }

    private double getDistance(Vertex vertex1, Vertex vertex2) {
        int x1 = vertex1.getX();
        int y1 = vertex1.getY();

        int x2 = vertex2.getX();
        int y2 = vertex2.getY();
        return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
    }
}
