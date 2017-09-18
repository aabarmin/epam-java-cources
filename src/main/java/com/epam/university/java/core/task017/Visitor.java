package com.epam.university.java.core.task017;

/**
 * Visitor interface.
 */
public interface Visitor {
    /**
     * Visit department instance.
     * @param department department to visit
     */
    void visit(Department department);

    /**
     * Visit organization instance.
     * @param organization organization to visit
     */
    void visit(Organization organization);

    /**
     * Get found department.
     * @return department instance
     */
    Department getFound();
}
