package com.epam.university.java.core.task015;

import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Task015Impl implements Task015 {


    @Override
    public double getArea(Square first, Square second) {
        SquareImpl firstImpl = (SquareImpl) first;
        SquareImpl secondImpl = (SquareImpl) second;

        Set<PointImpl> pointsSet = addCrossingPoints(firstImpl, secondImpl);

        for (PointImpl point : firstImpl.getPoints()) {
            if (secondImpl.contains(point)) {
                pointsSet.add(point);
            }
        }

        for (PointImpl point : secondImpl.getPoints()) {
            if (firstImpl.contains(point)) {
                pointsSet.add(point);
            }
        }

        pointsSet.remove(null);
        if (pointsSet.size() <= 2) {
            return 0.0;
        }

        System.out.println(pointsSet);
        List<PointImpl> points = getSortedPointsListFromSet(pointsSet);

        double sum = 0;
        for (int i = 0; i < points.size(); i++) {
            int j = i + 1;
            if (j == points.size()) {
                j = 0;
            }
            sum += points.get(i).getX() * points.get(j).getY();
            sum -= points.get(i).getY() * points.get(j).getX();
        }


        return Math.abs(sum / 2);
    }

    private List<PointImpl> getSortedPointsListFromSet(Set<PointImpl> pointsSet) {
        List<PointImpl> resultList = new ArrayList<>(pointsSet);

        Double[] yPoints = new Double[resultList.size()];
        Double[] xPoints = new Double[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            yPoints[i] = resultList.get(i).getY();
            xPoints[i] = resultList.get(i).getX();
        }
        double minY = Collections.min(Arrays.asList(yPoints));
        int indexOfMinY = Arrays.asList(yPoints).indexOf(minY);
        double minX = resultList.get(indexOfMinY).getX();

        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getY() == minY) {
                if (minX > resultList.get(i).getX()) {
                    minX = resultList.get(i).getX();
                }
            }
        }

        PointImpl startingPoint = null;
        for (int i = 0; i < resultList.size(); i++) {
            if (resultList.get(i).getX() == minX && resultList.get(i).getY() == minY) {
                startingPoint = resultList.get(i);
            }
        }

        List<PointImpl> movedPoints = getMovedPointsList(resultList, startingPoint);

        Collections.sort(movedPoints, new Comparator<PointImpl>() {
            @Override
            public int compare(PointImpl o1, PointImpl o2) {
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
        
        List<PointImpl> movedPointsBack = getBackToOriginalCoordinated(movedPoints, startingPoint);
        return movedPointsBack;
    }

    private List<PointImpl> getBackToOriginalCoordinated(
            List<PointImpl> movedPoints,
            PointImpl startingPoint) {
        List<PointImpl> originalPoints = new LinkedList<>();

        for (int i = 0; i < movedPoints.size(); i++) {
            originalPoints.add(new PointImpl(movedPoints.get(i).getX() + startingPoint.getX(),
                    movedPoints.get(i).getY() + startingPoint.getY()));
        }

        return originalPoints;
    }

    private List<PointImpl> getMovedPointsList(List<PointImpl> source, PointImpl start) {
        List<PointImpl> movedPoints = new ArrayList<>();
        movedPoints.add(new PointImpl(0, 0));

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i).equals(start)) {
                continue;
            }
            movedPoints.add(new PointImpl(
                    source.get(i).getX() - start.getX(),
                    source.get(i).getY() - start.getY()));
        }

        return movedPoints;
    }

    private Set<PointImpl> addCrossingPoints(SquareImpl firstImpl, SquareImpl secondImpl) {
        Set<PointImpl> pointHashSet = new HashSet<>();
        for (Line2D.Double line1 : firstImpl.getLines()) {
            for (Line2D.Double line2 : secondImpl.getLines()) {
                if (line1.intersectsLine(line2)) {
                    PointImpl p = SquareImpl.getCrossingPoint(line1, line2);
                    pointHashSet.add(p);
                }
            }
        }
        return pointHashSet;
    }
}
