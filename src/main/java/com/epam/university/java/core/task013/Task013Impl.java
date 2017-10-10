package com.epam.university.java.core.task013;

import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null) {
            throw new IllegalArgumentException("Data wasn't provided");
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        int correctLines = 0;
        for (Vertex firstPoint : figure.getVertexes()) {
            for (Vertex secondPoint : figure.getVertexes()) {
                //Equation of a line that passes through the two points
                //Ax + By + C = 0
                //(y1-y2)x + (x1-x2)y + (x1y2-x2y1) = 0
                int a = firstPoint.getY() - secondPoint.getY();
                int b = secondPoint.getX() - firstPoint.getX();
                int c = (firstPoint.getX() * secondPoint.getY())
                        - (secondPoint.getX() * firstPoint.getY());
                boolean belowLine = false;
                boolean aboveLine = false;
                for (Vertex vertex : figure.getVertexes()) {
                    int equationLine = a * vertex.getX() + b * vertex.getY() + c;
                    if (equationLine < 0) {
                        belowLine = true;
                    }
                    if (equationLine > 0) {
                        aboveLine = true;
                    }
                }
                if (belowLine != aboveLine) {
                    correctLines++;
                    break;
                }
            }
        }
        return figure.getVertexes().size() == correctLines;
    }
}