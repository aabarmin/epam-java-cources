package com.epam.university.java.core.task017;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Organization model.
 */
public class OrganizationImpl implements Organization {

    private String name;
    private List<Department> children;

    public OrganizationImpl() {
        children = new LinkedList<>();
    }

    /**
     * Get name of organization.
     * @return organization name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name of organization.
     * @param name new name
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Visit current node with visitor.
     * @param visitor visitor instance
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Get collection of child instances.
     * @return collection of children
     */
    @Override
    public Collection<Department> getChildren() {
        return Collections.unmodifiableList(children);
    }

    /**
     * Add instance as child.
     * @param child instance to add
     */
    @Override
    public void addChild(Department child) {
        children.add(child);
    }

}
