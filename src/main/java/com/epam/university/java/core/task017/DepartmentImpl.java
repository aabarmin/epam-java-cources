package com.epam.university.java.core.task017;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Department model.
 */
public class DepartmentImpl implements Department {

    private String name;
    private int employeeCount;
    private final List<Department> children;

    public DepartmentImpl() {
        children = new LinkedList<>();
    }

    /**
     * Get name of department.
     * @return department name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name of department.
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
     * Get count of employees in department.
     * @return value
     */
    @Override
    public int getEmployeeCount() {
        return employeeCount;
    }

    /**
     * Set count of employees in department.
     * @param employeeCount value
     */
    @Override
    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
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
