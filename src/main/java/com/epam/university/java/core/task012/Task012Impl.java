package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

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
        boolean isNull = sourceGraph == null || actions == null;
        if (isNull) {
            throw new IllegalArgumentException();
        }
        boolean isEmpty = actions.isEmpty();
        if (isEmpty) {
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
        if (from > ((GraphImpl) graph).vertexesCount || to > ((GraphImpl) graph).vertexesCount) {
            throw new IllegalArgumentException();
        }
        boolean[] visited = new boolean[((GraphImpl) graph).vertexesCount + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[from] = true;
        queue.add(from);
        while (queue.size() != 0) {
            from = queue.poll();
            LinkedList<Integer> adjacents = (LinkedList<Integer>) graph.getAdjacent(from);
            Iterator<Integer> i = (adjacents).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (n == to) {
                    return true;
                }
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return false;
    }
}
