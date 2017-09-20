package com.epam.university.java.core.task017;

import java.util.Collection;

/**
 * Created by Александр on 19.09.2017.
 */
public class DepartmentImpl implements Department {
    private String name;
    /**
     * Get name of instance.
     *
     * @return value
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set name of instance.
     *
     * @param name value
     */
    @Override
    public void setName(String name) {
        this.name = name;

    }

    /**
     * Visit current node with visitor.
     *
     * @param visitor visitor instance
     */
    @Override
    public void accept(Visitor visitor) {

    }

    /**
     * Get count of employees in department.
     *
     * @return value
     */
    @Override
    public int getEmployeeCount() {
        return 0;
    }

    /**
     * Set count of employees in department.
     *
     * @param employeeCount value
     */
    @Override
    public void setEmployeeCount(int employeeCount) {

    }

    /**
     * Get collection of child instances.
     *
     * @return collection of children
     */
    @Override
    public Collection<Department> getChildren() {
        return null;
    }

    /**
     * Add instance as child.
     *
     * @param child instance to add
     */
    @Override
    public void addChild(Department child) {

    }
}
