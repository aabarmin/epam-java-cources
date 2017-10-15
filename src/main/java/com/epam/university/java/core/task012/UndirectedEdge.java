package com.epam.university.java.core.task012;

/**
 * Created by Александр on 15.10.2017.
 * Edge of undirected graph
 */
public class UndirectedEdge {
    private final Integer from;
    private final Integer to;

    /**
     * Constructor with 2 vertices.
     * @param from first vertex
     * @param to second vertex
     */
    public UndirectedEdge(Integer from, Integer to) {
        this.from = Math.min(from, to);
        this.to = Math.max(from, to);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UndirectedEdge that = (UndirectedEdge) o;

        if (from != null ? !from.equals(that.from) : that.from != null) {
            return false;
        }
        return to != null ? to.equals(that.to) : that.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }

    public Integer getFrom() {
        return from;
    }

    public Integer getTo() {
        return to;
    }
}
