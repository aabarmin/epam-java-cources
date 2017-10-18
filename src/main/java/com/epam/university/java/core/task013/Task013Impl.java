package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class Task013Impl implements Task013 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        Figure result = figure;
        actions.forEach(a -> a.run(result));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        ArrayList<Vertex> listOfVertexes = (ArrayList<Vertex>) figure.getVertexes();
        int countOfedges = 0;
        int sizeOflist = listOfVertexes.size();
        Vertex[] edge = new Vertex[2];
        for (int i = 0; i < sizeOflist; i++) {
            edge[0] = listOfVertexes.get(i);
            for (int j = 0; j < sizeOflist; j++) {
                boolean rightSide = false;
                if (j == i) {
                    continue;
                }
                edge[1] = listOfVertexes.get(j);
                for (int k = 0; k < sizeOflist; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    Vertex point = listOfVertexes.get(k);
                    int a = (edge[1].getX() - edge[0].getX()) * (point.getY() - edge[1].getY());
                    int b = (edge[1].getY() - edge[0].getY()) * (point.getX() - edge[1].getX());
                    int result = a - b;
                    if (result < 0) {
                        rightSide = true;
                        break;
                    }
                }
                if (!rightSide) {
                    countOfedges++;
                }
            }

        }

        return countOfedges == sizeOflist;
    }
}
