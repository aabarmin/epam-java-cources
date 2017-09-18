package com.epam.university.java.core.task017;

/**
 * Visitor and builder patterns.
 */
public interface Task017 {
    /**
     * Find department with visitor.
     * @param organization organization to start with
     * @param visitor visitor to use
     * @return found department
     */
    default Department findDepartment(Organization organization, Visitor visitor) {
        organization.accept(visitor);
        return visitor.getFound();
    }
}
