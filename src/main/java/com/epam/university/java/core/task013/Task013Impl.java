package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Task013Impl implements Task013 {

    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }


    @Override
    public boolean isConvexPolygon(Figure figure) {
        ArrayList<Vertex> list = new ArrayList<>(figure.getVertexes());
        LinkedList<Vertex> checkedVertices = new LinkedList<>();

        if (list.size() < 4) {
            return true;
        }

        Vertex begin = list.get(list.size() - 1);
        Vertex second = list.get(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {

            if (begin.getX() > list.get(i).getX()) {
                begin = list.get(i);
            }
            if (begin.getX() == list.get(i).getX()) {
                if (begin.getY() > list.get(i).getY()) {
                    begin = list.get(i);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getX() == begin.getX() && list.get(i).getY() == begin.getY()) {
                continue;
            }
            if (second.getX() > list.get(i).getX()) {
                second = list.get(i);
            }
        }

        checkedVertices.add(begin);
        checkedVertices.add(second);

        Vertex current = second;
        int d;

        for (int i = 1; i < list.size(); i++) {
            d = 0;
            Vertex a = checkedVertices.get(checkedVertices.size() - 1);
            Vertex b = checkedVertices.get(checkedVertices.size() - 2);
            Vertex c;
            for (Vertex vertex : list) {
                if (checkedVertices.contains(vertex)) {
                    continue;
                }
                c = vertex;
                int angle = (b.getX() - a.getX()) * (c.getY() - a.getY()) - (b.getY() - a.getY()) * (c.getX() - a.getX());
                if (angle >= d) {
                    d = angle;
                    current = c;
                }
            }
            if (!checkedVertices.contains(current)) {
                checkedVertices.add(current);
            }
        }


        return checkedVertices.size() == list.size();
    }
}
