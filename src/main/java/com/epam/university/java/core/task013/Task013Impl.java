package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.HashSet;

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
        final Collection<Vertex> vertices = figure.getVertexes();
        for (Vertex currentVertex : vertices) {
            boolean internalVrtex = true;
            Collection<Vertex> withoutCurrent = withoutVertex(vertices, currentVertex);
            for (Vertex endEdge : withoutCurrent) {
                if (isEdgeOfConvexPolygon(currentVertex, endEdge,
                        withoutVertex(withoutCurrent, endEdge))) {
                    internalVrtex = false;
                    break;
                }
            }
            if (internalVrtex) {
                return false;
            }
        }
        return true;
    }

    private Collection<Vertex> withoutVertex(Collection<Vertex> vertices, Vertex vertex) {
        Collection<Vertex> out = new HashSet<>();
        for (Vertex current : vertices) {
            if (!current.equals(vertex)) {
                out.add(current);
            }
        }
        return out;
    }

    private boolean isEdgeOfConvexPolygon(Vertex first, Vertex second,
                                          Collection<Vertex> otherVertices) {
        int edgeX = second.getX() - first.getX();
        int edgeY = second.getY() - first.getY();
        int countLeftVertex = 0;
        int countRightVertex = 0;
        for (Vertex current : otherVertices) {
            int mulVector = (edgeX) * (current.getY() - first.getY())
                    - (edgeY) * (current.getX() - first.getX());
            if (mulVector > 0) {
                countLeftVertex++;
            } else {
                countRightVertex += (mulVector != 0) ? 1 : 0;
            }
        }
        return (countLeftVertex == 0 || countRightVertex == 0);
    }
}
