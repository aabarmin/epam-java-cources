package com.epam.university.java.core.task012;

import java.util.Collection;

/**
 * Created by Daniil Smirnov on 18.09.2017.
 * All copy registered MF.
 */
public class Task012Impl implements Task012 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction a : actions) {
            a.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        return graph.getAdjacent(from).contains(to);
    }
}
