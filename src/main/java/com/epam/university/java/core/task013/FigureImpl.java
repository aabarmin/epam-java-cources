package com.epam.university.java.core.task013;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class FigureImpl implements Figure {

    private final int numberOfVertex;
    private int currentVertexNumber = 0;
    private List<Vertex> vertexArray;

    public FigureImpl(int numberOfVertex) {
        this.numberOfVertex = numberOfVertex;
        this.vertexArray = new ArrayList<>(numberOfVertex);
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (currentVertexNumber == numberOfVertex) {
            System.out.println("Can't add vertex");
            return;
        }
        vertexArray.add(vertex);
        currentVertexNumber++;
        if (currentVertexNumber == numberOfVertex) {
            order();
        }
    }

    @Override
    public Collection<Vertex> getVertexes() {
        return this.vertexArray;
    }

    /*
     * Method that sets vertices in appropriate order,
     * clockwise about (0,0) coordinate
     */
    private void order() {
        double averageX = vertexArray.stream().mapToDouble(Vertex::getX).sum() / vertexArray.size();
        double averageY = vertexArray.stream().mapToDouble(Vertex::getY).sum() / vertexArray.size();
        vertexArray.sort(Comparator.comparingDouble(
            p -> Math.atan2(p.getY() - averageY, p.getX() - averageX)
        ));
    }
}



