package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Romin Nuro on 26.08.2020 0:23.
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
        if (actions == null || figure == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
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
        if (figure == null) {
            throw new IllegalArgumentException();
        }
        FigureFactory factory = new FigureFactoryImpl();
        int polygonSize = figure.getVertexes().size();
        if (polygonSize < 3) {
            return false;
        }
        if (polygonSize == 3) {
            return true;
        }
        int firstCrossProduct = 0;
        Vertex one;
        Vertex two;
        Vertex three;



        List<Vertex> vertexes = (List<Vertex>) figure.getVertexes();

        // getting starting point for vertex sorting
        Vertex startVertex = vertexes.stream()
                .min(Comparator.comparing(Vertex::getX))
                .get();

        // sorting vertexes clockwise
        Collections.sort(vertexes, new SortVertexes(startVertex.getX(), startVertex.getY()));

        // checking if the turning direction is always the same
        for (int i = 0; i < polygonSize; i++) {
            one = vertexes.get(i);
            two = vertexes.get((i + 1) % polygonSize);
            three = vertexes.get((i + 2) % polygonSize);

            Vertex firstVector = factory
                    .newInstance(two.getX() - one.getX(), two.getY() - one.getY());
            Vertex secondVector = factory
                    .newInstance(three.getX() - two.getX(), three.getY() - two.getY());

            if (i == 0) {
                firstCrossProduct = vectorProduct(firstVector, secondVector);
            } else {
                int currentCrossProduct = vectorProduct(firstVector, secondVector);
                if (currentCrossProduct * firstCrossProduct < 0) {
                    return false;
                }

            }

        }
        return true;
    }

    // multiplying vectors method
    public static int vectorProduct(Vertex firstVector, Vertex secondVector) {
        return firstVector.getX() * secondVector.getY() - secondVector.getX() * firstVector.getY();
    }

    class SortVertexes implements Comparator<Vertex> {
        private final int startX;
        private final int startY;

        public SortVertexes(int startX, int startY) {
            this.startX = startX;
            this.startY = startY;
        }

        @Override
        public int compare(Vertex o1, Vertex o2) {
            // comparing angles of vectors from the left point
            // y / x == tg(angle)
            if (o1.getX() - startX == 0 && o1.getY() - startY == 0) {
                return -1;
            }
            if (o2.getX() - startX == 0 && o2.getY() - startY == 0) {
                return 1;
            }
            double tg1 = (double) (o1.getY() - startY) / (double) (o1.getX() - startX);
            double tg2 = (double) (o2.getY() - startY) / (double) (o2.getX() - startX);
            if (tg1 > tg2) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
