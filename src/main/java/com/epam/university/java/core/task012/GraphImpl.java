package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Implementation class for Graph.
 *
 * @author Sergei Titov
 */
public class GraphImpl implements Graph {

    /////////////////////////////////////////////////////
    // Graph vertex class
    private class Node implements Comparable<Node> {

        private final int id;
        private Set<Integer> adjacent;

        protected Node(int id) {
            this.id = id;
            adjacent = new TreeSet<>();
        }

        public final int getId() {
            return id;
        }

        private void addAdjacent(Node value) {
            adjacent.add(value.id);
        }

        private void removeAdjacent(int value) {
            for (Integer adj : adjacent) {
                if (adj == value) {
                    adjacent.remove(adj);
                    break;
                }
            }
        }

        protected boolean edgeExists(int to) {
            for (Integer adj : adjacent) {
                if (adj == to) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Node o) {
            if (this.id > o.id) {
                return 1;
            }
            if (this.id < o.id) {
                return -1;
            }
            return 0;
        }
    }  ///////////////////////////////////////////////////


    private Map<Integer, Node> nodes = new HashMap<>();

    private final Node getNode(int id) {
        if (!nodes.containsKey(id)) {
            Node node = new Node(id);
            nodes.put(id, node);
            return node;
        } else {
            return nodes.get(id);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void createEdge(int from, int to) {

        getNode(from).addAdjacent(getNode(to));
        getNode(to).addAdjacent(getNode(from)); // two-way graph
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean edgeExists(int from, int to) {
        return getNode(from).edgeExists(to);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEdge(int from, int to) {
        getNode(from).removeAdjacent(to);
        getNode(to).removeAdjacent(from); // two-way graph
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Integer> getAdjacent(int from) {
        return getNode(from).adjacent;
    }
}
