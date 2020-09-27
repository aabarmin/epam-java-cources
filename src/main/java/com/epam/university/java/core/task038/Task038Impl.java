package com.epam.university.java.core.task038;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author Dmitry Novikov 21-Sep-20.
 */
public class Task038Impl implements Task038 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (actions == null || sourceGraph == null
                || actions.isEmpty()
        ) {
            throw new IllegalArgumentException();
        }

        for (GraphAction action : actions
        ) {
            action.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        GraphImpl myGraph = (GraphImpl) graph;
        List<VertexImpl> vertices = myGraph.getVertexes();

        Map<Integer, List<Integer>> connectedVertexesId = myGraph.getConnectedVertexesId();
        List<Integer> path = connectedVertexesId.get(startId);

        Set<Vertex> result = new LinkedHashSet<>();
        result.add(getVertexById(vertices, startId));

        if (path.contains(endId)) {
            result.add(getVertexById(vertices, endId));
            return result;
        }

        Set<Vertex> tempCollection = new LinkedHashSet<>();

        if (path.size() == 0) {
            return new LinkedHashSet<>();
        } else {
            for (Integer id : path) {
                tempCollection.addAll(result);

                result.addAll(getShortestPath(graph, id, endId));

                if (result.contains(getVertexById(vertices, endId))) {
                    break;
                }
            }
        }

        if (tempCollection.containsAll(result)) {
            result.remove(getVertexById(vertices, startId));
        }

        return result;
    }

    private VertexImpl getVertexById(List<VertexImpl> list, int id) {
        VertexImpl findVertex = null;
        for (VertexImpl vertex : list) {
            if (vertex.getId() == id) {
                findVertex = vertex;
            }
        }
        return findVertex;
    }
}
