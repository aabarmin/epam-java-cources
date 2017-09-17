package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Created by ilya on 15.09.17.
 */
public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        actions.stream().forEach(a -> a.run(figure));
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        Collection<Vertex> vertices = figure.getVertexes();
        List<Vector> vectors = new LinkedList<>();

        roundIteration(vectors, vertices, (v1, v2) -> (new Vector(v1, v2)));

        List<Integer> mult = new ArrayList<>();

        roundIteration(mult, vectors, (v1, v2) -> (v1.multiplyVector(v2)));

        List<Integer> negative = mult.stream().filter(n -> n < 0).collect(Collectors.toList());
        int positive = mult.size() - negative.size();

        return negative.size() == 0 || positive == 0;
    }

    private <T, E> void roundIteration(Collection<? super E> result,
        Collection<? extends T> collection, BiFunction<T, T, E> function) {
        Iterator<? extends T> iterator = collection.iterator();
        T last = iterator.next();
        T first = last;
        do {
            if (iterator.hasNext()) {
                T current = iterator.next();
                result.add(function.apply(last, current));
                last = current;
            } else {
                result.add(function.apply(last, first));
                break;
            }
        } while (true);
    }
}
