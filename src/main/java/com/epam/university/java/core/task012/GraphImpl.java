package com.epam.university.java.core.task012;

import com.epam.university.java.core.utils.Validator;
import com.epam.university.java.core.utils.exceptions.CollectionFullException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GraphImpl implements Graph {
    public GraphImpl(int numberOfVertexes) {
        this.numberOfVertexes = numberOfVertexes;
        this.mapOfVertexes = new HashMap<>();
    }

    private Map<Integer, Set> mapOfVertexes;
    private int numberOfVertexes;
    public static String MESSAGE_FOR_COLLECTION_IS_FULL_EXCEPTION =
            "Graph is full, adding new vertex is impossible";

    public Map<Integer, Set> getMapOfVertexes() {
        return mapOfVertexes;
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
        if (!mapOfVertexes.containsKey(to)) {
            if (mapOfVertexes.size() == numberOfVertexes) {
                throw new CollectionFullException(
                        MESSAGE_FOR_COLLECTION_IS_FULL_EXCEPTION);
            }
            mapOfVertexes.put(Integer.valueOf(to), new TreeSet());
            mapOfVertexes.get(Integer.valueOf(to)).add(from);
        } else {
            mapOfVertexes.get(Integer.valueOf(to)).add(from);
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        Validator.validateNotNegative(from, to,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);
        if (mapOfVertexes.containsKey(from) && mapOfVertexes.get(from)
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

        if (mapOfVertexes.containsKey(from)) {
            if ((mapOfVertexes.get(from).size() == 1
                    && (mapOfVertexes.get(from).contains(to)))) {
                mapOfVertexes.remove(from);
            } else {
                mapOfVertexes.get(from).remove(to);
            }
        }
        if (mapOfVertexes.containsKey(to)) {
            if ((mapOfVertexes.get(to).size() == 1)
                    && (mapOfVertexes.get(to).contains(from))) {
                mapOfVertexes.remove(to);
            } else {
                mapOfVertexes.get(to).remove(from);
            }
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        Validator.validateNotNegative(from, Validator.MESSAGE_IF_NEGATIVE);
        return mapOfVertexes.get(from);
    }
}