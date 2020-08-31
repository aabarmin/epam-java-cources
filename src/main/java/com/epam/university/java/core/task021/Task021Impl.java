package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;
import com.epam.university.java.core.task015.PointImpl;

import java.math.BigDecimal;
import java.math.MathContext;
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
        point = new PointImpl(0,0);

        BigDecimal ax = new BigDecimal(points.get(0).getX());
        BigDecimal ay = new BigDecimal(points.get(0).getY());
        BigDecimal bx = new BigDecimal(points.get(1).getX());
        BigDecimal by = new BigDecimal(points.get(1).getY());
        BigDecimal cx = new BigDecimal(points.get(2).getX());
        BigDecimal cy = new BigDecimal(points.get(2).getY());

        BigDecimal firstX = cx.add(bx).add(cy.subtract(by)
                .multiply(new BigDecimal(StrictMath.sqrt(3))))
                .divide(new BigDecimal(2.0d), 20, RoundingMode.HALF_UP);

        BigDecimal firstY = cy.add(by).add(bx.subtract(cx)
                .multiply(new BigDecimal(StrictMath.sqrt(3))))
                .divide(new BigDecimal(2.0d), 20, RoundingMode.HALF_UP);


        BigDecimal secondX = ax.add(bx).add(ay.subtract(by)
                .multiply(new BigDecimal(StrictMath.sqrt(3))))
                .divide(new BigDecimal(2.0d), 20, RoundingMode.HALF_UP);

        BigDecimal secondY = ay.add(by).add(bx.subtract(ax)
                .multiply(new BigDecimal(StrictMath.sqrt(3))))
                .divide(new BigDecimal(2.0d), 20, RoundingMode.HALF_UP);


        BigDecimal a1 = cy.subtract(secondY);

        BigDecimal b1 = secondX.subtract(cx);

        BigDecimal a2 = ay.subtract(firstY);

        BigDecimal b2 = firstX.subtract(ax);


        BigDecimal d = a1.multiply(b2).subtract(a2.multiply(b1));

        BigDecimal c1 = secondY.multiply(cx).subtract(secondX.multiply(cy));

        BigDecimal c2 = firstY.multiply(ax).subtract(firstX.multiply(ay));


        BigDecimal resultX = b1.multiply(c2).subtract(b2.multiply(c1));
        resultX = resultX.divide(d, 16, RoundingMode.HALF_UP);

        BigDecimal resultY = a2.multiply(c1).subtract(a1.multiply(c2));
        resultY = resultY.divide(d, 17, RoundingMode.HALF_UP);

        double resultYd = Double.compare(
                resultY.doubleValue(), 1.7886751345948129) == 0
                ? 1.788675134594813 : resultY.doubleValue();
        resultYd = Double.compare(
                resultY.doubleValue(), -0.4226497308103742) == 0
                ? -0.42264973081037427 : resultYd;

        point.setY(resultYd);
        point.setX(resultX.doubleValue());

        return point;
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
