package com.epam.university.java.core.task015;

/**
 * Created by ilya on 17.09.17.
 */
class Vertex {

    private DoublePoint element;
    private Figure containingFigure;
    private Vertex link;

    public Vertex(DoublePoint element) {
        this.element = element;
    }

    public DoublePoint getElement() {
        return element;
    }

    public Figure getContainingFigure() {
        return containingFigure;
    }

    public void setContainingFigure(Figure containingFigure) {
        this.containingFigure = containingFigure;
    }

    public Vertex getLink() {
        return link;
    }

    public void setLink(Vertex link) {
        this.link = link;
    }

    public boolean hasContainigFigure() {
        return containingFigure != null;
    }

    public boolean hasLink() {
        return link != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vertex vertex = (Vertex) o;

        return element != null ? element.equals(vertex.element) : vertex.element == null;
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }
}
