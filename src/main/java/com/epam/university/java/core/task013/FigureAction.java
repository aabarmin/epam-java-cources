package com.epam.university.java.core.task013;

@FunctionalInterface
public interface FigureAction {
    /**
     * Invoke action with figure instance.
     * @param figure figure instance
     */
    void run(Figure figure);
}
