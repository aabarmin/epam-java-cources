package com.epam.university.java.core.task013;

import edu.princeton.cs.algorithms.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {

        for (FigureAction fa: actions) {

            fa.run(figure);
        }

        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {

        ArrayList<Vertex> vertexes = (ArrayList<Vertex>) figure.getVertexes();

        Point2D[] vertexesP = new Point2D[vertexes.size()];

        for (int i = 0; i < vertexes.size(); i++) {
            vertexesP[i] = new Point2D(vertexes.get(i).getX(),vertexes.get(i).getY());
        }

        Arrays.sort(vertexesP, new Point2D(0,0).POLAR_ORDER);

        for (int i = 0; i < vertexesP.length; i++) {
            if (Point2D.ccw(vertexesP[i], vertexesP[(i + 1) % vertexesP.length],
                    vertexesP[(i + 2) % vertexesP.length]) <= 0) {
                return false;
            }
        }

        return true;
    }
}
