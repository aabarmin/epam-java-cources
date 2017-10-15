package com.epam.university.java.core.task021;

import com.epam.university.java.core.Points;
import com.epam.university.java.core.Validator;
import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactory;
import com.epam.university.java.core.task015.PointFactoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Task021Impl implements Task021 {
    private Validator validator = Validator.getInstance();

    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions.size() != 3) {
            throw new IllegalArgumentException();
        }
        minePositions.forEach(validator::validate);

        List<Point> list = new ArrayList<>(minePositions);

        Point centroid = Points.getCentroid2D(list);
        list.sort((p1, p2) -> {
            double dx1 = p2.getX() - p1.getX();
            double dy1 = p2.getY() - p1.getY();
            double dx2 = centroid.getX() - p1.getX();
            double dy2 = centroid.getY() - p1.getY();
            return Double.compare(dx1 * dy2, dy1 * dx2);
        });

        for (int i = 0; i < 3; i++) {
            Point p1 = list.get(i);
            Point center = list.get((i + 1) % 3);
            Point p2 = list.get((i + 2) % 3);
            if (Points.getAngle(p1, center, p2) > 120) {
                return center;
            }
        }

        Point[] pointsOfEqTr1 = thirdPointsOfEquilateralTriangle(list.get(0), list.get(1));
        Point[] pointsOfEqTr2 = thirdPointsOfEquilateralTriangle(list.get(1), list.get(2));
        Point[] pointsOfEqTr3 = thirdPointsOfEquilateralTriangle(list.get(2), list.get(0));

        Point correctPointOfEqTr1 = selectCorrectPointOfEqTriangle(list.get(0),
                list.get(1), pointsOfEqTr1);
        Point correctPointOfEqTr2 = selectCorrectPointOfEqTriangle(list.get(1),
                list.get(2), pointsOfEqTr2);
        Point correctPointOfEqTr3 = selectCorrectPointOfEqTriangle(list.get(2),
                list.get(1), pointsOfEqTr3);

        Point centerOfCircle1 = centerOfCircumscribedCircle(new Point[]{list.get(0),
                list.get(1),
                correctPointOfEqTr1
        });
        Point centerOfCircle2 = centerOfCircumscribedCircle(new Point[]{list.get(1),
                list.get(2),
                correctPointOfEqTr2
        });
        Point centerOfCircle3 = centerOfCircumscribedCircle(new Point[]{list.get(2),
                list.get(0),
                correctPointOfEqTr3
        });

        Point[] circleCrossPoints1 = getRoundCrossPoints(centerOfCircle1,
                list.get(0),
                centerOfCircle2,
                list.get(1));

        Point[] circleCrossPoints2 = getRoundCrossPoints(centerOfCircle1,
                list.get(0),
                centerOfCircle3,
                list.get(2)
        );

        validator.validate((Object[]) circleCrossPoints1);
        validator.validate((Object[]) circleCrossPoints2);
        for (Point point1 : circleCrossPoints1) {
            for (Point point2 : circleCrossPoints2) {
                if (point1.equals(point2)) {
                    return point1;
                }
            }
        }
        return null;
    }

    private Point selectCorrectPointOfEqTriangle(Point p1, Point p2, Point[] pointsOfEqTr) {
        for (Point candidate : pointsOfEqTr) {
            double dx1 = p2.getX() - candidate.getX();
            double dy1 = p2.getY() - candidate.getY();
            double dx2 = p1.getX() - candidate.getX();
            double dy2 = p1.getY() - candidate.getY();
            double zcrossproduct = dx1 * dy2 - dy1 * dx2;
            if (zcrossproduct < 0) {
                return candidate;
            }
        }
        return null;
    }

    private static Point[] getRoundCrossPoints(Point centerPoint1,
                                               Point onCircle1,
                                               Point centerPoint2,
                                               Point onCircle2) {
        double x10 = centerPoint1.getX();
        double x20 = centerPoint2.getX();
        double y10 = centerPoint1.getY();
        double y20 = centerPoint2.getY();
        double r1 = Points.distance(centerPoint1, onCircle1);
        double r2 = Points.distance(centerPoint2, onCircle2);
        double d = Points.distance(centerPoint1, centerPoint2);
        if (d - (r1 + r2) > 0.1) {
            throw new IllegalArgumentException("d > r1 + r2");
        }
        double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
        double h = Math.sqrt(Math.pow(r1, 2) - Math.pow(a, 2));


        double x0 = x10 + a * (x20 - x10) / d;

        double y0 = y10 + a * (y20 - y10) / d;

        double firstx = x0 + h * (y20 - y10) / d;
        double firsty = y0 - h * (x20 - x10) / d;
        PointFactory factory = new PointFactoryImpl();
        if (a == r1) {
            return new Point[]{
                    factory.newInstance(firstx, firsty)};
        }

        double secondx = x0 - h * (y20 - y10) / d;
        double secondy = y0 + h * (x20 - x10) / d;


        return new Point[]{
                factory.newInstance(firstx, firsty),
                factory.newInstance(secondx, secondy)};
    }

    private Point[] thirdPointsOfEquilateralTriangle(Point first, Point second) {
        double x1 = (first.getX() + second.getX()
                + Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double x2 = (first.getX() + second.getX()
                - Math.sqrt(3) * (first.getY() - second.getY())) / 2;
        double y1 = (first.getY() + second.getY()
                - Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        double y2 = (first.getY() + second.getY()
                + Math.sqrt(3) * (first.getX() - second.getX())) / 2;
        PointFactory factory = new PointFactoryImpl();
        return new Point[]{
                factory.newInstance(x1, y1),
                factory.newInstance(x2, y2)
        };
    }

    private static Point centerOfCircumscribedCircle(Point[] points) {
        if (points.length != 3) {
            throw new IllegalArgumentException("points.length != 3");
        }
        double xa = points[0].getX();
        double xb = points[1].getX();
        double xc = points[2].getX();
        double ya = points[0].getY();
        double yb = points[1].getY();
        double yc = points[2].getY();

        double d = 2 * (xa * (yb - yc) + xb * (yc - ya) + xc * (ya - yb));
        double xres = ((xa * xa + ya * ya) * (yb - yc)
                + (xb * xb + yb * yb) * (yc - ya)
                + (xc * xc + yc * yc) * (ya - yb)) / d;

        double yres = ((xa * xa + ya * ya) * (xc - xb)
                + (xb * xb + yb * yb) * (xa - xc)
                + (xc * xc + yc * yc) * (xb - xa)) / d;

        PointFactory factory = new PointFactoryImpl();
        return factory.newInstance(xres, yres);
    }

}

