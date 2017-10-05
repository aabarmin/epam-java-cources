package com.epam.university.java.core.task015;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * {@inheritDoc}
 */
public class Task015Impl implements Task015 {
    /**
     * {@inheritDoc}
     */
    @Override
    public double getArea(Square first, Square second) {
        PointImpl[] firstSquare = getSquareCoordinates(first);
        PointImpl[] secondSquare = getSquareCoordinates(second);
        Set<PointImpl> pointsAndIntersections =
                new HashSet<>(getPointsInsideSquare(firstSquare, secondSquare));
        pointsAndIntersections.addAll(getPointsInsideSquare(secondSquare, firstSquare));
        pointsAndIntersections.addAll(getIntersections(firstSquare, secondSquare));

        if (pointsAndIntersections.size() < 3) {
            return 0;
        } else if (pointsAndIntersections.size() == 3) {
            return triangleSquare(pointsAndIntersections.toArray(new PointImpl[3]));
        }

        return getPolygonSquare(pointsAndIntersections);


    }

    /**
     * Method gets square with only two point and finds two more point.
     *
     * @param square square with only two opposite points
     * @return array of all four points <code>square</code>
     */
    private PointImpl[] getSquareCoordinates(Square square) {
        PointImpl[] squreCoords = new PointImpl[4];
        double xOfA = square.getFirst().getX();
        double yOfA = square.getFirst().getY();

        double xOfC = square.getSecond().getX();
        double yOfC = square.getSecond().getY();

        double xOfB = (xOfA + xOfC) / 2 + (yOfA - yOfC) / 2;
        double yOfB = (yOfA + yOfC) / 2 + (xOfC - xOfA) / 2;

        double xOfD = (xOfA + xOfC) / 2 + (yOfC - yOfA) / 2;
        double yOfD = (yOfA + yOfC) / 2 + (xOfA - xOfC) / 2;
        squreCoords[0] = new PointImpl(xOfA, yOfA);
        squreCoords[1] = new PointImpl(xOfB, yOfB);
        squreCoords[2] = new PointImpl(xOfC, yOfC);
        squreCoords[3] = new PointImpl(xOfD, yOfD);

        return squreCoords;
    }

    /**
     * Method finds points of <code>toFind</code> which including in <code> inside</code>.
     *
     * @param inside square in which is searching
     * @param toFind square the point of which are searched
     * @return list of <code>toFind</code> points found in <code>inside</code>
     */
    private Collection<PointImpl> getPointsInsideSquare(PointImpl[] inside, PointImpl[] toFind) {
        List<PointImpl> list = new ArrayList<>();
        int minusCounter = 0;
        for (int i = 0; i < toFind.length; i++) {
            double xOfD = toFind[i].getX();
            double yOfD = toFind[i].getY();
            for (int j = 0; j <= inside.length - 1; j++) {
                int k = j + 1;
                if (k >= inside.length) {
                    k = 0;
                }
                double xOfA = inside[j].getX();
                double yOfA = inside[j].getY();

                double xOfB = inside[k].getX();
                double yOfB = inside[k].getY();

                double a = (xOfB - xOfA) * (yOfD - yOfB);
                double b = (yOfB - yOfA) * (xOfD - xOfB);
                double result = a - b;
                if (result <= 0) {
                    minusCounter++;
                }
            }
            if (minusCounter == 4) {
                list.add(toFind[i]);
            }
            minusCounter = 0;

        }
        return list;
    }

    /**
     * Finds intersections of two squares.
     *
     * @param firstSquare  first square
     * @param secondSquare second square
     * @return list of intersection points
     */
    private Collection<PointImpl> getIntersections(PointImpl[] firstSquare, PointImpl[] secondSquare) {
        List<PointImpl> resultList = new ArrayList<>();
        for (int i = 0; i < firstSquare.length; i++) {
            int j = i == firstSquare.length - 1 ? 0 : i + 1;
            PointImpl aPoint = firstSquare[i];
            PointImpl bPoint = firstSquare[j];
            for (int k = 0; k < secondSquare.length; k++) {
                int l = k == secondSquare.length - 1 ? 0 : k + 1;
                PointImpl cPoint = secondSquare[k];
                PointImpl dPoint = secondSquare[l];

                double devider = (aPoint.getX() - bPoint.getX()) * (dPoint.getY() - cPoint.getY()) -
                        (aPoint.getY() - bPoint.getY()) * (dPoint.getX() - cPoint.getX());

                double dividendA = (aPoint.getX() - cPoint.getX()) * (dPoint.getY() - cPoint.getY()) -
                        (aPoint.getY() - cPoint.getY()) * (dPoint.getX() - cPoint.getX());

                double dividendB = (aPoint.getX() - bPoint.getX()) * (aPoint.getY() - cPoint.getY()) -
                        (aPoint.getY() - bPoint.getY()) * (aPoint.getX() - cPoint.getX());

                double resultA = dividendA / devider;
                double resultB = dividendB / devider;

                if (resultA >= 0 && resultA <= 1 && resultB >= 0 && resultB <= 1) {
                    double interX = aPoint.getX() + resultA * (bPoint.getX() - aPoint.getX());
                    double interY = aPoint.getY() + resultA * (bPoint.getY() - aPoint.getY());

                    resultList.add(new PointImpl(interX, interY));
                }

            }
        }
        return resultList;
    }

    /**
     * Method finds square of <code>triangle</code>.
     *
     * @param triangle triangle which square is to find
     * @return square of <code>triangle</code>
     */
    private double triangleSquare(PointImpl[] triangle) {
        double[] ribs = new double[3];
        for (int i = 0; i < triangle.length; i++) {
            int j = i == triangle.length - 1 ? 0 : i + 1;
            ribs[i] = Math.sqrt(Math.pow(triangle[j].getX() - triangle[i].getX(), 2) +
                    Math.pow(triangle[j].getY() - triangle[i].getY(), 2));
        }

        double semiPer = 0.5 * (ribs[0] + ribs[1] + ribs[2]);
        double square = Math.sqrt(semiPer * (semiPer - ribs[0]) * (semiPer - ribs[1]) *
                (semiPer - ribs[2]));
        return square;
    }

    /**
     * Method finds square of <code>polygon</code>.
     *
     * @param polygon polygon which square is to find
     * @return square of <code>polygon</code>
     */
    private double getPolygonSquare(Collection<PointImpl> polygon) {

        ArrayList<PointImpl> list = new ArrayList<>(polygon);
        LinkedList<PointImpl> ordered = new LinkedList<>();
        ordered.add(list.remove(0));
        while (!list.isEmpty()) {
            if (list.size() == 1) {
                ordered.add(list.remove(0));
                break;
            }
            label:
            for (int i = 0; i < list.size(); i++) {
                double xOfA = ordered.getLast().getX();
                double yOfA = ordered.getLast().getY();

                double xOfB = list.get(i).getX();
                double yOfB = list.get(i).getY();

                for (int j = 0; j < list.size(); j++) {
                    if (j == i) {
                        continue;
                    }
                    double xOfC = list.get(j).getX();
                    double yOfC = list.get(j).getY();
                    double a = (xOfB - xOfA) * (yOfC - yOfB);
                    double b = (yOfB - yOfA) * (xOfC - xOfB);
                    double result = a - b;
                    if (result > 0) {
                        continue label;
                    }
                }
                ordered.add(list.remove(i));
            }
        }
        double square = 0.0;
        PointImpl main = ordered.remove(0);
        for (int i = 0; i < ordered.size() - 1; i++) {
            square += triangleSquare(new PointImpl[]{main, ordered.get(i), ordered.get(i + 1)});
        }
        return square;

    }
}
