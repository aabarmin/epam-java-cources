package com.epam.university.java.core.task012;

import java.util.Collection;

/**
 * Graphs and others.
 */
public interface Task012 {
    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     * @param sourceGraph initial graph instance
     * @param actions collection of actions
     * @return updated graph instance
     */
    Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions);

    /**
     * Check is there path in <code>graph</code> between <code>from</code> and
     * <code>to</code> vertexes.
     * @param graph graph instance
     * @param from source vertex
     * @param to target vertex
     * @return is path exists
     */
    boolean pathExists(Graph graph, int from, int to);
}
