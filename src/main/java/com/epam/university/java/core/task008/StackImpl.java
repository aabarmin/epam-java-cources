package com.epam.university.java.core.task008;

public class StackImpl<T> implements Stack<T> {

    private int size;
    private Holder<T> holder;

    /**
     * Push new element on top of the stack.
     *
     * @param element new element for stack to hold
     */
    @Override
    public void push(T element) {
        holder = new Holder<>(element, holder);
        size++;
    }

    /**
     * Get element from top of the stack.
     *
     * @return if where is no elements, return null
     */
    @Override
    public T pop() {

        if (holder == null) {
            return null;
        }

        T element = holder.getValue();
        holder = holder.getPrevious();
        size--;

        return element;

    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return size;
    }

    private class Holder<T> {

        private final T value;
        private final Holder<T> previous;

        public Holder(T value, Holder<T> previous) {
            this.value = value;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public Holder<T> getPrevious() {
            return previous;
        }

    }

}
