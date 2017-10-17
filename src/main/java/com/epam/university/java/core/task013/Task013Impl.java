package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

        /*for (int i = 0; i < vertices.size(); i++) {
            boolean isRightTurn = isRightTurn(vertices.subList(i, i + 3));
            if (isRightTurn) {
                return false;
            }
        }*/
        return (new JarvisMarch().computeHull(vertices) == vertices.size());
    }

    /**
     * True if angle > 0.
     * //@param vertexList of square
     * @return true if angle > 0
     */
    /*private boolean isRightTurn(List<Vertex> vertexList) {
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
    }*/

    public class JarvisMarch
    {
        private List<Vertex> vertices;
        private int countOfVertices;
        private int currentIndex;

        public int computeHull(List<Vertex> vertices)
        {
            this.vertices = vertices;
            countOfVertices = vertices.size();
            currentIndex = 0;
            jarvisMarch();
            return currentIndex;
        }

        private void jarvisMarch()
        {
            int i = indexOfLowestPoint();
            do
            {
                swap(currentIndex, i);
                i = indexOfRightmostPointFrom(vertices.get(currentIndex));
                currentIndex++;
            }
            while (i > 0);
        }

        private int indexOfLowestPoint()
        {
            int min = 0;
            for (int i = 1; i < countOfVertices; i++)
                if (vertices.get(i).getY() < vertices.get(min).getY()
                        || vertices.get(i).getY() == vertices.get(min).getY()
                        && vertices.get(i).getX() < vertices.get(min).getX()) {
                    min = i;
                }
            return min;
        }

        private int indexOfRightmostPointFrom(Vertex vertex)
        {
            int i = 0;
            for (int j = 1; j < countOfVertices; j++) {
                if (isLess(relTo(vertices.get(j), vertex), relTo(vertices.get(i), vertex))) {
                    i = j;
                }
            }
            return i;
        }

        private boolean isLess(Vertex first, Vertex second) {
            double f = cross(first, second);

            return f > 0
                    || f == 0
                    && isFurther(first, second);
        }

        private boolean isFurther(Vertex first, Vertex second) {
            return mdist(first) > mdist(second);
        }

        private double mdist(Vertex vertex) {
            return Math.abs(vertex.getX()) + Math.abs(vertex.getY());
        }

        VertexImpl relTo(Vertex from, Vertex to) {
            return new VertexImpl(to.getX() - from.getX(), to.getY() - from.getY());
        }

        private void swap(int i, int j)
        {
            Collections.swap(vertices, i, j);
        }

        public double cross(Vertex first, Vertex second)
        {
            return first.getX() * second.getY() - second.getX() * first.getY();
        }

    }   // end class JarvisMarch


}
