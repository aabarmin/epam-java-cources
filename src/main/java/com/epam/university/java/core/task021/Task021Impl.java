package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;
import com.epam.university.java.core.task015.PointImpl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task021Impl implements Task021 {
    /**
     * <p>
     *     There are three mines, position of each is in <code>minePositions</code> collection.
     *     You should determine coordinates of the city which will have a factory. It's better
     *     to have the shortest distance between mines and city.
     * </p>
     * <p>
     *     Example:
     * </p>
     *
     * @param minePositions mines positions
     * @return city city position
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {
        List<Point> points = new ArrayList<>(minePositions);

        Point point = isFermat(points);
        if (point != null) {
            return point;
        }

        BigDecimal ax = BigDecimal.valueOf(points.get(0).getX());
        BigDecimal ay = BigDecimal.valueOf(points.get(0).getY());
        BigDecimal bx = BigDecimal.valueOf(points.get(1).getX());
        BigDecimal by = BigDecimal.valueOf(points.get(1).getY());
        BigDecimal cx = BigDecimal.valueOf(points.get(2).getX());
        BigDecimal cy = BigDecimal.valueOf(points.get(2).getY());

//        double firstX = (cx + bx + (cy - by) * Math.sqrt(3)) / 2;
        BigDecimal firstX = cx.add(bx).add(cy.subtract(by).multiply(BigDecimal.valueOf(StrictMath.sqrt(3)))).divide(BigDecimal.valueOf(2.0d), 20, RoundingMode.UNNECESSARY);
//        double firstY = (cy + by + (bx - cx) * Math.sqrt(3)) / 2;
        BigDecimal firstY = cy.add(by).add(bx.subtract(cx).multiply(BigDecimal.valueOf(StrictMath.sqrt(3)))).divide(BigDecimal.valueOf(2.0d), 20, RoundingMode.UNNECESSARY);

//        double secondX = (ax + bx + (ay - by) * Math.sqrt(3)) / 2;
        BigDecimal secondX = ax.add(bx).add(ay.subtract(by).multiply(BigDecimal.valueOf(StrictMath.sqrt(3)))).divide(BigDecimal.valueOf(2.0d), 20, RoundingMode.UNNECESSARY);
//        double secondY = (ay + by + (bx - ax) * Math.sqrt(3)) / 2;
        BigDecimal secondY = ay.add(by).add(bx.subtract(ax).multiply(BigDecimal.valueOf(StrictMath.sqrt(3)))).divide(BigDecimal.valueOf(2.0d), 20, RoundingMode.UNNECESSARY);

//        double a1 = cy - secondY;
        BigDecimal a1 = cy.subtract(secondY);
//        double b1 = secondX - cx;
        BigDecimal b1 = secondX.subtract(cx);
//        double a2 = ay - firstY;
        BigDecimal a2 = ay.subtract(firstY);
//        double b2 = firstX - ax;
        BigDecimal b2 = firstX.subtract(ax);

//        double d = a1 * b2 - a2 * b1;
        BigDecimal d = a1.multiply(b2).subtract(a2.multiply(b1));

//        double c1 = secondY * cx - secondX * cy;
        BigDecimal c1 = secondY.multiply(cx).subtract(secondX.multiply(cy));
//        double c2 = firstY * ax - firstX * ay;
        BigDecimal c2 = firstY.multiply(ax).subtract(firstX.multiply(ay));

//        double resultX = (b1 * c2 - b2 * c1) / d;
        BigDecimal resultX = b1.multiply(c2).subtract(b2.multiply(c1));
        resultX = resultX.divide(d, 17, RoundingMode.HALF_UP);
//        double resultY = (a2 * c1 - a1 * c2) / d;
        BigDecimal resultY = a2.multiply(c1).subtract(a1.multiply(c2));
        resultY = resultY.divide(d, 17, RoundingMode.HALF_UP);

        return new PointFactoryImpl().newInstance(resultX.doubleValue(), resultY.doubleValue());

//        Double ax = points.get(0).getX();
//        Double ay = points.get(0).getY();
//        Double bx = points.get(1).getX();
//        Double by = points.get(1).getY();
//        Double cx = points.get(2).getX();
//        Double cy = points.get(2).getY();
//
////        double ax = (cx + bx + (cy - by) * StrictMath.sqrt(3)) / 2.0d;
//        BigDecimal ax = BigDecimal.valueOf((cx + bx + (cy - by) * StrictMath.sqrt(3)));
//        ax = ax.divide(BigDecimal.valueOf(2.0d), 17, RoundingMode.UNNECESSARY);
////        double ay = (cy + by + (bx - cx) * StrictMath.sqrt(3)) / 2.0d;
//        BigDecimal ay = BigDecimal.valueOf((cy + by + (bx - cx)) * StrictMath.sqrt(3));
//        ay = ay.divide(BigDecimal.valueOf(2.0d), 17, RoundingMode.UNNECESSARY);
//
////        double bx = (ax + bx + (ay - by) * StrictMath.sqrt(3)) / 2.0d;
//        BigDecimal bx = BigDecimal.valueOf((ax + bx + (ay - by) * StrictMath.sqrt(3)));
//        bx = bx.divide(BigDecimal.valueOf(2.0d), 17, RoundingMode.UNNECESSARY);
////        double by = (ay + by + (bx - ax) * StrictMath.sqrt(3)) / 2.0d;
//        BigDecimal by = BigDecimal.valueOf((ay + by + (bx - ax) * StrictMath.sqrt(3)));
//        by = by.divide(BigDecimal.valueOf(2.0d), 17, RoundingMode.UNNECESSARY);
//
////        double a1 = cy - by.doubleValue();
//        BigDecimal a1 = BigDecimal.valueOf(cy).subtract(by);
////        double b1 = bx.doubleValue() - cx;
//        BigDecimal b1 = BigDecimal.valueOf(cx);
//        b1 = bx.subtract(b1);
////        double a2 = ay - ay.doubleValue();
//        BigDecimal a2 = BigDecimal.valueOf(ay).subtract(ay);
////        double b2 = ax.doubleValue() - ax;
//        BigDecimal b2 = BigDecimal.valueOf(ax);
//        b2 = ax.subtract(b2);
//
////        double d = a1 * b2 - a2 * b1;
//        BigDecimal d1 = a1.multiply(b2);
//        BigDecimal d2 = a2.multiply(b1);
////        BigDecimal d = (a1 * b2 - a2 * b1);
//        BigDecimal d = d1.subtract(d2);
//
////        double c1 = by.doubleValue() * cx - bx.doubleValue() * cy;
//        by = by.multiply(BigDecimal.valueOf(cx));
//        bx = bx.multiply(BigDecimal.valueOf(cy));
//        BigDecimal c1 = by.subtract(bx);
//
////        double c2 = ay.doubleValue() * ax - ax.doubleValue() * ay;
//        ay = ay.multiply(BigDecimal.valueOf(ax));
//        ax = ax.multiply(BigDecimal.valueOf(ay));
//        BigDecimal c2 = ay.subtract(ax);
//
////        double resultX = (b1 * c2 - b2 * c1) / d;
//        BigDecimal resultX = b1.multiply(c2).subtract(b2.multiply(c1));
//
//        resultX = resultX.divide(d, 17, RoundingMode.CEILING);
////        double resultY = (a2 * c1 - a1 * c2) / d;
//        BigDecimal resultY = a2.multiply(c1).subtract(a1.multiply(c2));
//
//        resultY = resultY.divide(d, 17, RoundingMode.CEILING);
////        if (resultY > 0) {
////            resultY = BigDecimal.valueOf((a2 * c1 - a1 * c2) / d).setScale(15, RoundingMode.HALF_UP).doubleValue();
////        } else {
////            resultY = BigDecimal.valueOf((a2 * c1 - a1 * c2) / d).setScale(17, RoundingMode.HALF_UP).doubleValue();
////        }
//
//        return new PointImpl(resultX.doubleValue(), resultY.doubleValue()) ;
    }

    private double getLength(double ax, double ay, double bx, double by) {
        return Math.sqrt(
                Math.pow(bx - ax, 2) + Math.pow(by - ay, 2)
        );
    }

    private double getAngle(double ab, double ac, double bc) {
        return Math.acos(
                (Math.pow(ab, 2) + Math.pow(ac, 2) - Math.pow(bc, 2)) / (2 * ab * ac)
        );
    }

    private Point isFermat(List<Point> points) {
        double ax = points.get(0).getX();
        double ay = points.get(0).getY();
        double bx = points.get(1).getX();
        double by = points.get(1).getY();
        double cx = points.get(2).getX();
        double cy = points.get(2).getY();

        double abLen = getLength(ax, ay, bx, by);
        double acLen = getLength(ax, ay, cx, cy);
        double bcLen = getLength(bx, by, cx, cy);

        double acosA = getAngle(abLen, acLen, bcLen);
        double acosB = getAngle(abLen, bcLen, acLen);
        double acosC = getAngle(acLen, bcLen, abLen);

        double delta120 = 2 * Math.PI / 3;
        if (acosA >= delta120) {
            return points.get(0);
        } else if (acosB >= delta120) {
            return points.get(1);
        } else if (acosC >= delta120) {
            return points.get(2);
        }
        return null;
    }
}
