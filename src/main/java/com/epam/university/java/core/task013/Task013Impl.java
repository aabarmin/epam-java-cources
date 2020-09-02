package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }

        Collection<Vertex> vertexes = figure.getVertexes();
        Set<Vertex> vert = new HashSet<>(vertexes);
        List<Vertex> list = getSortedPointsListFromSet(vert);

        for (int i = 1; i < list.size(); i++) {
            int j = i + 1;
            if (j == list.size()) {
                j = 0;
            }
            int abX = list.get(i).getX() - list.get(i - 1).getX();
            int abY = list.get(i).getY() - list.get(i - 1).getY();

            int bcX = list.get(j).getX() - list.get(i).getX();
            int bcY = list.get(j).getY() - list.get(i).getY();

            double prod = abX * bcY - abY * bcX;
            if (prod > 0) {
                return false;
            }
        }
        return true;
    }

    private List<Vertex> getSortedPointsListFromSet(Set<Vertex> pointsSet) {
        List<Vertex> resultList = new ArrayList<>(pointsSet);

        Integer[] yPoints = new Integer[resultList.size()];
        Integer[] xPoints = new Integer[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            yPoints[i] = resultList.get(i).getY();
            xPoints[i] = resultList.get(i).getX();
        }
        int minimumY = Collections.min(Arrays.asList(yPoints));
        int indexOfMinY = Arrays.asList(yPoints).indexOf(minimumY);
        int minX = resultList.get(indexOfMinY).getX();

        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getY() == minimumY) {
                if (minX > resultList.get(i).getX()) {
                    minX = resultList.get(i).getX();
                }
            }
        }

        Vertex startingPoint = null;
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getX() == minX && resultList.get(i).getY() == minimumY) {
                startingPoint = resultList.get(i);
            }
        }

        List<Vertex> movedPoints = getMovedPointsList(resultList, startingPoint);

        Collections.sort(movedPoints, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                double o1corner = Math.toDegrees(Math.atan2(o1.getX(), o1.getY()));
                double o2corner = Math.toDegrees(Math.atan2(o2.getX(), o2.getY()));

                if ((o1.getX() == 0 && o1.getY() == 0) || (o2.getX() == 0 && o2.getY() == 0)) {
                    if (o1.getX() == 0) {
                        o1corner = -90;
                    }
                    if (o2.getX() == 0) {
                        o2corner = -90;
                    }
                }

                return (int) (o1corner - o2corner);
            }
        });

        List<Vertex> movedPointsBack = getBackToOriginalCoordinated(movedPoints, startingPoint);
        return movedPointsBack;
    }

    private List<Vertex> getBackToOriginalCoordinated(
            List<Vertex> movedPoints,
            Vertex startingPoint) {
        List<Vertex> originalPoints = new LinkedList<>();

        for (int i = 0; i < movedPoints.size(); i++) {
            originalPoints.add(new VertexImpl(movedPoints.get(i).getX() + startingPoint.getX(),
                    movedPoints.get(i).getY() + startingPoint.getY()));
        }

        return originalPoints;
    }

    private List<Vertex> getMovedPointsList(List<Vertex> source, Vertex start) {
        List<Vertex> movedPoints = new ArrayList<>();
        movedPoints.add(new VertexImpl(0, 0));

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(start)) {
                continue;
            }
            movedPoints.add(new VertexImpl(
                    source.get(i).getX() - start.getX(),
                    source.get(i).getY() - start.getY()));
        }

        return movedPoints;
    }


}
