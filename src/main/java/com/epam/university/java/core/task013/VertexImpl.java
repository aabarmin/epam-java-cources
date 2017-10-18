package com.epam.university.java.core.task013;

/**
 * Created by ilya on 15.09.17.
 */
public class VertexImpl implements Vertex {

    private int coordX;
    private int coordY;

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int value) {
        coordX = value;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int value) {
        coordY = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        VertexImpl vertex = (VertexImpl) o;

        if (coordX != vertex.coordX) {
            return false;
        }
        return coordY == vertex.coordY;
    }

    @Override
    public int hashCode() {
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }
}
