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
        /*if (currentVertexNumber == numberOfVertex) {
            System.out.println("Can't add vertex");
            return;
        }*/
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
        List<Vertex> buffer = new ArrayList<>(vertexArray);
        buffer.sort(Comparator.comparingInt(Vertex::getX));
        Vertex max = null;
        if (numberOfVertex % 2 != 0) {
            max = vertexArray.stream()
                    .max(Comparator.comparingInt(Vertex::getY))
                    .get();
            buffer.remove(max);
        }

        List<Vertex> subList1 = buffer.subList(0, numberOfVertex / 2);
        subList1.sort((n,m) -> {
            if (m.getX() == n.getX()) {
                return n.getY() - m.getY();
            } else {
                return m.getX() - n.getX();
            }
        });

        List<Vertex> result = new ArrayList<>(numberOfVertex);
        List<Vertex> subList2;
        result.addAll(subList1);
        if (numberOfVertex % 2 != 0) {
            result.add(max);
            subList2 = buffer.subList(numberOfVertex / 2, numberOfVertex - 1);
        } else {
            subList2 = buffer.subList(numberOfVertex / 2, numberOfVertex);
        }

        subList2.sort((n,m) -> {
            if (m.getX() == n.getX()) {
                return m.getY() - n.getY();
            } else {
                return m.getX() - n.getX();
            }
        });

        result.addAll(subList2);
        vertexArray = result;
    }
}



