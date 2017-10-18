package com.epam.university.java.core.task013;


import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class Task013Impl2 implements Task013 {
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
        ArrayList<Vertex> listOfVertex = (ArrayList<Vertex>) figure.getVertexes();
        if (listOfVertex.size() <= 3) {
            return true;
        }
        int size = listOfVertex.size();
        int[] coordsOfX = new int[size - 1];
        int[] coordsOfY = new int[size - 1];
        int count = 0;
        Point2D point = null;
        while (count < size) {
            for (int i = 0, j = 0; i < size || j < coordsOfX.length; i++) {
                if (i != count) {
                    coordsOfX[j] = listOfVertex.get(i).getX();
                    coordsOfY[j] = listOfVertex.get(i).getY();
                    j++;
                } else {
                    point = new Point2D.Double(listOfVertex.get(i).getX(),
                            listOfVertex.get(i).getY());
                }
            }
            Polygon polygon = new Polygon(coordsOfX, coordsOfY, coordsOfX.length);
            if (polygon.contains(point)) {
                return false;
            }
            count++;
        }
        return true;


    }
}
