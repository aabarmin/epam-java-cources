package com.epam.university.java.core.task017;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Александр on 19.09.2017.
 */
public class ContainerImpl implements Container {
    List<Object> childs = new ArrayList<>();

    /**
     * Get collection of child instances.
     *
     * @return collection of children
     */
    @Override
    public Collection getChildren() {
        return childs;
    }

    /**
     * Add instance as child.
     *
     * @param child instance to add
     */
    @Override
    public void addChild(Object child) {
        childs.add(child);
    }
}
