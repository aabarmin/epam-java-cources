package com.epam.university.java.core.task015;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ilya on 21.09.17.
 */
public class RoundInterator<T> implements Iterator<T> {

    private List<T> list;
    private int position = 0;

    public RoundInterator(List<T> list) {
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

    /**
     * Return previouse element.
     *
     * @return previouse element
     */
    public T previous() {
        T element = list.get(position);
        position--;
        checkPosition();
        return element;
    }

    /**
     * Set start position of Iterator.
     *
     * @param i position to set
     */
    public void setStart(int i) {
        if (i < list.size()) {
            position = i;
        } else {
            throw new IllegalArgumentException("incorrect position");
        }
    }

    /**
     * Set start element if it present in List.
     *
     * @param element element to start
     */
    public void setStart(T element) {
        if (list.contains(element)) {
            position = list.indexOf(element);
        }
    }

    private void checkPosition() {
        if (position == list.size()) {
            position = 0;
        } else if (position < 0) {
            position = list.size() - 1;
        }
    }
}
