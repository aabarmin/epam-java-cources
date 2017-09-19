package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

/**
 * Created by ilya on 14.09.17.
 */
public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        actions.stream().forEach(a -> a.run(sourceGraph));
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        ArrayList<Integer> points = IntStream.range(1, graph.size() + 1)
            .collect(ArrayList<Integer>::new, (l, n) -> l.add(n), ArrayList::addAll);

        QuickUnionFindTree<Integer> tree = new QuickUnionFindTree<>(points);

        for (int point :
            points) {
            points.stream().filter(n -> n != point).filter(n -> graph.edgeExists(point, n))
                .forEach(n -> tree.connect(point, n));
        }

        return tree.isConnected(from, to);
    }
}
