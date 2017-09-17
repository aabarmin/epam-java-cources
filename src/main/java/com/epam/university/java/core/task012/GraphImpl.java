package com.epam.university.java.core.task012;

import com.epam.university.java.core.task013.Vertex;

import java.util.ArrayList;
import java.util.Collection;

public class GraphImpl implements Graph {
    public class Vertex {
        private int number;
        private ArrayList<Integer> neighbours;

        public Vertex(int number) {
            this.number = number;
            this.neighbours = new ArrayList<Integer>();
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public ArrayList<Integer> getNeighbours() {
            ArrayList<Integer> result = new ArrayList<Integer>(neighbours);
            return result;
        }

        public void addNeighbour(Integer neighbour) {
            neighbours.add(neighbour);
        }

        /**
         * removes neighbour with number <code>number</code>.
         * @param number number of vertex
         */
        public void removeNeighbour(int number) {
            for (int i = 0; i < neighbours.size(); i++) {
                if (neighbours.get(i) == number) {
                    neighbours.remove(neighbours.get(i));
                    break;
                }
            }
        }
    }

    private ArrayList<Vertex> vertexes = new ArrayList<>();

    public GraphImpl() {
        this.vertexes = new ArrayList<Vertex>();
    }

    public ArrayList<Vertex> getVertexes() {
        return vertexes;
    }

    public void setVertexes(ArrayList<Vertex> vertexes) {
        this.vertexes = vertexes;
    }

    public void addVertex(Vertex vertex) {
        vertexes.add(vertex);
    }

    @Override
    public void createEdge(int from, int to) {
        for (Vertex vertex : vertexes) {
            if (vertex.getNumber() == from) {
                vertex.addNeighbour(to);
            }
            if (vertex.getNumber() == to) {
                vertex.addNeighbour(from);
            }
        }
    }

    @Override
    public boolean edgeExists(int from, int to) {
        for (Vertex vertex : vertexes) {
            if (vertex.getNumber() == from) {
                for (Integer neighbour : vertex.getNeighbours()) {
                    if (neighbour == to) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    @Override
    public void removeEdge(int from, int to) {
        for (Vertex vertex : vertexes) {
            if (vertex.getNumber() == from) {
                vertex.removeNeighbour(to);
            }
            if (vertex.getNumber() == to) {
                vertex.removeNeighbour(from);
            }
        }
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        for (Vertex vertex : vertexes) {
            if (vertex.getNumber() == from) {
                return vertex.getNeighbours();
            }
        }
        return new ArrayList<Integer>();
    }
}
