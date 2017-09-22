package com.epam.university.java.core.task013;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 20.09.2017.
 */
public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        // найти самую нижнюю точку - это будет первая точка
        // отсортировать все оставшиеся точки относительно найденной первой точки
        // по возрастанию полярного угла
        // далее действовать по алгоритму Грэхема
        for (Vertex v: figure.getVertexes()) {

        }
        return false;
    }
}
