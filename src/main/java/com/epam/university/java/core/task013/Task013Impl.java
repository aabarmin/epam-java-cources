package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task013Impl implements Task013 {

    /**
     * Calculates the angle (in radians) between two vectors pointing outward from one center.
     *
     * @param a first vertex
     * @param b second vertex
     * @param center center point
     */
    public static double getAngle(Vertex a, Vertex b, Vertex center) {

        double aToCenter = Math.sqrt(Math.pow(center.getX() - a.getX(), 2)
                + Math.pow(center.getY() - a.getY(), 2));

        double bToCenter = Math.sqrt(Math.pow(center.getX() - b.getX(), 2)
                + Math.pow(center.getY() - b.getY(), 2));

        double aToB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2)
                + Math.pow(b.getY() - a.getY(), 2));

        return Math.acos(
                (bToCenter * bToCenter + aToCenter * aToCenter - aToB * aToB)
                        / (2 * bToCenter * aToCenter)
        );

    }

    /**
     * Invoke actions with <code>figure</code> instance.
     *
     * @param figure  source figure
     * @param actions collection of actions
     * @return modified figure
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {

        if (figure == null || actions == null) {
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
    @SuppressWarnings("unchecked")
    public boolean isConvexPolygon(Figure figure) {

        List<Vertex> vertexes = new ArrayList(figure.getVertexes());

        if (vertexes.size() < 4) {
            return true;
        }

        // Find initial vertex with min x and y
        Vertex initialVertex = vertexes.get(0);

        for (int i = 1; i < vertexes.size(); i++) {
            if (vertexes.get(i).getX() < initialVertex.getX()) {
                initialVertex = vertexes.get(i);
            } else if (vertexes.get(i).getX() == initialVertex.getX()) {
                if (vertexes.get(i).getY() < initialVertex.getY()) {
                    initialVertex = vertexes.get(i);
                }
            }
        }

        vertexes.remove(initialVertex);
        //System.out.println("Initial vertex X: " + initialVertex.getX()
        //        + " Y: " + initialVertex.getY());

        //  Find 2 vertexes with max angle to initial vertex
        Vertex center = vertexes.get(0);
        Vertex finish = vertexes.get(0);
        double maxAngle = 0;

        for (int i = 0; i < vertexes.size(); i++) {

            for (int k = 0; k < vertexes.size(); k++) {

                if (vertexes.get(i) == vertexes.get(k)) {
                    continue;
                }

                double angle = getAngle(vertexes.get(i), vertexes.get(k), initialVertex);

                if (angle > maxAngle) {
                    maxAngle = angle;
                    center = vertexes.get(i);
                    finish = vertexes.get(k);
                }

            }

        }

        vertexes.remove(center);
        //System.out.println("Next X: " + center.getX() + " Y: " + center.getY());

        // let's go through the figure boundary
        Vertex a = initialVertex;
        Vertex b = initialVertex;

        while (center != finish) {

            maxAngle = 0;

            for (Vertex vertex : vertexes) {
                double angle = getAngle(a, vertex, center);
                if (angle > maxAngle) {
                    maxAngle = angle;
                    b = vertex;
                }
            }

            a = center;
            center = b;
            vertexes.remove(center);
            System.out.println("Next X: " + center.getX() + " Y: " + center.getY());

        }

        boolean isConvexPolygon = (vertexes.size() == 0);

        return isConvexPolygon;

    }

}
