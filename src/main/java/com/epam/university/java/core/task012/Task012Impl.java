package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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
        actions.forEach(ga -> ga.run(sourceGraph));
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
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(from);

        while (!stack.empty()) {
            Integer currentVertex = stack.pop();
            visited.add(currentVertex);
            graph.getAdjacent(currentVertex).forEach((v) -> {
                if (!visited.contains(v) && !stack.contains(v)) {
                    stack.push(v);
                }
            });
        }

        return visited.contains(to);
    }

    enum State {
        NOT_VISITED, VISITED, PASSED
    }
}
