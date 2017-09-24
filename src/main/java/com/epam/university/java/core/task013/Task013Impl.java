package com.epam.university.java.core.task013;

import java.util.Collection;

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

        Vertex[] points = figure.getVertexes().toArray(new Vertex[figure.getVertexes().size()]);

        int processed = 0;
        int n = points.length;
        if (n < 3)
            return true;

        int leftMost = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].getX() < points[leftMost].getX()) {
                leftMost = i;
            }
        }
        int p = leftMost;

        do
        {
            int q;
            q = (p + 1) % n;
            for (int i = 0; i < n; i++) {
                if (CCW(points[p], points[i], points[q])) {
                    q = i;
                }
            }

            processed++;
            p = q;
        } while (p != leftMost);

        return (processed == n);
    }


    // "Jarvis march"-algorithm
    private boolean CCW(Vertex p, Vertex q, Vertex r)
    {
        int val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val >= 0) {
            return false;
        }

        return true;
    }
}
