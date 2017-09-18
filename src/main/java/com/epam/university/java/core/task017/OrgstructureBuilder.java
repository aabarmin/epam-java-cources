package com.epam.university.java.core.task017;

/**
 * Organization structure builder class.
 */
public interface OrgstructureBuilder {
    OrganizationBuilder addOrganization();

    DepartmentBuilder addDepartment();

    Organization build();

    interface OrganizationBuilder {
        OrganizationBuilder withName(String organizationName);

        OrgstructureBuilder done();
    }

    interface DepartmentBuilder {
        DepartmentBuilder withName(String departmentName);

        DepartmentBuilder withEmployees(int amountOfEmployees);

        DepartmentBuilder withChild(OrgstructureBuilder builder);

        OrgstructureBuilder done();
    }
}
