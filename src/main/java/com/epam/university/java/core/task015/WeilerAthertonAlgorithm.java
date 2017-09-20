package com.epam.university.java.core.task015;

import com.epam.university.java.core.task015.RoundList.RoundInterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by ilya on 17.09.17.
 */
public class WeilerAthertonAlgorithm {

    private Figure first;
    private Figure second;
    private List<Vertex> intersection;

    public WeilerAthertonAlgorithm(Figure first, Figure second) {
        this.first = first;
        this.second = second;
        containsInFigure(first, second);
        containsInFigure(second, first);
    }

    public Figure getIntersection() throws IllegalArgumentException {
        try {
            start();
        }catch (IllegalArgumentException e){
            return null;
        }
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
        if (containsAll() == -1) {
            throw new IllegalArgumentException("Doesn't intersect");
        } else if (containsAll() == 1) {
            return;
        }
        List<Vertex> fig = findIntersections(first, second);
        first = new Figure(fig.stream().map(p -> p.getElement()).collect(Collectors.toList()));
        fig = findIntersections(second, first);
        second = new Figure(fig.stream().map(p -> p.getElement()).collect(Collectors.toList()));
        containsInFigure(first, second);
        containsInFigure(second, first);
        findLinks();
        findIntersectionFigure();

    }

    private List<Vertex> findIntersections(Figure firstFigure, Figure secondFigure) {
        RoundList<LineSegment> first = new RoundList<>(firstFigure.getLineSegments());
        RoundList<LineSegment> second = new RoundList<>(secondFigure.getLineSegments());

        RoundInterator<LineSegment> firstIter = first.getIterator();
        RoundInterator<LineSegment> secondIter = second.getIterator();

        List<Vertex> figureFirst = new LinkedList<>();

        LineSegment current = firstIter.next();
        LineSegment currentHead = current;
        figureFirst.add(new Vertex(current.getFirst()));

        while(true){
            LineSegment currentSecond = secondIter.next();
            LineSegment head = currentSecond;

            while(true){
                Point intersect = current.lineIntersection(currentSecond);
                if(intersect != null){
                    Vertex intersectVertex = new Vertex(intersect);
                    figureFirst.add(intersectVertex);
                }
                currentSecond = secondIter.next();
                if(currentSecond.equals(head)){
                    break;
                }
            }
            current = firstIter.next();
            if(current.getFirst() == currentHead.getFirst()){
                break;
            }
            figureFirst.add(new Vertex(current.getFirst()));

        }

        return figureFirst;
    }

    private void findLinks(){
        List<Vertex> secondVertexes = second.getVertex();
        first.getVertex().forEach(e -> {
            if(secondVertexes.contains(e)){
                Vertex vertex = secondVertexes.get(secondVertexes.indexOf(e));
                e.setLink(vertex);
                vertex.setLink(e);
            }
        });
    }

    private void findIntersectionFigure() {
        RoundList<Vertex> firstRound = new RoundList<>(first.getVertex());
        RoundList<Vertex> secondRound = new RoundList<>(second.getVertex());

        RoundInterator<Vertex> firstIter = firstRound.getIterator();
        RoundInterator<Vertex> secondIter = secondRound.getIterator();

        Vertex current = firstIter.next();

        while(true){
            if(current.hasLink()){
                break;
            }
            current = firstIter.next();
        }

        intersection.add(current);
        Vertex head = current;

        RoundInterator<Vertex> iter = firstIter;

        Function<RoundInterator<Vertex>, Vertex> function = (itera) -> (itera.next());
        String flag = "next";

        while (true){
            current = function.apply(iter);
            if(current == head){
                break;
            }
           if(current.hasLink()){
                intersection.add(current);
                if(iter == firstIter){
                    iter = secondIter;
                }else{
                    iter = firstIter;
                }
            }else if(current.hasContainigFigure()){
                intersection.add(current);
            }else if(!current.hasContainigFigure()){
                if("next".equals(flag)){
                    function = (itera) -> (itera.previous());
                    flag = "previouse";
                }else{
                    function = (itera) -> (itera.next());
                }
                function.apply(iter);
            }

        }
    }



}
