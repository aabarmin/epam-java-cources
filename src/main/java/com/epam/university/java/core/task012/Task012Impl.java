package com.epam.university.java.core.task012;

import java.util.Collection;

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
        int size = graph.getAdjacent(from).size();

        State[] visited = new State[size];
        visited[from] = State.VISITED;


        for (int i = 0; i < size; i++) {
            if (visited[i] == State.VISITED) {
                visited[i] = State.PASSED;

                for (int index : graph.getAdjacent(i)) {
                    if (visited[index] == State.NOT_VISITED) {
                        visited[index] = State.VISITED;
                    }
                }
                //go to start
                i = -1;
            }

            if (visited[to] != State.NOT_VISITED) {
                return true;
            }
        }

        return false;
    }

    enum State {
        NOT_VISITED, VISITED, PASSED
    }
}
