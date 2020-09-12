package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
        if (sourceGraph == null || actions == null || actions.size() == 0) {
            throw new IllegalArgumentException();
        }

        actions.forEach((GraphAction g) -> g.run(sourceGraph));
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

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(from);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Integer vert :
                        graph.getAdjacent(vertex)) {
                    stack.push(vert);
                }
            }
        }

        return visited.contains(to);

    }
}
