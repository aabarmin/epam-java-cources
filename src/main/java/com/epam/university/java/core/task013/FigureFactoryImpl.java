package com.epam.university.java.core.task013;

/**
 * @author Dmitry Novikov 02-Sep-20
 */
public class FigureFactoryImpl implements FigureFactory{
    @Override
    public Figure newInstance(int vertexCount) {
        Figure myFigure = new FigureImpl();
        for (int i = 0; i < vertexCount; i++) {
            myFigure.addVertex(new VertexImpl(0,0));
        }
        return null;
    }

    @Override
    public Vertex newInstance(int x, int y) {
        return new VertexImpl(x, y);
    }
}
