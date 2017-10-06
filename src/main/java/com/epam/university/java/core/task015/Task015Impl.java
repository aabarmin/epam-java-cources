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
        Point[] intersectionFigure = createIntersectionFigure(
                createSquareFromDiagonal(first),
                createSquareFromDiagonal(second)
        ).toArray(new Point[0]);

        if (intersectionFigure.length > 2) {
            intersectionFigure = sortPointArray(intersectionFigure);
            double area = 0;

            for (int i = 1; i < intersectionFigure.length - 1; i++) {
                area += countArea(
                        distanceTo(intersectionFigure[0], intersectionFigure[i]),
                        distanceTo(intersectionFigure[i], intersectionFigure[i + 1]),
                        distanceTo(intersectionFigure[i + 1], intersectionFigure[0])
                );
            }

            return area;
        }

        return 0;
    }

    /**
     * Creating full list of points of square from points of its' diagonal.
     *
     * @param square square object, where presents only one diagonal.
     * @return full list of points of square.
     */
    private List<Point> createSquareFromDiagonal(Square square) {
        double ax = square.getFirst().getX();
        double ay = square.getFirst().getY();
        double cx = square.getSecond().getX();
        double cy = square.getSecond().getY();

        double xm = (ax + cx) / 2;
        double ym = (ay + cy) / 2;

        double bx = xm + ym - ay;
        double by = ym - xm + ax;
        double dx = xm - ym + ay;
        double dy = ym + xm - ax;

        return Arrays.asList(
                pointFactory.newInstance(ax, ay),
                pointFactory.newInstance(bx, by),
                pointFactory.newInstance(cx, cy),
                pointFactory.newInstance(dx, dy)
        );
    }

    /**
     * Creating a set of points of new figure from the intersection of two squares.
     *
     * @param firstSquare  list of points of first square.
     * @param secondSquare list of points of second square.
     * @return set of points of new figure from the intersection of two squares.
     */
    private Set<Point> createIntersectionFigure(List<Point> firstSquare, List<Point> secondSquare) {
        Set<Point> setOfIntersections = new HashSet<>();

        // find if some points of first square are inside the second square
        for (Point firstPoint : firstSquare) {
            if (isPointInSquare(firstPoint, secondSquare)) {
                setOfIntersections.add(firstPoint);
            }
        }

        // find if some points of second square are inside the first square
        for (Point secondPoint : secondSquare) {
            if (isPointInSquare(secondPoint, firstSquare)) {
                setOfIntersections.add(secondPoint);
            }
        }

        // find points of intersection of squares
        for (int i = 0; i < firstSquare.size(); i++) {
            int firstCompareTo = (i < firstSquare.size() - 1) ? i + 1 : 0;

            double ax1 = firstSquare.get(i).getX();
            double ay1 = firstSquare.get(i).getY();
            double ax2 = firstSquare.get(firstCompareTo).getX();
            double ay2 = firstSquare.get(firstCompareTo).getY();

            for (int j = 0; j < secondSquare.size(); j++) {
                int secondCompareTo = (j < secondSquare.size() - 1) ? j + 1 : 0;

                double bx1 = secondSquare.get(j).getX();
                double by1 = secondSquare.get(j).getY();
                double bx2 = secondSquare.get(secondCompareTo).getX();
                double by2 = secondSquare.get(secondCompareTo).getY();

                double v1 = (bx2 - bx1) * (ay1 - by1) - (by2 - by1) * (ax1 - bx1);
                double v2 = (bx2 - bx1) * (ay2 - by1) - (by2 - by1) * (ax2 - bx1);
                double v3 = (ax2 - ax1) * (by1 - ay1) - (ay2 - ay1) * (bx1 - ax1);
                double v4 = (ax2 - ax1) * (by2 - ay1) - (ay2 - ay1) * (bx2 - ax1);

                // if there is an intersection - find it's point
                if (((v1 * v2 <= 0) && (v3 * v4 < 0)) || (v1 * v2 < 0) && (v3 * v4 <= 0)) {
                    setOfIntersections.add(
                            findIntersectionPoint(
                                    firstSquare.get(i),
                                    firstSquare.get(firstCompareTo),
                                    secondSquare.get(j),
                                    secondSquare.get(secondCompareTo)
                            )
                    );
                }
            }
        }

        return setOfIntersections;
    }

    /**
     * Find an intersection point of two lines.
     *
     * @param firstA  A point of first line.
     * @param firstB  B point of first line.
     * @param secondA A point of second line.
     * @param secondB B point of second line.
     * @return point of intersection.
     */
    private Point findIntersectionPoint(Point firstA, Point firstB, Point secondA, Point secondB) {
        double a1 = firstA.getY() - firstB.getY();
        double b1 = firstB.getX() - firstA.getX();
        double a2 = secondA.getY() - secondB.getY();
        double b2 = secondB.getX() - secondA.getX();

        double d = a1 * b2 - a2 * b1;

        double c1 = firstB.getY() * firstA.getX() - firstB.getX() * firstA.getY();
        double c2 = secondB.getY() * secondA.getX() - secondB.getX() * secondA.getY();

        double resultX = (b1 * c2 - b2 * c1) / d;
        double resultY = (a2 * c1 - a1 * c2) / d;

        return pointFactory.newInstance(resultX, resultY);
    }

    /**
     * Check for square contains point inside of it.
     *
     * @param point      point to check.
     * @param squareList list of points of square to check
     * @return is square contains point inside of it.
     */
    private boolean isPointInSquare(Point point, List<Point> squareList) {
        boolean minus = false;
        boolean plus = false;

        for (int i = 0; i < squareList.size(); i++) {
            int compareTo = (i < squareList.size() - 1) ? i + 1 : 0;

            double a = squareList.get(i).getY() - squareList.get(compareTo).getY();
            double b = squareList.get(compareTo).getX() - squareList.get(i).getX();
            double c = (squareList.get(i).getX() * squareList.get(compareTo).getY())
                    - (squareList.get(compareTo).getX() * squareList.get(i).getY());

            if (a * point.getX() + b * point.getY() + c < 0) {
                minus = true;
            } else if (a * point.getX() + b * point.getY() + c > 0) {
                plus = true;
            }
        }

        return minus ^ plus;
    }

    /**
     * Sort array of points in the right order.
     *
     * @param sortingArr array to sort.
     * @return array of points in the correct order.
     */
    private Point[] sortPointArray(Point[] sortingArr) {
        LinkedList<Point> resultList = new LinkedList<>();
        resultList.add(sortingArr[0]);


        for (int i = 0; i < sortingArr.length; ) {
            for (int j = 0; j < sortingArr.length; j++) {
                // skip unnecessary iterations 
                if (resultList.contains(sortingArr[j]) || i == j) {
                    continue;
                }

                boolean minus = false;
                boolean plus = false;

                double a = sortingArr[i].getY() - sortingArr[j].getY();
                double b = sortingArr[j].getX() - sortingArr[i].getX();
                double c = (sortingArr[i].getX() * sortingArr[j].getY())
                        - (sortingArr[j].getX() * sortingArr[i].getY());

                for (Point point : sortingArr) {
                    if (a * point.getX() + b * point.getY() + c < 0) {
                        minus = true;
                    } else if (a * point.getX() + b * point.getY() + c > 0) {
                        plus = true;
                    }
                }

                if (minus ^ plus) {
                    resultList.add(sortingArr[j]);

                    // continue next global iteration from j-value
                    i = j;
                    break;
                }
            }

            // exit cycle when array is done, or restart it
            if (sortingArr.length == resultList.size()) {
                break;
            } else if (sortingArr.length > resultList.size() && i == sortingArr.length) {
                i = 0;
            }
        }

        return resultList.toArray(new Point[0]);
    }

    /**
     * Calculate distance from first to second point by theirs coordinates.
     *
     * @param first  first point.
     * @param second second point.
     * @return distance between points.
     */
    private double distanceTo(Point first, Point second) {
        double distanceX = first.getX() - second.getX();
        double distanceY = first.getY() - second.getY();

        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }

    /**
     * Calculate area of a triangle by sides.
     *
     * @param firstSide  first side of triangle.
     * @param secondSide second side of triangle.
     * @param thirdSide  third side of triangle.
     * @return area of a triangle.
     */
    private double countArea(double firstSide, double secondSide, double thirdSide) {
        double halfPer = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(
                halfPer * (halfPer - firstSide) * (halfPer - secondSide) * (halfPer - thirdSide)
        );
    }
}
