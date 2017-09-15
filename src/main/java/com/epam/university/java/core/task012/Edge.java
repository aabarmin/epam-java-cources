package com.epam.university.java.core.task012;

/**
 * Created by ilya on 14.09.17.
 */
public class Edge<T> {

    private final T pointOne;
    private final T pointTwo;

    public Edge(T pointOne, T pointTwo) {
        this.pointOne = pointOne;
        this.pointTwo = pointTwo;
    }

    public T getPointOne() {
        return pointOne;
    }

    public T getPointTwo() {
        return pointTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Edge<?> edge = (Edge<?>) o;

        if (!(pointOne.equals(edge.pointOne)||pointOne.equals(edge.pointTwo))) {
            return false;
        }
        return pointTwo.equals(edge.pointTwo)||pointTwo.equals(edge.pointOne);
    }

    @Override
    public int hashCode() {
        int result = pointOne.hashCode();
        result = result + pointTwo.hashCode();
        return result;
    }
}
