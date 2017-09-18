package com.epam.university.java.core.task017;

/**
 * Department model.
 */
public interface Department extends Visitable, Container<Department>, Named {
    /**
     * Get count of employees in department.
     * @return value
     */
    int getEmployeeCount();

    /**
     * Set count of employees in department.
     * @param employeeCount value
     */
    void setEmployeeCount(int employeeCount);
}
