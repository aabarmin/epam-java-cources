package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

/**
 * Implementation class for Task012.
 *
 * @author Sergei Titov
 */
public class Task012Impl implements Task012 {

    private Set<Integer> ignoreSet = new TreeSet<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {

        if (to == from) {
            return true;
        }
        ignoreSet.add(from);

        for (int adj : graph.getAdjacent(from)) {

            if (ignoreSet.contains(adj)) {
                continue;
            }

            if (pathExists(graph, adj, to)) {
                ignoreSet.clear();
                return true;
            }
        }
        return false;
    }
}
