package com.epam.university.java.project.core.cdi.structure;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by ilya on 26.09.17.
 */
public class CollectionAdapter<T> extends AbstractList<T> {

    Collection<T> collection;

    public CollectionAdapter(Collection<T> collection) {
        this.collection = collection;
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public T get(int i) {
        final Iterator<T> iterator = collection.iterator();
        int counter = 0;
        while(iterator.hasNext()){
            final T t = iterator.next();
            if(counter == i){
                return t;
            }
            counter++;
        }

        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return super.listIterator();
    }

    @Override
    public boolean add(T t) {
        if(t == null){
            return  false;
        }
        return collection.add(t);
    }
}
