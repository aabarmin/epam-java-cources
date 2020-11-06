package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task038Impl implements Task038 {

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        GraphImpl graph1 = (GraphImpl) graph;
        List<VertexImpl> visitedVertices = new ArrayList<>();
        List<VertexImpl> unvisitedVertices = new ArrayList<>();
        List<VertexImpl> listOfVertices = graph1.getListOfVertices();
        VertexImpl currentVertex = null;
        VertexImpl destinationVertex = null;

        for (VertexImpl vertex : listOfVertices) {
            if (vertex.getId() == startId) {
                currentVertex = vertex;
                currentVertex.setDistance(0.0);
                unvisitedVertices.add(vertex);
            }

            if (vertex.getId() == endId) {
                destinationVertex = vertex;
            }
        }

        if (destinationVertex == null || currentVertex == null) {
            return null;
        }

        while (unvisitedVertices.size() != 0) {
            currentVertex = getTheLowestDistance(unvisitedVertices);
            unvisitedVertices.remove(currentVertex);
            for (Map.Entry<VertexImpl, Double> adjacencyPair
                    : currentVertex.getAdjacentVertices().entrySet()) {
                VertexImpl adjacentVertex = adjacencyPair.getKey();
                Double adjacentVertexWeight = adjacencyPair.getValue();
                if (!visitedVertices.contains(adjacentVertex)) {
                    calculateTheMinimalDistance(currentVertex,
                            adjacentVertex,
                            adjacentVertexWeight);
                    unvisitedVertices.add(adjacentVertex);
                }
            }
            visitedVertices.add(currentVertex);
        }

        if (destinationVertex.shortestPath.size() != 0) {
            destinationVertex.shortestPath.add(destinationVertex);
            return destinationVertex.shortestPath;
        } else {
            return Collections.emptyList();
        }
    }

    private VertexImpl getTheLowestDistance(List<VertexImpl> vertexList) {
        VertexImpl lowestDistanceVertex = null;
        Double lowestDistance = Double.MAX_VALUE;
        for (VertexImpl vertex :
                vertexList) {
            if (vertex.getDistance() < lowestDistance) {
                lowestDistance = vertex.getDistance();
                lowestDistanceVertex = vertex;
            }
        }


        return lowestDistanceVertex;
    }

    private void calculateTheMinimalDistance(VertexImpl vertexFrom,
                                             VertexImpl vertexTo,
                                             Double currentDistance) {
        Double fromDistance = vertexFrom.getDistance();
        if (currentDistance + fromDistance < vertexTo.getDistance()) {
            vertexTo.setDistance(currentDistance + fromDistance);
            Collection<Vertex> shortestPath = new LinkedList<>(vertexFrom.getShortestPath());
            shortestPath.add(vertexFrom);
            vertexTo.setShortestPath(shortestPath);
        }
    }
}
