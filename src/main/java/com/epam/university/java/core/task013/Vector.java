package com.epam.university.java.core.task013;

/**
 * Created by ilya on 15.09.17.
 */
public class Vector {

    private int coordX;
    private int coordY;

    public Vector(Vertex start, Vertex end) {
        this.coordX = end.getCoordX() - start.getCoordX();
        this.coordY = end.getCoordY() - start.getCoordY();
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public int multiplyVector(Vector vector) {
        return coordX * vector.getCoordY() - coordY * vector.getCoordX();
    }
}
