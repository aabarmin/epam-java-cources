package com.epam.university.java.core.task013;

/**
 * Created by ilya on 15.09.17.
 */
public class Vector {

    private int x;
    private int y;

    public Vector(Vertex start, Vertex end) {
        this.x = end.getX() - start.getX();
        this.y = end.getY() - start.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int multiplyVector(Vector vector){
        return x*vector.getY()-y*vector.getX();
    }
}
