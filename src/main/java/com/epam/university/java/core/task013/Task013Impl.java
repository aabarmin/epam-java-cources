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
        return (new JarvisMarch().computeHull(vertices) == vertices.size());
    }

    /**
     * Class for create hull with jarvis alforithm.
     */
    public class JarvisMarch {
        private List<Vertex> vertices;
        private int countOfVertices;
        private int currentIndex;

        /**
         * Init with list of vertices.
         * @param vertices on plane
         * @return count of vertices in hull.
         */
        public int computeHull(List<Vertex> vertices) {
            this.vertices = vertices;
            countOfVertices = vertices.size();
            currentIndex = 0;
            jarvisMarch();
            return currentIndex;
        }

        /**
         * Algorithm start.
         */
        private void jarvisMarch() {
            int i = indexOfLowestPoint();
            do {
                swap(currentIndex, i);
                i = indexOfRightmostPointFrom(vertices.get(currentIndex));
                currentIndex++;
            } while (i > 0);
        }

        /**
         * Search left down vertex.
         * @return vertex index in list
         */
        private int indexOfLowestPoint() {
            int min = 0;
            for (int i = 1; i < countOfVertices; i++) {
                if (vertices.get(i).getY() < vertices.get(min).getY()
                        || vertices.get(i).getY() == vertices.get(min).getY()
                        && vertices.get(i).getX() < vertices.get(min).getX()) {
                    min = i;
                }
            }
            return min;
        }

        /**
         * Search rightmost turn tocurrent vertex.
         * @param vertex current
         * @return  index of vertex
         */
        private int indexOfRightmostPointFrom(Vertex vertex) {
            int i = 0;
            for (int j = 1; j < countOfVertices; j++) {
                if (isLess(relTo(vertices.get(j), vertex), relTo(vertices.get(i), vertex))) {
                    i = j;
                }
            }
            return i;
        }

        /**
         * Checks whether the location vector of t has a smaller angle to the zero point
         * than the location vector of a point p.
         * @param first     vertex
         * @param second    vertex
         * @return  true if angle of turn is less
         */
        private boolean isLess(Vertex first, Vertex second) {
            double f = cross(first, second);
            return f > 0 || f == 0 && isFurther(first, second);
        }

        /**
         * Function checks whether first is farther from the zero than second.
         * @param first vertex
         * @param second vertex
         * @return  true if first is farther from the zero than second
         */
        private boolean isFurther(Vertex first, Vertex second) {
            return mdist(first) > mdist(second);
        }

        /**
         * Function calculates the Manhattan distance from vertex to the zero point.
         * @param vertex vertex.
         * @return Manhattan distance
         */
        private double mdist(Vertex vertex) {
            return Math.abs(vertex.getX()) + Math.abs(vertex.getY());
        }

        /**
         * Produces a new point which represents to vertex
         * relative to the point from as the zero point.
         *
         * @param from zero vertex
         * @param to relative
         * @return new vertex
         */
        VertexImpl relTo(Vertex from, Vertex to) {
            return new VertexImpl(to.getX() - from.getX(), to.getY() - from.getY());
        }

        /**
         * Swap vertices in collection.
         * @param i vertex
         * @param j vertex
         */
        private void swap(int i, int j) {
            Collections.swap(vertices, i, j);
        }

        /**
         * Calculates the cross product of vectors.
         *
         * @param first vector from zero
         * @param second vector from zero
         * @return cross multiply
         */
        public double cross(Vertex first, Vertex second) {
            return first.getX() * second.getY() - second.getX() * first.getY();
        }

    }


}
