package com.epam.university.java.core.task013;

import java.util.Collection;

/**
 * Work with polygons.
 */
public interface Task013 {
    /**
     * Invoke actions with <code>figure</code> instance.
     * @param figure source figure
     * @param actions collection of actions
     * @return modified figure
     */
    Figure invokeActions(Figure figure, Collection<FigureAction> actions);

    /**
     * Check if figure is convex polygon. Convex polygon is a simple polygon in which
     * no line segment between two points on the boundary goes outside the polygon.
     * @param figure figure go check
     * @return is figure convex polygon
     */
    boolean isConvexPolygon(Figure figure);
}
