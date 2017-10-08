package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ilya on 17.09.17.
 */
public class WeilerAthertonAlgorithm {

    private Figure first;
    private Figure second;
    private List<Vertex> firstList;
    private List<Vertex> secondList;
    private List<Vertex> intersection;

    /**
     * Weiler-Atherton algorithm Constructor.
     *
     * @param first first convex polygon
     * @param second second convex polygon
     */
    public WeilerAthertonAlgorithm(Figure first, Figure second) {
        this.first = first;
        this.second = second;
        firstList = first.getVertex();
        secondList = second.getVertex();
        containsInFigure(first, second);
        containsInFigure(second, first);
    }

    /**
     * Return intersection figure.
     *
     * @return intersection figure
     * @throws IllegalArgumentException if figures doesn't intersect
     */
    public Figure getIntersection() throws IllegalArgumentException {
        start();
        if (intersection.size() != 0) {
            Figure figure = new Figure(
                intersection.stream().map(p -> p.getElement()).collect(Collectors.toList()));
            return figure;
        }
        return null;
    }

    private void containsInFigure(Figure firstF, Figure secondF) {
        firstF.getVertex().stream().forEach(p -> {
            if (secondF.includes(p.getElement()) || secondF.getVertex().contains(p)) {
                p.setContainingFigure(secondF);
            }
        });
    }

    /**
     * Check first contains second or second contains first or doesn't intersect.
     *
     * @return -1 - may be doesn't intersect, 0 - intersect, 1 - one of them contains other
     */
    private int containsAll() {
        List<Vertex> checkFirst = first.getVertex().stream().filter(p -> p.hasContainigFigure())
            .collect(Collectors.toList());
        if (checkFirst.size() == first.getVertex().size()) {
            intersection = first.getVertex();
            return 1;
        } else if (checkFirst.size() == 0) {
            List<Vertex> checkSecond = second.getVertex().stream()
                .filter(p -> p.hasContainigFigure())
                .collect(Collectors.toList());
            if (checkSecond.size() == second.getVertex().size()) {
                intersection = second.getVertex();
                return 1;
            } else if (checkSecond.size() == 0) {
                return -1;
            }
        }
        return 0;
    }

    private void start() throws IllegalArgumentException {
        if (containsAll() == 1) {
            return;
        }
        List<Vertex> figF = findIntersections(first, second);
        List<Vertex> figS = findIntersections(second, first);
        if (figF.size() == first.getVertex().size() && figS.size() == second.getVertex().size()) {
            intersection = new ArrayList<>();
            return;
        }
        Figure firstF = new Figure(figF.stream()
            .map(p -> p.getElement())
            .collect(Collectors.toList())
        );
        Figure secondF = new Figure(figS.stream()
            .map(p -> p.getElement())
            .collect(Collectors.toList())
        );
        containsInFigure(firstF, second);
        containsInFigure(secondF, first);
        findLinks(firstF, secondF);
        first = firstF;
        second = secondF;
        findIntersectionFigure();

    }

    private List<Vertex> findIntersections(Figure firstFigure, Figure secondFigure) {

        Iterator<LineSegment> firstIter = firstFigure.getLineSegments().iterator();
        List<Vertex> resultFigure = new LinkedList<>();

        while (firstIter.hasNext()) {
            LineSegment current = firstIter.next();
            Vertex vertex = new Vertex(current.getFirst());
            if (!resultFigure.contains(vertex)) {
                resultFigure.add(vertex);
            }
            Iterator<LineSegment> secondIter = secondFigure.getLineSegments().iterator();
            while (secondIter.hasNext()) {
                LineSegment currentSecond = secondIter.next();
                Point intersect = current.lineIntersection(currentSecond);
                if (intersect != null) {
                    Vertex intersectVertex = new Vertex(intersect);
                    if (!resultFigure.contains(intersectVertex)) {
                        resultFigure.add(intersectVertex);
                    }
                }
            }
        }

        return resultFigure;
    }

    private void findLinks(Figure firstF, Figure secondF) {
        List<Vertex> secondVertexes = secondF.getVertex();
        firstF.getVertex().forEach(e -> {
            if (secondVertexes.contains(e)) {
                Vertex vertex = secondVertexes.get(secondVertexes.indexOf(e));
                e.setLink(vertex);
                vertex.setLink(e);
            }
        });
    }

    private void findIntersectionFigure() {
        intersection = new LinkedList<>();

        RoundInterator<Vertex> firstIter = new RoundInterator<>(first.getVertex());
        RoundInterator<Vertex> secondIter = new RoundInterator<>(second.getVertex());

        Vertex current = firstIter.next();

        while (true) {
            if (current.hasLink()) {
                break;
            }
            current = firstIter.next();
        }

        intersection.add(current);
        Vertex head = current;

        RoundInterator<Vertex> iter = firstIter;

        Function<RoundInterator<Vertex>, Vertex> function = (itera) -> (itera.next());
        String flag = "next";

        while (true) {
            current = function.apply(iter);
            if (current.equals(head)) {
                break;
            }
            if (current.hasLink()) {
                intersection.add(current);
                if (iter == firstIter) {
                    iter = secondIter;
                } else {
                    iter = firstIter;
                }
                iter.setStart(current);
                function.apply(iter);
            } else if (current.hasContainigFigure()) {
                intersection.add(current);
            } else if (!current.hasContainigFigure()) {
                if ("next".equals(flag)) {
                    function = (itera) -> (itera.previous());
                    flag = "previouse";
                } else {
                    function = (itera) -> (itera.next());
                    flag = "next";
                }
                function.apply(iter);
                function.apply(iter);
                function.apply(iter);
            }

        }
    }


}
