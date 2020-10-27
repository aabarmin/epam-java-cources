package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {

        if (figure == null) {
            throw new IllegalArgumentException();
        }

        ArrayList<Vertex> list = new ArrayList<>(figure.getVertexes());

        final LinkedList<Vertex> checkedVertices = new LinkedList<>();

        if (list.size() <= 4) {
            return true;
        }

        Vertex theLeftest = list.get(0);

        for (Vertex vertex : list) {
            if (vertex.getX() < theLeftest.getX()) {
                theLeftest = vertex;
            } else if (vertex.getX() == theLeftest.getX()) {
                if (vertex.getY() < theLeftest.getY()) {
                    theLeftest = vertex;
                }
            }
        }
        checkedVertices.add(theLeftest);


        Vertex secondVertex = list.get(0);
        if (secondVertex.equals(theLeftest)) {
            secondVertex = list.get(1);
        }
        for (Vertex vertex : list) {
            if (vertex.getX() < secondVertex.getX() && !vertex.equals(theLeftest)) {
                secondVertex = vertex;
            } else if (vertex.getX() == secondVertex.getX()) {
                if (vertex.getY() < secondVertex.getY() && !vertex.equals(theLeftest)) {
                    secondVertex = vertex;
                }
            }
        }

        checkedVertices.add(secondVertex);


        Vertex prevVertex;
        Vertex currentVertex;

        double tang = -100;

        for (int i = 2; i < list.size(); i++) {
            prevVertex = checkedVertices.get(checkedVertices.size() - 2);
            currentVertex = checkedVertices.get(checkedVertices.size() - 1);
            Vertex nextVertex = null;
            double modifiedXOfPrev;
            double modifiedYOfPrev;
            double modifiedXOfNext;
            double modifiedYOfNext;

            modifiedXOfPrev = prevVertex.getX() - currentVertex.getX();
            modifiedYOfPrev = prevVertex.getY() - currentVertex.getY();

            for (Vertex vertex : list) {
                if (checkedVertices.contains(vertex)) {
                    continue;
                }
                modifiedXOfNext = vertex.getX() - currentVertex.getX();
                modifiedYOfNext = vertex.getY() - currentVertex.getY();

                double scMul = modifiedXOfPrev * modifiedXOfNext
                        + modifiedYOfPrev * modifiedYOfNext;
                double moduloOfPrev = Math.sqrt(Math.pow(modifiedXOfPrev, 2)
                        + Math.pow(modifiedYOfPrev, 2));
                double moduloOfNext = Math.sqrt(Math.pow(modifiedXOfNext, 2)
                        + Math.pow(modifiedYOfNext, 2));
                double curCos = scMul / (moduloOfPrev * moduloOfNext);
                double curSin = Math.sqrt(1 - Math.pow(curCos, 2));
                double curTang = curSin / curCos;

                if (list.size() - checkedVertices.size() == 1
                        && curTang > 0
                        && 1 - curTang > 0.0000001) {
                    return false;
                }
                if (curTang < -0.0 && curTang > tang) {
                    tang = curTang;
                    nextVertex = vertex;
                } else if (curTang == -0.0 || Double.isNaN(curTang)) {
                    tang = curTang;
                    nextVertex = vertex;
                    break;
                } else if (curTang == Double.POSITIVE_INFINITY && tang < -60) {
                    tang = -65;
                    nextVertex = vertex;
                } else if (1 - curTang < 0.0000001 && tang < -70) {
                    if (nextVertex != null) {
                        double fromPrevToNext =
                                Math.sqrt(Math.pow((nextVertex.getX() - prevVertex.getX()), 2)
                                + Math.pow(nextVertex.getY() - prevVertex.getY(), 2));
                        double fromCurrentToPrev =
                                Math.sqrt(Math.pow((vertex.getX() - prevVertex.getX()), 2)
                                + Math.pow(vertex.getY() - prevVertex.getY(), 2));
                        if (fromCurrentToPrev < fromPrevToNext) {
                            tang = -100;
                            nextVertex = vertex;
                        }
                    } else {
                        nextVertex = vertex;
                    }

                }
            }
            if (nextVertex != null) {
                checkedVertices.add(nextVertex);

            }

            if (tang >= 0.0 && tang != 1  && tang != -0.0) {
                return false;
            }
            tang = -100;
        }


        return checkedVertices.size() == list.size();
    }
}
