package com.epam.university.java.core.task012;

import com.epam.university.java.core.task012.exceptions.GraphInitializationException;
import com.epam.university.java.core.task012.exceptions.VertexNotExistsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayDeque;


/**
 * Graphs and others.
 */
public final class Task012Impl implements Task012 {
    /**
     * Create new Graph instance and execute collection of actions. Return
     * the result graph instance.
     *
     * @param sourceGraph initial graph instance
     * @param actions     collection of actions
     * @return updated graph instance
     */
    @Override
    public Graph invokeActions(final Graph sourceGraph,
                               final Collection<GraphAction> actions) {
        Graph resultGraph = GraphFactoryImpl.copy(sourceGraph);
        for (GraphAction a : actions) {
            a.run(resultGraph);
        }
        return resultGraph;
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
    public boolean pathExists(final Graph graph, final int from, final int to) {
        if (null == graph) {
            throw new GraphInitializationException(
                    "Trying to check null graph.");
        }
        if (!(graph instanceof GraphImpl)) {
            throw new GraphInitializationException(
                    "Trying to check non-instantiated graph.");
        }

        //check if such from-and-to vertexes exist in the graph.
        if (!((GraphImpl) graph).getVertexes().containsKey(from)
                || !((GraphImpl) graph).getVertexes().containsKey(to)) {
            throw new VertexNotExistsException("Vertex doesn't exist.");
        }

        //the destination is right in the start!
        if (from == to) {
            return true;
        }

        Set<Integer> visitedVertexes = new HashSet<>();
        Queue<Integer> vertexStack = new ArrayDeque<>();
        vertexStack.add(to);

        // building a stack of unchecked nodes, check,
        // then move them to Visited-Set,
        // then continue traversing the graph.
        while (!vertexStack.isEmpty()) {
            int currentVertex = vertexStack.poll();
            if (graph.edgeExists(currentVertex, from)) {
                return true;
            }
            visitedVertexes.add(currentVertex);
            for (Integer i : graph.getAdjacent(currentVertex)) {
                if (!visitedVertexes.contains(i)) {
                    vertexStack.add(i);
                }
            }
        }
        return false;
    }
}
