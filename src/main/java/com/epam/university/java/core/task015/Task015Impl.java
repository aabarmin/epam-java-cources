package com.epam.university.java.core.task015;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Task015Impl implements Task015 {
    private PointFactory pointFactory = new PointFactoryImpl();

    @Override
    public double getArea(Square first, Square second) {
        Point[] intersection = intersectionFigure(
                squareConstruction(first),
                squareConstruction(second)
        ).toArray(new Point[0]);

        if (intersection.length > 2) {
            intersection = sortPointArray(intersection);
            double area = 0;
            for (int i = 1; i < intersection.length - 1; i++) {
                area += calculateTriangleArea(
                        distance(intersection[0], intersection[i]),
                        distance(intersection[i], intersection[i + 1]),
                        distance(intersection[i + 1], intersection[0])
                );
            }
            return area;
        }
        return 0;
    }

    private List<Point> squareConstruction(Square square) {
        double firstPointX = square.getFirst().getX();
        double firstPointY = square.getFirst().getY();
        double secondPointX = square.getSecond().getX();
        double secondPointY = square.getSecond().getY();

        double middleX = (firstPointX + secondPointX) / 2;
        double middleY = (firstPointY + secondPointY) / 2;

        double thirdPointX = middleX + middleY - firstPointY;
        double thirdPointY = middleY - middleX + firstPointX;
        double fourthPointX = middleX - middleY + firstPointY;
        double fourthPointY = middleY + middleX - firstPointX;
        return Arrays.asList(
                pointFactory.newInstance(firstPointX, firstPointY),
                pointFactory.newInstance(thirdPointX, thirdPointY),
                pointFactory.newInstance(secondPointX, secondPointY),
                pointFactory.newInstance(fourthPointX, fourthPointY)
        );
    }

    private Set<Point> intersectionFigure(List<Point> firstSquare, List<Point> secondSquare) {
        Set<Point> intersectSet = new HashSet<>();
        for (Point firstPoint : firstSquare) {
            if (isPointInSquare(firstPoint, secondSquare)) {
                intersectSet.add(firstPoint);
            }
        }

        for (Point secondPoint : secondSquare) {
            if (isPointInSquare(secondPoint, firstSquare)) {
                intersectSet.add(secondPoint);
            }
        }

        for (int i = 0; i < firstSquare.size(); i++) {
            int firstCompare;
            if (i < firstSquare.size() - 1) {
                firstCompare = i + 1;
            } else {
                firstCompare = 0;
            }
            double ax1 = firstSquare.get(i).getX();
            double ay1 = firstSquare.get(i).getY();
            double ax2 = firstSquare.get(firstCompare).getX();
            double ay2 = firstSquare.get(firstCompare).getY();

            for (int j = 0; j < secondSquare.size(); j++) {
                int secondCompare;
                if (j < secondSquare.size() - 1) {
                    secondCompare = j + 1;
                } else {
                    secondCompare = 0;
                }
                double bx1 = secondSquare.get(j).getX();
                double by1 = secondSquare.get(j).getY();
                double bx2 = secondSquare.get(secondCompare).getX();
                double by2 = secondSquare.get(secondCompare).getY();

                double vertex1 = (bx2 - bx1) * (ay1 - by1) - (by2 - by1) * (ax1 - bx1);
                double vertex2 = (bx2 - bx1) * (ay2 - by1) - (by2 - by1) * (ax2 - bx1);
                double vertex3 = (ax2 - ax1) * (by1 - ay1) - (ay2 - ay1) * (bx1 - ax1);
                double vertex4 = (ax2 - ax1) * (by2 - ay1) - (ay2 - ay1) * (bx2 - ax1);

                if (((vertex1 * vertex2 <= 0) && (vertex3 * vertex4 < 0))
                        || (vertex1 * vertex2 < 0) && (vertex3 * vertex4 <= 0)) {
                    intersectSet.add(
                            findIntersectionPoint(
                                    firstSquare.get(i),
                                    firstSquare.get(firstCompare),
                                    secondSquare.get(j),
                                    secondSquare.get(secondCompare)
                            )
                    );
                }
            }
        }
        return intersectSet;
    }

    private Point findIntersectionPoint(Point firstA, Point firstB, Point secondA, Point secondB) {
        double firstLineY = firstA.getY() - firstB.getY();
        double firstLineX = firstB.getX() - firstA.getX();
        double secondLineY = secondA.getY() - secondB.getY();
        double secondLineX = secondB.getX() - secondA.getX();

        double diff = firstLineY * secondLineX - secondLineY * firstLineX;
        double a1 = firstB.getY() * firstA.getX() - firstB.getX() * firstA.getY();
        double a2 = secondB.getY() * secondA.getX() - secondB.getX() * secondA.getY();

        double resultX = (firstLineX * a2 - secondLineX * a1) / diff;
        double resultY = (secondLineY * a1 - firstLineY * a2) / diff;

        return pointFactory.newInstance(resultX, resultY);
    }

    private boolean isPointInSquare(Point point, List<Point> pointsList) {
        boolean belowLine = false;
        boolean aboveLine = false;

        for (int i = 0; i < pointsList.size(); i++) {
            int compare;
            if (i < pointsList.size() - 1) {
                compare = i + 1;
            } else {
                compare = 0;
            }
            double a = pointsList.get(i).getY() - pointsList.get(compare).getY();
            double b = pointsList.get(compare).getX() - pointsList.get(i).getX();
            double c = (pointsList.get(i).getX() * pointsList.get(compare).getY())
                    - (pointsList.get(compare).getX() * pointsList.get(i).getY());

            if (a * point.getX() + b * point.getY() + c < 0) {
                belowLine = true;
            } else if (a * point.getX() + b * point.getY() + c > 0) {
                aboveLine = true;
            }
        }
        return belowLine != aboveLine;
    }

    private Point[] sortPointArray(Point[] sortingArr) {
        LinkedList<Point> resultList = new LinkedList<>();
        resultList.add(sortingArr[0]);

        for (int i = 0; i < sortingArr.length; ) {
            for (int j = 0; j < sortingArr.length; j++) {
                if (resultList.contains(sortingArr[j]) || i == j) {
                    continue;
                }
                boolean belowLine = false;
                boolean aboveLine = false;

                double a = sortingArr[i].getY() - sortingArr[j].getY();
                double b = sortingArr[j].getX() - sortingArr[i].getX();
                double c = (sortingArr[i].getX() * sortingArr[j].getY())
                        - (sortingArr[j].getX() * sortingArr[i].getY());

                for (Point point : sortingArr) {
                    if (a * point.getX() + b * point.getY() + c < 0) {
                        belowLine = true;
                    } else if (a * point.getX() + b * point.getY() + c > 0) {
                        aboveLine = true;
                    }
                }
                if (belowLine != aboveLine) {
                    resultList.add(sortingArr[j]);
                    i = j;
                    break;
                }
            }
            if (sortingArr.length == resultList.size()) {
                break;
            } else if (sortingArr.length > resultList.size() && i == sortingArr.length) {
                i = 0;
            }
        }
        return resultList.toArray(new Point[0]);
    }

    private double distance(Point first, Point second) {
        double distX = first.getX() - second.getX();
        double distY = first.getY() - second.getY();
        return Math.sqrt(distX * distX + distY * distY);
    }

    private double calculateTriangleArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        return Math.sqrt(
                p * (p - a) * (p - b) * (p - c)
        );
    }
}