package com.epam.university.java.core.task015;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * Created by ilya on 17.09.17.
 */
public class WeilerAthertonAlgorithm {

    private Figure first;
    private Figure second;
    private List<Vertex> intersection;
    private List<Vertex> union;


    public WeilerAthertonAlgorithm(Figure first, Figure second) {
        this.first = first;
        this.second = second;
        containsInFigure(first, second);
        containsInFigure(second, first);
    }

    public Figure getIntersection() throws IllegalArgumentException {
        start();
        Figure figure = new Figure(intersection.stream().map(p -> p.getElement()).collect(Collectors.toList()));
        return figure;
    }

    private void containsInFigure(Figure first, Figure second) {
        first.getVertex().stream().forEach(p -> {
            if (second.includes(p.getElement())) {
                p.setContainingFigure(second);
            }
        });
    }

    /**
     * Check first contains second or second contains first or doesn't intersect.
     *
     * @return -1 - doesn't intersect, 0 - intersect, 1 - one of them contains other
     */
    private int containsAll() {
        List<Vertex> checkFirst = first.getVertex().stream().filter(p -> p.hasContainigFigure())
            .collect(Collectors.toList());
        if (checkFirst.size() == first.getVertex().size()) {
            intersection = first.getVertex();
            union = second.getVertex();
            return 1;
        } else if (checkFirst.size() == 0) {
            List<Vertex> checkSecond = second.getVertex().stream()
                .filter(p -> p.hasContainigFigure())
                .collect(Collectors.toList());
            if (checkSecond.size() == second.getVertex().size()) {
                intersection = second.getVertex();
                union = first.getVertex();
                return 1;
            } else if (checkSecond.size() == 0) {
                return -1;
            }
        }
        return 0;
    }

    private void start() throws IllegalArgumentException {
        if (containsAll() == -1) {
            throw new IllegalArgumentException("Doesn't intersect");
        } else if (containsAll() == 1) {
            return;
        }
        List<Vertex> fig = findIntersections(first, second);
        first = new Figure(fig.stream().map(p -> p.getElement()).collect(Collectors.toList()));
        fig = findIntersections(second, first);
        second = new Figure(fig.stream().map(p -> p.getElement()).collect(Collectors.toList()));
        findIntersectionFigure(first);
        findIntersectionFigure(second);
    }

    private List<Vertex> findIntersections(Figure firstFigure, Figure secondFigure) {
        ListIterator<Vertex> firstIterator = firstFigure.getVertex().listIterator();
        List<Vertex> figureVertexes = new LinkedList<>();

        Vertex last = firstIterator.next();
        Vertex firstPoint = last;
        figureVertexes.add(firstPoint);
        do {
            if (firstIterator.hasNext()) {
                Vertex current = firstIterator.next();
                if (current.hasContainigFigure()) {
                    firstIterator.previous();
                    Vertex previous = firstIterator.previous();
                    if (!previous.hasContainigFigure()) {
                        addVertexes(firstFigure, secondFigure, figureVertexes, current, previous);
                    }
                    firstIterator.next();
                    firstIterator.next();
                }
                last = current;
                figureVertexes.add(current);
            } else {
                if (firstPoint.hasContainigFigure()) {
                    if (!last.hasContainigFigure()) {
                        addVertexes(firstFigure, secondFigure, figureVertexes, firstPoint, last);
                    }
                }
                break;
            }
        } while (true);
        return figureVertexes;
    }

    private void addVertexes(Figure firstFigure, Figure secondFigure, List<Vertex> figureVertexes,
        Vertex current, Vertex previous) {
        DoublePoint point = getIntersectionPoint(current, previous, secondFigure);
        if (!firstFigure.getPoints().contains(point)) {
            Vertex vertex = new Vertex(point);
            vertex.setContainingFigure(secondFigure);
            if (secondFigure.getPoints().contains(point)) {
                Vertex link = secondFigure.getVertex().stream()
                    .filter(p -> p.getElement().equals(point)).findFirst().get();
                vertex.setLink(link);
                link.setLink(vertex);
            }
            figureVertexes.add(vertex);
        }
    }


    private DoublePoint getIntersectionPoint(Vertex first, Vertex second, Figure figure) {
        LineSegment line = new LineSegment(first.getElement(), second.getElement());
        LineSegment intersected = figure.getLineSegments().stream().filter(l -> {
            DoublePoint p = l.lineIntersection(line);
            return l.includes(p);
        }).findFirst().get();

        return intersected.lineIntersection(line);
    }

    private void findIntersectionFigure(Figure figure) {
        ListIterator<Vertex> iterator = figure.getVertex().listIterator();

        outer:
        while (iterator.hasNext()) {
            Vertex current = iterator.next();
            if (current.hasLink()) {
                intersection.add(current);
                if (iterator.next().hasContainigFigure()) {
                    iterator.previous();
                    while (iterator.hasNext()) {
                        Vertex addable = iterator.next();
                        intersection.add(addable);
                        if (addable.hasLink()) {
                            break outer;
                        }
                    }
                } else if (iterator.previous().hasContainigFigure()) {
                    iterator.next();
                    while (iterator.hasPrevious()) {
                        Vertex addable = iterator.previous();
                        intersection.add(addable);
                        if (addable.hasLink()) {
                            break outer;
                        }
                        if (!iterator.hasPrevious()) {
                            while (iterator.hasNext()) {
                                Vertex next = iterator.next();
                                if (next.hasLink() && next != current) {
                                    int i = 0;
                                    intersection.add(i++, next);
                                    while (iterator.hasNext()) {
                                        Vertex other = iterator.next();
                                        intersection.add(i++, other);
                                    }
                                    break outer;
                                }
                            }
                        }
                    }
                }
            }
        }
    }



}
