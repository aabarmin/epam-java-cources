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
        vertexArray.sort((n, m) -> n.getX() - m.getY());
        List<Vertex> subList1 = vertexArray.subList(0, numberOfVertex / 2);
        List<Vertex> subList2 = vertexArray.subList(numberOfVertex / 2, numberOfVertex - 1);
        subList1.sort((n,m) -> {
            if (m.getX() == n.getX()) {
                return n.getY() - m.getY();
            } else {
                return m.getX() - n.getX();
            }
        });
        subList2.sort((n,m) -> {
            if (m.getX() == n.getX()) {
                return m.getY() - n.getY();
            } else {
                return m.getX() - n.getX();
            }
        });
        List<Vertex> result = new ArrayList<>(numberOfVertex);
        result.addAll(subList1);
        if (numberOfVertex % 2 != 0) {
            Vertex max = vertexArray.stream()
                    .max(Comparator.comparingInt(Vertex::getY))
                    .get();
            result.add(max);
        }
        result.addAll(subList2);
        vertexArray = result;
    }
}



