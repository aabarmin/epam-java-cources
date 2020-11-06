package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class SquareImpl implements Square {
    private Point first;
    private Point second;
    private double edgeLength;
    private Point middle;



    private List<Point> vertexes;
    private List<Edge> edges;



    /**
     * Default square constructor.
     */
    public SquareImpl() {
    }


    /**
     * Square constructor.
     *
     * @param first  first point
     * @param second second point
     */
    public SquareImpl(Point first, Point second, double edgeLength) {
        this.first = first;
        this.second = second;
        this.edgeLength = edgeLength;
        vertexes = findVertexes(first, second);
        edges = findEdges(edgeLength);
    }

    private List<Point> findVertexes(Point first, Point second) {
        Point theLeftest = first;
        Point theRightest = second;


        if (theLeftest.getX() > theRightest.getX()) {
            Point tmp = theLeftest;
            theLeftest = theRightest;
            theRightest = tmp;
        } else if (theLeftest.getX() == second.getX()) {
            if (theRightest.getY() > theLeftest.getY()) {
                Point tmp = theLeftest;
                theLeftest = theRightest;
                theRightest = tmp;
            }
        }
        Point middle = new PointImpl();
        middle.setX((theLeftest.getX() + theRightest.getX()) / 2);
        middle.setY((theLeftest.getY() + theRightest.getY()) / 2);
        this.middle = middle;

        ArrayList<Point> vertexes = new ArrayList<>();

        vertexes.add(theLeftest);
        vertexes.add(theRightest);
        vertexes.add(findAdditionalVertex(middle, theLeftest));
        vertexes.add(findAdditionalVertex(middle, theRightest));

        return vertexes;
    }

    private List<Edge> findEdges(double edgeLength) {
        List<Edge> edges = new ArrayList<>();

        for (Point from : vertexes) {
            for (Point to : vertexes) {
                if (distanceBetweenVertices(from, to) == edgeLength) {
                    Edge newEdge = new Edge(from, to, edgeLength);
                    if (!edges.contains(newEdge)){
                        edges.add(newEdge);
                    }
                }
            }
        }

        return edges;
    }

    private Point findAdditionalVertex(Point baseVertex, Point rotateVertex) {

        final Point newPoint = new PointImpl();
        double modifiedXOfB = rotateVertex.getX() - baseVertex.getX();
        double modifiedYOfB = rotateVertex.getY() - baseVertex.getY();

        double newX;
        double newY;

        newX = modifiedXOfB * 0 - modifiedYOfB * 1;
        newY = modifiedXOfB * 1 + modifiedYOfB * 0;

        newX += baseVertex.getX();
        newY += baseVertex.getY();

        newPoint.setX(newX);
        newPoint.setY(newY);

        return newPoint;
    }

    private double distanceBetweenVertices(Point from, Point to) {
        double x1 = from.getX();
        double y1 = from.getY();
        double x2 = to.getX();
        double y2 = to.getY();
        return Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
    }

    @Override
    public Point getFirst() {
        return first;
    }

    @Override
    public void setFirst(Point first) {
        this.first = first;
    }

    @Override
    public Point getSecond() {
        return second;
    }

    @Override
    public void setSecond(Point second) {
        this.second = second;
    }

    public Point getMiddle() {
        return middle;
    }

    public void setMiddle(Point middle) {
        this.middle = middle;
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    public List<Point> getVertexes() {
        return vertexes;
    }

    public void setVertexes(List<Point> vertexes) {
        this.vertexes = vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }


}
