package com.epam.university.java.core.task013;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements Vertex.
 */
public class VertexImpl implements Vertex {
    private int coordinateX;
    private int coordinateY;

    /**
     * Initialisation of two-dimensional vertex.
     *
     * @param coordinateX value of coordinate x
     * @param coordinateY value of coordinate y
     * @throws IllegalAccessException if at least one of parameters violates
     *                                permitted range
     */
    public VertexImpl(int coordinateX, int coordinateY) {
        Validator.validateValueRange(coordinateX, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateValueRange(coordinateY, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    @Override
    public int getX() {
        return coordinateX;
    }

    @Override
    public void setX(int value) {
        Validator.validateValueRange(value, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.coordinateX = value;
    }

    @Override
    public int getY() {
        return coordinateY;
    }

    @Override
    public void setY(int value) {
        Validator.validateValueRange(value, Integer.MIN_VALUE,
                Integer.MAX_VALUE, Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.coordinateY = value;
    }

    @Override
    public String toString() {
        return "VertexImpl{" + "x=" + coordinateX + ", y=" + coordinateY
                + "}; ";
    }
}