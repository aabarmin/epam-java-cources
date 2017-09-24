package com.epam.university.java.core.task012;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Вера on 17.09.2017.
 */
public class Task012Impl implements Task012 {
    @SuppressWarnings("unchecked")
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        // Graph graph = sourceGraph;

        for (GraphAction g : actions) {
            g.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        // поиск в глубину
        // формирую стек для запоминания ещё не отработанных вершин
        Stack stack = new Stack();
        // множество - для запоминания уже отработанных вершин
        Set<Integer> setFinish = new HashSet<>();

        stack.push(from);

        Integer firstElement = (Integer)stack.pop();
        if (firstElement == to) {
            return true;
        }

        // от каждой вершины в стек добавляю множество смежных вершин
        Collection<Integer> toAddInStack = graph.getAdjacent(from);
        for (Integer i : toAddInStack) {
            stack.push(i);
        }

        while (!(stack.empty())) {
            // проверяю совпадает ли очередной элемент из стека с искомой вершиной
            Integer elementToCheck = (Integer)stack.pop();
            if (elementToCheck == to) {
                return true;
            }

            // проверяем есть ли этот элемент в отработанном множестве вершин
            // если его там нет, отрабатываем его (т.е. помещаем в стек множество смежных вершин)
            // и записывает исходный элемент во множество отработанных вершин
            if (!(setFinish.contains(elementToCheck))) {
                Collection<Integer> elementToAddInStack = graph.getAdjacent(elementToCheck);
                for (Integer i : elementToAddInStack) {
                    stack.push(i);
                }
            }

            setFinish.add(elementToCheck);
        }

        return false;
    }
}
