package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointFactoryImpl;

/**
 * Proven by Bonaventura Francesco Cavalieri in the book
 * "Exercitationes geometricae sex" 1647. The theory goes,
 * if the triangle has an angle of 120 degrees or more the
 * Toricelli point lies at the vertex of the large angle.
 * Otherwise the point at which the simpson lines intersect
 * is said to be the optimal solution.
 * To find an intersection in 2D, all that is needed is 2
 * lines (segments), hence not all three of the simpson
 * lines are calculated.
 *
 * @author Sergei Titov
 *
 */
public class FermatToricelliPoint {

    private static final int RightHandSide = -1;
    private static final int LeftHandSide  = +1;
    private static final int CollinearOrientation = 0;

    public static PointFactoryImpl<Double> factory = new PointFactoryImpl<>();


    /**
     * Finds a Fermat-Toricelli point for ABC triangle with coordinates:
     * (Ax, Ay), (Bx, By), (Cx, Cy).
     *
     * @param x1 - Ax
     * @param y1 - Ay
     * @param x2 - Bx
     * @param y2 - By
     * @param x3 - Cx
     * @param y3 - Cy
     *
     * @returns Fermat-Toricelli point coordinates
     */
    public static Point<Double> torricelli_point(final double x1, final double y1,
                                                 final double x2, final double y2,
                                                 final double x3, final double y3) {

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

        if (orientation(x1, y1, x2, y2, x3, y3) == RightHandSide) {
            oet1 = create_equilateral_triangle(x1, y1, x2, y2);
            oet2 = create_equilateral_triangle(x2, y2, x3, y3);
        } else {
            oet1 = create_equilateral_triangle(x2, y2, x1, y1);
            oet2 = create_equilateral_triangle(x3, y3, x2, y2);
        }

        return intersection_point(oet1.getX(), oet1.getY(), x3, y3,
                                  oet2.getX(), oet2.getY(), x1, y1);
    }

    /**
     * Returns a point of intersection of two line-segments.
     *
     * @param x1 - segment1 begin X-coordinate
     * @param y1 - segment1 begin Y-coordinate
     * @param x2 - segment1 end X-coordinate
     * @param y2 - segment1 end Y-coordinate
     * @param x3 - segment2 begin X-coordinate
     * @param y3 - segment2 begin Y-coordinate
     * @param x4 - segment2 end X-coordinate
     * @param y4 - segment2 end Y-coordinate
     *
     * @returns intersection point coordinates
     */
    public static Point<Double> intersection_point(final double x1, final double y1,
                                     final double x2, final double y2,
                                     final double x3, final double y3,
                                     final double x4, final double y4) {
        final double dx1 = x2 - x1;
        final double dx2 = x4 - x3;
        final double dx3 = x1 - x3;

        final double dy1 = y2 - y1;
        final double dy2 = y1 - y3;
        final double dy3 = y4 - y3;

        double ratio = dx1 * dy3 - dy1 * dx2;

        Double ix;
        Double iy;
        if (!is_equal(ratio, 0.0)) {
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

    /**
     * Builds equilateral_triangle on given line-segment.
     *
     * @param x1 - segment coordinate
     * @param y1 - segment coordinate
     * @param x2 - segment coordinate
     * @param y2 - segment coordinate
     *
     * @returns coordinates of the opposite to given line-segment point
     */
    public static Point<Double> create_equilateral_triangle(final double x1, final double y1,
                                                            final double x2, final double y2) {

        final double sin60 = 0.86602540378443864676372317075294;
        final double cos60 = 0.50000000000000000000000000000000;

        // translate for x1, y1 to be origin
        final double tx = x2 - x1;
        final double ty = y2 - y1;

        // rotate 60 degrees and translate back
        Double x3 = ((tx * cos60) - (ty * sin60)) + x1;
        Double y3 = ((ty * cos60) + (tx * sin60)) + y1;

        return factory.newInstance(x3, y3);
    }

    /**
     * Detects orientation of triangle points (clockwise or counterclockwise walk around).
     *
     * @param x1 - triangle vertex coordinate
     * @param y1 - triangle vertex coordinate
     * @param x2 - triangle vertex coordinate
     * @param y2 - triangle vertex coordinate
     * @param px - triangle vertex coordinate
     * @param py - triangle vertex coordinate
     *
     * @return value is positive if orientation is for counterclockwise walk around
     */
    public static int orientation(final double  x1, final double  y1,
                                  final double  x2, final double  y2,
                                  final double  px, final double  py) {

        final double orin = (x2 - x1) * (py - y1) - (px - x1) * (y2 - y1);

        if (orin > 0) {
            return LeftHandSide;         // Orientation is to the left-hand side
        } else if (orin < 0) {
            return RightHandSide;        // Orientation is to the right-hand side
        } else {
            return CollinearOrientation; // Orientation is neutral aka collinear
        }
    }

    /**
     * Checks is two double values are equal.
     *
     * @param val1 - value to check
     * @param val2 - value to check with
     *
     * @returns true if are equal
     */
    public static boolean is_equal(final double val1, final double val2) {
        return is_equal(val1, val2, 0.0000000001);
    }

    /**
     * Checks is two double values are equal (provided with custom epsilon).
     *
     * @param val1 - value to check
     * @param val2 - value to check with
     *
     * @returns true if are equal
     */
    public static boolean is_equal(final double val1, final double val2, final double epsilon) {

        double diff = val1 - val2;
        return ((-epsilon <= diff) && (diff <= epsilon));
    }

    /**
     * Checks if the angel between two rays (joint in one vertex) is more than 120 degree.
     *
     * @param leftRayX - ray coordinate
     * @param leftRayY - ray coordinate
     * @param vertexX - vertex coordinate
     * @param vertexY - vertex coordinate
     * @param rightRayX - ray coordinate
     * @param rightRayY - ray coordinate
     *
     * @return true if cos of angel between rays is in (-sqrt(3) / 2; 0)
     */
    public static boolean isWiderThan120(final double leftRayX, final double leftRayY,
                           final double vertexX, final double vertexY,
                           final double rightRayX, final double rightRayY) {
        // quantify coordinates
        final double x1 = leftRayX - vertexX;
        final double x2 = rightRayX - vertexX;
        final double y1 = leftRayY - vertexY;
        final double y2 = rightRayY - vertexY;

        // scalar product is negative for angles within [90 - 270]
        final double scalar = x1 * x2 + y1 * y2;
        if (scalar >= 0) {
            return false;
        }

        final double cos2 =
                (x1 * x1 * x2 * x2 + 2 * x1 * x2 * y1 * y2 + y1 * y1 * y2 * y2)
                        / ((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2));

        // cos2 (120) == 0.75
        return cos2 < 0.75000000000000000;
    }
}
