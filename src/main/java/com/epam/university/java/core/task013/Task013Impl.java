package com.epam.university.java.core.task013;

import java.util.Collection;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction a : actions) {
            a.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        int lines = 0;
        for (Vertex start : figure.getVertexes()) {
            for (Vertex end : figure.getVertexes()) {
                boolean negative = false;
                boolean positive = false;
                int pointA = start.getPointY() - end.getPointY();
                int pointB = end.getPointX() - start.getPointX();
                int pointC = (start.getPointX() * end.getPointY())
                        - (end.getPointX() * start.getPointY());
                for (Vertex vertex : figure.getVertexes()) {
                    if (pointA * vertex.getPointX()
                            + pointB * vertex.getPointY() + pointC < 0) {
                        negative = true;
                    } else if (pointA * vertex.getPointX()
                            + pointB * vertex.getPointY() + pointC > 0) {
                        positive = true;
                    }
                }
                if (negative ^ positive) {
                    lines++;
                    break;
                }
            }
        }

        return lines == figure.getVertexes().size();
    }
}
