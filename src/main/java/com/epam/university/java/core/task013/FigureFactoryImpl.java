package com.epam.university.java.core.task013;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements factory of <code>Figure</code> class.
 */
public class FigureFactoryImpl implements FigureFactory {
    @Override
    public Figure newInstance(int vertexCount) {
        Validator.validateNotNegative(vertexCount, Validator
                .MESSAGE_IF_NEGATIVE);
        return new FigureImpl(vertexCount);
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}