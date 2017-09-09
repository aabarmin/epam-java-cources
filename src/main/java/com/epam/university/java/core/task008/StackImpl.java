package com.epam.university.java.core.task008;

public class StackImpl<T> implements Stack<T> {

    Holder<T> holder;

    /**
     * Push new element on top of the stack
     *
     * @param element
     */
    @Override
    public void push(T element) {
        holder = new Holder<>(element, holder);
    }

    /**
     * Get element from top of the stack
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

        return element;

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
