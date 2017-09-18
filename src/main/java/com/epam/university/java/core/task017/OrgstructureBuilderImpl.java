package com.epam.university.java.core.task017;

import java.util.Collection;

/**
 * Organization structure builder class.
 */
public class OrgstructureBuilderImpl implements OrgstructureBuilder {

    private Organization organization;

    @Override
    public OrganizationBuilder addOrganization() {
        return new OrganizationBuilderImpl();
    }

    @Override
    public DepartmentBuilder addDepartment() {
        return new DepartmentBuilderImpl();
    }

    @Override
    public Organization build() {
        return organization;
    }

    public class OrganizationBuilderImpl implements OrganizationBuilder {

        public OrganizationBuilderImpl() {
            OrgstructureBuilderImpl.this.organization = new OrganizationImpl();
        }

        @Override
        public OrganizationBuilder withName(String organizationName) {
            OrgstructureBuilderImpl.this.organization.setName(organizationName);
            return this;
        }

        @Override
        public OrgstructureBuilder done() {
            return OrgstructureBuilderImpl.this;
        }

    }

    public class DepartmentBuilderImpl implements DepartmentBuilder {

        private Department department;

        public DepartmentBuilderImpl() {
            department = new DepartmentImpl();
        }

        @Override
        public DepartmentBuilder withName(String departmentName) {
            department.setName(departmentName);
            return this;
        }

        @Override
        public DepartmentBuilder withEmployees(int amountOfEmployees) {
            department.setEmployeeCount(amountOfEmployees);
            return this;
        }

        @Override
        public DepartmentBuilder withChild(OrgstructureBuilder builder) {
            final Collection<Department> children = builder.build().getChildren();
            children.forEach(department::addChild);
            return this;
        }

        @Override
        public OrgstructureBuilder done() {
            OrgstructureBuilderImpl.this.organization.addChild(department);
            return OrgstructureBuilderImpl.this;
        }
    }

}