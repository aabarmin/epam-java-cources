package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;

/**
 * Created by ilya on 23.09.17.
 */
public class Vector {

    private double coordX;
    private double coordY;

    private Vector() {

    }

    public Vector(Point first, Point second) {
        coordX = first.getX() - second.getX();
        coordY = first.getY() - second.getY();
    }

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public double scalarMultiplication(Vector vector) {
        return this.coordX * vector.coordX + this.coordY * vector.coordY;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(coordX, 2) + Math.pow(coordY, 2));
    }

    /**
     * Calculate normalized perpendicular vector left.
     *
     * @return vector
     */
    public Vector normPrepLeft() {
        Vector vector = new Vector();
        vector.coordX = -this.coordY / this.getLength();
        vector.coordY = this.coordX / this.getLength();
        return vector;
    }

    /**
     * Calculate normalized perpendicular vector right.
     *
     * @return vector
     */
    public Vector normPrepRight() {
        Vector vector = new Vector();
        vector.coordX = this.coordY / this.getLength();
        vector.coordY = -this.coordX / this.getLength();
        return vector;
    }
}
