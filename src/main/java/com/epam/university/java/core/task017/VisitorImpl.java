package com.epam.university.java.core.task017;

import java.util.LinkedList;

/**
 * Visitor implementation.
 */
public class VisitorImpl implements Visitor {

    private VisitorType type;
    private Department found;

    public VisitorImpl(VisitorType type) {
        this.type = type;
    }

    /**
     * Visit department instance.
     * @param department department to visit
     */
    @Override
    public void visit(Department department) {
        if (found == null) {
            found = department;
            return;
        }
        switch (type) {
            case MAXIMAL:
                if (department.getEmployeeCount() > found.getEmployeeCount()) {
                    found = department;
                }
                break;
            case MINIMAL:
                if (department.getEmployeeCount() < found.getEmployeeCount()) {
                    found = department;
                }
                break;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * Visit organization instance.
     * @param organization organization to visit
     */
    @Override
    public void visit(Organization organization) {
        LinkedList<Department> departments = new LinkedList<>(organization.getChildren());
        if (departments.isEmpty()) {
            return;
        }
        if (found == null) {
            found = departments.getFirst();
        }
        for (Department department : departments) {
            visit(department);
        }
    }

    /**
     * Get found department.
     * @return department instance
     */
    @Override
    public Department getFound() {
        return found;
    }

}
