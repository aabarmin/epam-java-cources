package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.List;

/**
 * Implementation class for Task013.
 *
 * @author Sergei Titov
 */
public class Task013Impl implements Task013 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isConvexPolygon(Figure figure) {

        List<Vertex> points = null;
        if (figure.getVertexes() instanceof List) {
            points = (List<Vertex>) figure.getVertexes();
        }

        int processed = 0;
        int n = points.size();
        if (n < 3) {
            return true;
        }

        int leftMost = 0;
        for (int i = 1; i < n; i++) {
            if (points.get(i).getX() < points.get(leftMost).getX()) {
                leftMost = i;
            }
        }
        int p = leftMost;

        do {
            int q;
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (isCosMin(points.get(p), points.get(i), points.get(q))) {
                    q = i;
                }
            }

            processed++;
            p = q;
        } while (p != leftMost);

        return (processed == n);
    }

    // "Jarvis march"-algorithm
    private boolean isCosMin(Vertex p, Vertex q, Vertex r) {

        int val = (q.getY() - p.getY()) * (r.getX() - q.getX())
                - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val >= 0) {
            return false;
        }

        return true;
    }
}
