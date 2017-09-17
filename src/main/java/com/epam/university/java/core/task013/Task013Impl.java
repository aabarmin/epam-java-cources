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

        double aToCenter = Math.sqrt(Math.pow(center.getX() - a.getX(), 2) +
                Math.pow(center.getY() - a.getY(), 2));

        double bToCenter = Math.sqrt(Math.pow(center.getX() - b.getX(), 2) +
                Math.pow(center.getY() - b.getY(), 2));

        double aToB = Math.sqrt(Math.pow(b.getX() - a.getX(), 2)+
                Math.pow(b.getY() - a.getY(), 2));

        return Math.acos(
                (bToCenter * bToCenter + aToCenter * aToCenter - aToB * aToB) /
                (2 * bToCenter * aToCenter)
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
    public boolean isConvexPolygon(Figure figure) {

        List<Vertex> vertexes = new ArrayList(figure.getVertexes());

        if (vertexes.size() < 4)
            return true;
        boolean sign = false;
        int n = vertexes.size();
        for(int i=0; i<n; i++)
        {
            double dx1 = vertexes.get((i+2)%n).getX()-vertexes.get((i+1)%n).getX();
            double dy1 = vertexes.get((i+2)%n).getY()-vertexes.get((i+1)%n).getY();
            double dx2 = vertexes.get(i).getX()-vertexes.get((i+1)%n).getX();
            double dy2 = vertexes.get(i).getY()-vertexes.get((i+1)%n).getY();
            double zcrossproduct = dx1*dy2 - dy1*dx2;
            if (i == 0)
                sign = zcrossproduct > 0;
            else if (sign != (zcrossproduct > 0))
                return false;
        }
        return true;

    }



}
