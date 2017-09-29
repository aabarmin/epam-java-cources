package com.epam.university.java.core.task015;

import java.util.List;

public class Polygon {

    private List<Point> vertices;

    public Polygon(List<Point> vertices) {
        this.vertices = vertices;
    }

    /**
     * Get all vertices of polygon.
     * @return collection of vertices
     */
    public List<Point> getVertices() {
        return vertices;
    }

    /**
     * Calculate area of polygon, using coordinates of its vertices.
     * @return area of polygon
     */
    public double area() {
        double result = 0;
        int n = this.getVertices().size();
        int k;
        for (int i = 0; i < n; i++) {
            k = i + 1 < n ? i + 1 : 0;
            result += this.vertices.get(i).getX() * this.vertices.get(k).getY()
                    - this.vertices.get(i).getY() * this.vertices.get(k).getX();
        }
        result /= 2;
        return result;
    }
}
