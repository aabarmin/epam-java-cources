package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        return graph.hasPath(from, to);
    }
}
