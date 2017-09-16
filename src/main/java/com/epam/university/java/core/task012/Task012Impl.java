package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        GraphFactoryImpl graphFactory = new GraphFactoryImpl();
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        if (graph.edgeExists(from, to)) {
            return true;
        }
        Collection<Integer> neighbours = graph.getAdjacent(from);
        for (Integer neighbour : neighbours) {
            if (pathExists(graph, neighbour, to)) {
                return true;
            }
        }
        return false;
    }
}
