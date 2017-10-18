package com.epam.university.java.core.task012;

import java.util.ArrayList;
import java.util.Collection;


public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph.edgeExists(from, to)) {
            return true;
        }
        Collection<Integer> adjacentVertex = graph.getAdjacent(from);
        for (int vertex : adjacentVertex) {
            graph.removeEdge(from, vertex);
        }
        for (int vertex : adjacentVertex) {
            if (this.pathExists(graph, vertex, to)) {
                return true;
            }
        }
        for (Integer vertex : adjacentVertex) {
            graph.createEdge(from, vertex);
        }
        return false;
    }
}
