package com.epam.university.java.core.task029;

/**
 * Pair of immutable objects.
 * @param <V> first variable
 * @param <T> second variable
 */
public class Pair<V, T> {
    private final V first;
    private final T second;

    /**
     * Constructor.
     */
    public Pair(V first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get first immutable object.
     * @return first
     */
    public V getFirst() {
        return first;
    }

    /**
     * Get srcond immutable object.
     * @return second
     */
    public T getSecond() {
        return second;
    }
}
