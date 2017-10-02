package com.epam.university.java.core.task013;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.GrahamScan;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class implements Task013.
 */
public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction>
            actions) {
        Validator.validateNotNull(figure, actions, Validator
                        .MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        for (FigureAction figureAction : actions) {
            figureAction.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        Validator.validateNotNull(figure, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        List<Vertex> inputVertexList = new ArrayList<>(figure.getVertices());
        Point2D[] points = new Point2D[inputVertexList.size()];
        for (int i = 0; i < inputVertexList.size(); i++) {
            points[i] = new Point2D(inputVertexList.get(i).getX(),
                    inputVertexList.get(i).getY());
        }
        GrahamScan graham = new GrahamScan(points);
        if (graham.getHull().size() == inputVertexList.size() && graham
                .isConvex()) {
            // prints the extreme points on the convex hull in
            // counterclockwise order
            graham.getHull().stream().map(point2D -> new VertexImpl((int)
                    point2D.getCoordinateX(), (int) point2D.getCoordinateY()))
                    .forEach(System.out::print);
            System.out.println(System.lineSeparator());
            return true;
        } else {
            return false;
        }
    }
}