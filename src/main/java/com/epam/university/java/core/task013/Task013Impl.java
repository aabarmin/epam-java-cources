package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 16.09.2017.
 * Do that later
 */
public class Task013Impl implements Task013 {
    /**
     * Invoke actions with <code>figure</code> instance.
     *
     * @param figure  source figure
     * @param actions collection of actions
     * @return modified figure
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        actions.forEach(a -> a.run(figure));
        return figure;
    }

    /**
     * Check if figure is convex polygon. Convex polygon is a simple polygon in which
     * no line segment between two points on the boundary goes outside the polygon.
     *
     * @param figure figure go check
     * @return is figure convex polygon
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {
        List<Vertex> vertices = new ArrayList<>(figure.getVertexes());
        if (vertices.size() < 3) {
            return false;
        }

        for (int i = 0; i < vertices.size(); i++) {
            boolean isRightTurn = isRightTurn(vertices.subList(i, i + 3));
            if (isRightTurn) {
                return false;
            }
        }


        return true;
    }

     private boolean isRightTurn(List<Vertex> vertexList) {
        if (vertexList.size() != 3) {
            return false;
        }

        //init 3 vertex
        int x1 = vertexList.get(1).getX() - vertexList.get(0).getX();
        int y1 = vertexList.get(1).getY() - vertexList.get(0).getY();
        int x2 = vertexList.get(2).getX() - vertexList.get(0).getX();
        int y2 = vertexList.get(2).getY() - vertexList.get(0).getY();

        double determinant = x1 * y2 - x2 * y1;

         return determinant > 0;
     }


}
