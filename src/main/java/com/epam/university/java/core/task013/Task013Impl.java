package com.epam.university.java.core.task013;

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
        int validLines = 0;
        for (Vertex start : figure.getVertexes()) {
            for (Vertex end : figure.getVertexes()) {
                boolean minus = false;
                boolean plus = false;

                // formula of the line: Ax + Bx + C
                int coeffA = start.getY() - end.getY();
                int coeffB = end.getX() - start.getX();
                int coeffC = (start.getX() * end.getY()) - (end.getX() * start.getY());

                // search for vertexes above and below the line
                for (Vertex vertex : figure.getVertexes()) {
                    if (coeffA * vertex.getX() + coeffB * vertex.getY() + coeffC < 0) {
                        minus = true;
                    } else if (coeffA * vertex.getX() + coeffB * vertex.getY() + coeffC > 0) {
                        plus = true;
                    }
                }

                // if there are vertexes only above or below the line - this is valid line
                if (minus ^ plus) {
                    validLines++;
                    break;
                }
            }
        }
        
        // polygon is convex if validLines == count of vertexes
        return validLines == figure.getVertexes().size();
    }
}
