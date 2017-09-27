package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Task012Impl implements Task012 {
    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions     collection of actions
     * @return updated graph instance
     */
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {

        if (sourceGraph == null || actions == null) {
            throw new IllegalArgumentException();
        }

        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }

        return sourceGraph;

    }

    /**
     * Check is there path in <code>graph</code> between <code>from</code> and
     * <code>to</code> vertexes.
     *
     * @param graph graph instance
     * @param from  source vertex
     * @param to    target vertex
     * @return is path exists
     */
    @Override
    public boolean pathExists(Graph graph, int from, int to) {

        if (graph == null) {
            throw new IllegalArgumentException();
        }

        // Also could be done with List removeAll / addAll realization,
        // but with Set must be faster
        LinkedHashSet<Integer> vertexes = new LinkedHashSet<>();
        vertexes.add(from);

        Iterator<Integer> i = vertexes.iterator();

        int nextCalls = 0;

        while (i.hasNext()) {

            Integer vertex = i.next();
            nextCalls++;

            if (vertex.equals(to)) {
                return true;
            }

            Collection<Integer> nextVertexes = graph.getAdjacent(vertex);
            vertexes.addAll(nextVertexes);

            i = vertexes.iterator();
            for (int j = 0; j < nextCalls; j++) {
                i.next();
            }

        }

        return false;

    }

}
