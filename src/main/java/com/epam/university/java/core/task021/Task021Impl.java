package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;
import com.epam.university.java.core.task015.PointImpl;

import java.util.Collection;

/**
 * Implementation class for Task021.
 *
 * @author Sergei Titov
 */
public class Task021Impl implements Task021 {

    static final int RightHandSide = -1;
    static final int LeftHandSide  = +1;
    static final int CollinearOrientation = 0;

    public static PointFactoryImpl<Double> factory = new PointFactoryImpl();


    /**
     * {@inheritDoc}
     */
    @Override
    public Point calculate(Collection<Point> minePositions) {

        Point<Number>[] points = (Point<Number>[])minePositions.toArray();

        double x1 = points[0].getX().doubleValue();
        double y1 = points[0].getY().doubleValue();
        double x2 = points[1].getX().doubleValue();
        double y2 = points[1].getY().doubleValue();
        double x3 = points[2].getX().doubleValue();
        double y3 = points[2].getY().doubleValue();

        return torricelli_point(x1, y1,
                x2, y2,
                x3, y3);
    }


    // torricelli_point
    private Point<Double> torricelli_point(final double x1, final double y1,
                                  final double x2, final double y2,
                                  final double x3, final double y3)
    {
      /*
         Proven by Bonaventura Francesco Cavalieri in the book
         "Exercitationes geometricae sex" 1647. The theory goes,
         if the triangle has an angle of 120 degrees or more the
         toricelli point lies at the vertex of the large angle.
         Otherwise the point at which the simpson lines intersect
         is said to be the optimal solution.
         To find an intersection in 2D, all that is needed is 2
         lines (segments), hence not all three of the simpson
         lines are calculated.
      */
        if (isWiderThan120(x1, y1, x2, y2, x3, y3)) {
            return factory.newInstance(x2, y2);
        }
        if (isWiderThan120(x3, y3, x1, y1, x2, y2)) {
            return factory.newInstance(x1, y1);
        }
        if (isWiderThan120(x2, y2, x3, y3, x1, y1)) {
            return factory.newInstance(x3, y3);
        }

        Point<Double> oet1;
        Point<Double> oet2;

        if (orientation(x1, y1, x2, y2, x3, y3) == RightHandSide)
        {
            oet1 = create_equilateral_triangle(x1, y1, x2, y2);
            oet2 = create_equilateral_triangle(x2, y2, x3, y3);
        }
        else
        {
            oet1 = create_equilateral_triangle(x2, y2, x1, y1);
            oet2 = create_equilateral_triangle(x3, y3, x2, y2);
        }

        return intersection_point(oet1.getX(), oet1.getY(), x3, y3, oet2.getX(), oet2.getY(), x1, y1);
    }

    // intersection_point
    Point<Double> intersection_point(final double x1, final double y1,
                            final double x2, final double y2,
                            final double x3, final double y3,
                            final double x4, final double y4)
    {
        final double dx1 = x2 - x1;
        final double dx2 = x4 - x3;
        final double dx3 = x1 - x3;

        final double dy1 = y2 - y1;
        final double dy2 = y1 - y3;
        final double dy3 = y4 - y3;

        double ratio = dx1 * dy3 - dy1 * dx2;

        Double ix = 0.0;
        Double iy = 0.0;
        if (not_equal(ratio, 0.0)) {
            ratio = (dy2 * dx2 - dx3 * dy3) / ratio;
            ix    = x1 + ratio * dx1;
            iy    = y1 + ratio * dy1;
        } else if (is_equal((dx1 * -dy2), (-dx3 * dy1))) {
            ix = x3;
            iy = y3;
        } else {
            ix = x4;
            iy = y4;
        }


        return factory.newInstance(ix, iy);
    }

    // create_equilateral_triangle
    Point<Double> create_equilateral_triangle(final double x1, final double y1,
                                     final double x2, final double y2)
    {
        final double sin60 = 0.86602540378443864676372317075294;
        final double cos60 = 0.50000000000000000000000000000000;

        /* translate for x1,y1 to be origin */
        final double tx = x2 - x1;
        final double ty = y2 - y1;

        /* rotate 60 degrees and translate back */
        Double x3 = ((tx * cos60) - (ty * sin60)) + x1;
        Double y3 = ((ty * cos60) + (tx * sin60)) + y1;

        return factory.newInstance(x3, y3);
    }

    // orientation
    int orientation(final double  x1, final double  y1,
                    final double  x2, final double  y2,
                    final double  px, final double  py)
    {
        final double orin = (x2 - x1) * (py - y1) - (px - x1) * (y2 - y1);

        if (orin > 0) {
            return LeftHandSide;         // Orientation is to the left-hand side
        }
        else if (orin < 0) {
            return RightHandSide;        // Orientation is to the right-hand side
        }
        else {
            return CollinearOrientation; // Orientation is neutral aka collinear
        }
    }

    // not_equal
    boolean not_equal(final double val1, final double val2) {
        return !is_equal(val1, val2);
    }

    // is_equal
    boolean is_equal(final double val1, final double val2) {
        return is_equal(val1, val2, 0.0000000001);
    }

    // is_equal( with epsilon )
    boolean is_equal(final double val1, final double val2, final double epsilon) {
        double diff = val1 - val2;

        //assert(((-epsilon <= diff) && (diff <= epsilon)) == (abs(diff) <= epsilon));

        return ((-epsilon <= diff) && (diff <= epsilon));
    }

    // inWiderThan120
    boolean isWiderThan120(final double x1_, final double y1_,
                           final double x2_, final double y2_,
                           final double x3_, final double y3_)
    {
        // quantify coordinates
        final double x1 = x1_ - x2_;
        final double x3 = x3_ - x2_;
        final double y1 = y1_ - y2_;
        final double y3 = y3_ - y2_;

        // scalar product
        final double scalar = x1 * x3 + y1 * y3;
        if (scalar >= 0) {
            return false;
        }

        final double cos2 =
                (x1 * x1 * x3 * x3 + 2 * x1 * x3 * y1 * y3 + y1 * y1 * y3 * y3)
                / ((x1 * x1 + y1 * y1) * (x3 * x3 + y3 * y3));

        // cos2 (120) == 0.75
        return cos2 < 0.75000000000000000;
    }
}
