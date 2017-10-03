package com.epam.university.java.core.task012;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.exceptions.CollectionFullException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class implements <code>Graph</code>.
 */
public class GraphImpl implements Graph {

    private Map<Integer, Set> mapOfVertices;
    private int numberOfVertices;
    public static String MESSAGE_FOR_COLLECTION_IS_FULL_EXCEPTION =
            "Graph is full, adding new vertex is impossible";

    /**
     * Initialisation of graph.
     *
     * @param numberOfVertices number of vertices
     * @throws IllegalArgumentException if parameter is negative
     */
    public GraphImpl(int numberOfVertices) {
        Validator.validateNotNegative(numberOfVertices,
                Validator.MESSAGE_IF_NEGATIVE);
        this.numberOfVertices = numberOfVertices;
        this.mapOfVertices = new HashMap<>();
    }

    public GraphImpl(Map<Integer, Set> mapOfVertices, int numberOfVertices) {
        this.mapOfVertices = mapOfVertices;
        this.numberOfVertices = numberOfVertices;
    }

    /**
     * Get map of vertices.
     *
     * @return <code>Map</code> collection of vertices
     */
    public Map<Integer, Set> getMapOfVertices() {
        return mapOfVertices;
    }

    @Override
    public void createEdge(int from, int to) {
        Validator.validateNotNegative(from, to,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);
        subCreateEdge(from, to);
        subCreateEdge(to, from);
    }

    /**
     * Adding new edge.
     *
     * @param from first vertex of new edge
     * @param to   second vertex of new edge
     */
    public void subCreateEdge(int from, int to) {
        if (!mapOfVertices.containsKey(to)) {
            if (mapOfVertices.size() == numberOfVertices) {
                throw new CollectionFullException(
                        MESSAGE_FOR_COLLECTION_IS_FULL_EXCEPTION);
            }
            mapOfVertices.put(Integer.valueOf(to), new TreeSet());
            mapOfVertices.get(Integer.valueOf(to)).add(from);
        } else {
            mapOfVertices.get(Integer.valueOf(to)).add(from);
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Validator.validateNotNegative(from, to,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);
        if (mapOfVertices.containsKey(from) && mapOfVertices.get(from)
                .contains(to)) {
            return true;
        }
        return false;
    }

    @Override
    public void removeEdge(int from, int to) {
        Validator.validateNotNegative(from, to,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);

        if (mapOfVertices.containsKey(from)) {
            if ((mapOfVertices.get(from).size() == 1
                    && (mapOfVertices.get(from).contains(to)))) {
                mapOfVertices.remove(from);
            } else {
                mapOfVertices.get(from).remove(to);
            }
        }
        if (mapOfVertices.containsKey(to)) {
            if ((mapOfVertices.get(to).size() == 1)
                    && (mapOfVertices.get(to).contains(from))) {
                mapOfVertices.remove(to);
            } else {
                mapOfVertices.get(to).remove(from);
            }
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        Validator.validateNotNegative(from, Validator.MESSAGE_IF_NEGATIVE);
        return mapOfVertices.get(from);
    }

    @Override
    public String toString() {
        return "GraphImpl{mapOfVertices=" + mapOfVertices
                + ", numberOfVertices=" + numberOfVertices + '}';
    }
}