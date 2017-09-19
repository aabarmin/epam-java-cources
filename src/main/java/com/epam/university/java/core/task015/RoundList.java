package com.epam.university.java.core.task015;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ilya on 17.09.17.
 */
public class RoundList<T> {

    private ArrayList<T> elements = new ArrayList<>();


    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public boolean contains(Object o) {
        return elements.contains(o);
    }

    public void add(T t) {
        elements.add(t);
    }

    public boolean remove(Object o) {
        return elements.remove(o);
    }

    public boolean addAll(Collection<? extends T> collection) {
        return elements.addAll(collection);
    }

    public T get(int i) {
        return elements.get(i);
    }

    public void add(int i, T t) {
        elements.add(i, t);
    }

    public RoundInterator<T> getIterator() {
        return new RoundInterator<>(elements);
    }

    public class RoundInterator<T> implements Iterator<T> {

        private ArrayList<T> list;
        private int position;

        public RoundInterator(ArrayList<T> list) {
            this.list = list;
            position = 0;
        }

        @Override
        public boolean hasNext() {
            return true; // everytime has next
        }

        @Override
        public T next() {
            T element = list.get(position);
            position++;
            checkPosition();
            return element;
        }

        public T previous() {
            T element = list.get(position);
            position--;
            checkPosition();
            return element;
        }

        private void checkPosition() {
            if (position == list.size()) {
                position = 0;
            } else if (position < 0) {
                position = list.size() - 1;
            }
        }

        private void setStart(int i) {
            if (i < list.size()) {
                position = i;
            } else {
                throw new IllegalArgumentException("incorrect position");
            }
        }

        private void setStart(T element) {
            if (list.contains(element)) {
                position = list.indexOf(element);
            }
        }


    }

}
