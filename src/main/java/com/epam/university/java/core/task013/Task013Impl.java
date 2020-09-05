package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author Dmitry Novikov.
 */
public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (figure.getVertexes().size() != actions.size()) {
            throw new IllegalArgumentException();
        }

        figure.getVertexes().clear();
        for (FigureAction f : actions
        ) {
            f.run(figure);
        }

        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }

        if (figure.getVertexes().size() < 5) {
            return true;
        }

        List<Vertex> temp = figure.getVertexes().stream().collect(Collectors.toList());
        List<Vertex> result = makeHull(temp);
        if (temp.size() != result.size()) {
            return false;
        }

        return isConvex(result);
    }

    /**
     * Some text.
     */
    public static boolean isConvex(List<Vertex> list) {
        if (list.size() < 4) {
            return true;
        }

        boolean sign = false;
        int n = list.size();

        for (int i = 0; i < n; i++) {
            double dx1 = list.get((i + 2) % n).getX() - list.get((i + 1) % n).getX();
            double dy1 = list.get((i + 2) % n).getY() - list.get((i + 1) % n).getY();
            double dx2 = list.get(i).getX() - list.get((i + 1) % n).getX();
            double dy2 = list.get(i).getY() - list.get((i + 1) % n).getY();
            double zcrossproduct = dx1 * dy2 - dy1 * dx2;

            if (i == 0) {
                sign = zcrossproduct > 0;
            } else if (sign != (zcrossproduct > 0)) {
                return false;
            }

        }

        return true;
    }

    /**
     * Some text.
     */
    public static List<Vertex> makeHull(List<Vertex> points) {
        List<Vertex> newPoints = new ArrayList<>(points);
        Collections.sort(newPoints);
        return makeHullPresorted(newPoints);
    }

    /**
     * Some text.
     */
    public static List<Vertex> makeHullPresorted(List<Vertex> points) {
        if (points.size() <= 1) {
            return new ArrayList<>(points);
        }


        List<Vertex> upperHull = new ArrayList<>();
        for (Vertex p : points) {
            while (upperHull.size() >= 2) {
                Vertex q = upperHull.get(upperHull.size() - 1);
                Vertex r = upperHull.get(upperHull.size() - 2);
                if ((q.getX() - r.getX()) * (p.getY() - r.getY())
                        >= (q.getY() - r.getY()) * (p.getX() - r.getX())) {
                    upperHull.remove(upperHull.size() - 1);
                } else {
                    break;
                }

            }
            upperHull.add(p);
        }
        upperHull.remove(upperHull.size() - 1);

        List<Vertex> lowerHull = new ArrayList<>();
        for (int i = points.size() - 1; i >= 0; i--) {
            Vertex p = points.get(i);
            while (lowerHull.size() >= 2) {
                Vertex q = lowerHull.get(lowerHull.size() - 1);
                Vertex r = lowerHull.get(lowerHull.size() - 2);
                if ((q.getX() - r.getX()) * (p.getY() - r.getY())
                        >= (q.getY() - r.getY()) * (p.getX() - r.getX())) {
                    lowerHull.remove(lowerHull.size() - 1);
                } else {
                    break;
                }

            }
            lowerHull.add(p);
        }
        lowerHull.remove(lowerHull.size() - 1);

        if (!(upperHull.size() == 1 && upperHull.equals(lowerHull))) {
            upperHull.addAll(lowerHull);
        }

        return upperHull;
    }
}
